package io.github.jhannes.openapi.javalombok;


import org.openapitools.codegen.config.CodegenConfigurator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

public class AbstractSnapshotTest {
    static {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "WARN");
    }

    public static final Path SNAPSHOT_ROOT = Paths.get("snapshotTests");
    public static final Path LOCAL_SNAPSHOT_ROOT = Paths.get("localSnapshotTests");

    protected static CodegenConfigurator createConfigurator(String modelName, Path input, Path outputDir) {
        return createBaseConfigurator(input, outputDir)
                .setModelNameSuffix("Dto")
                .addAdditionalProperty("hideGenerationTimestamp", "true")
                .setGeneratorName("java-lombok")
                .setPackageName("io.github.jhannes.openapi." + modelName);
    }

    static CodegenConfigurator createBaseConfigurator(Path input, Path outputDir) {
        return new CodegenConfigurator()
                .setInputSpec(getInputSpec(input))
                .setOutputDir(outputDir.toString());
    }

    private static String getInputSpec(Path input) {
        String spec = input.toString();
        try {
            if (input.getFileName().toString().endsWith(".link")) {
                String path = Files.readAllLines(input).get(0);
                if (path.matches("https?://.*")) {
                    spec = path;
                } else {
                    spec = Paths.get(path).toString();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return spec.replaceAll("\\\\", "/");
    }

    static void cleanDirectory(Path directory) throws IOException {
        if (Files.isDirectory(directory)) {
            try (Stream<Path> walk = Files.walk(directory)) {
                walk.sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
            }
        }
    }

    protected static String getModelName(Path file) {
        String filename = file.getFileName().toString();
        int lastDot = filename.lastIndexOf('.');
        return lastDot < 0 ? filename : filename.substring(0, lastDot);
    }

}
