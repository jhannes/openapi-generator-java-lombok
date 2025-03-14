package io.github.jhannes.openapi.javalombok;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;
import org.openapitools.codegen.ClientOptInput;
import org.openapitools.codegen.DefaultGenerator;
import org.openapitools.codegen.config.CodegenConfigurator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static io.github.jhannes.openapi.javalombok.AbstractSnapshotTest.LOCAL_SNAPSHOT_ROOT;
import static io.github.jhannes.openapi.javalombok.AbstractSnapshotTest.SNAPSHOT_ROOT;
import static io.github.jhannes.openapi.javalombok.AbstractSnapshotTest.cleanDirectory;
import static io.github.jhannes.openapi.javalombok.AbstractSnapshotTest.createConfigurator;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class SnapshotTests {

    @TestFactory
    Stream<DynamicNode> outputsShouldMatchSnapshots() throws IOException {
        List<DynamicNode> testSuites = new ArrayList<>();
        testSuites.add(snapshots(SNAPSHOT_ROOT));
        if (Files.isDirectory(LOCAL_SNAPSHOT_ROOT)) {
            testSuites.add(snapshots(LOCAL_SNAPSHOT_ROOT));
        }
        return testSuites.stream();
    }

    private DynamicNode snapshots(Path testDir) throws IOException {
        return dynamicContainer(
                "Snapshots of " + testDir,
                Files.list(testDir.resolve("input"))
                        .filter(p -> p.toFile().isFile())
                        .map(SnapshotTests::createTestsForSpec)
        );
    }

    public static DynamicNode createTestsForSpec(Path spec) {
        Path outputDir = AbstractSnapshotTest.getOutputDir(spec);
        CodegenConfigurator configurator = createConfigurator(getModelName(spec), AbstractSnapshotTest.getInputSpec(spec), outputDir);
        try {
            cleanDirectory(outputDir);
            generate(configurator);
        } catch (Exception e) {
            return dynamicTest("Generator for " + spec, () -> {
                throw e;
            });
        }
        return SnapshotDiffDynamicTest.compareDirectories(spec, outputDir, AbstractSnapshotTest.getSnapshotDir(spec));
    }

    static void generate(CodegenConfigurator configurator) {
        final ClientOptInput clientOptInput = configurator.toClientOptInput();
        DefaultGenerator generator = new DefaultGenerator();
        generator.opts(clientOptInput).generate();
    }

    public static String getModelName(Path file) {
        String filename = file.getFileName().toString();
        int lastDot = filename.lastIndexOf('.');
        return lastDot < 0 ? filename : filename.substring(0, lastDot);
    }
}
