package io.github.jhannes.openapi.bigExample.model;

import java.math.BigDecimal;
import java.net.URI;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;

import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

/**
 * Model tests for Sample API
 */
public class SampleData {
    protected final Random random;

    public SampleData(Random random) {
        this.random = random;
    }

    public SampleData(long seed) {
        this(new Random(seed));
    }

    protected final Map<String, Supplier<String>> dataFormatFactories = new HashMap<>(Map.of(
        "email", this::randomEmail,
        "phone", this::randomPhoneNumber
    ));
    protected final Map<String, Supplier<String>> propertyNameFactories = new HashMap<>(Map.of(
        "givenName", this::randomGivenName,
        "familyName", this::randomFamilyName,
        "personName", this::randomPersonName
    ));
    
    public <T> List<T> sampleList(Supplier<T> supplier, String propertyName) {
        return sampleList(supplier, propertyName, 1, 4);
    }
    
    public <T> List<T> sampleList(Supplier<T> supplier) {
        return sampleList(supplier, 1, 4);
    }
    
    public <T> List<T> sampleList(Supplier<T> supplier, String propertyName, int min, int max) {
        return sampleList(supplier, min, max);
    }
    
    public <T> List<T> sampleList(Supplier<T> supplier, int min, int max) {
        List<T> result = new ArrayList<>();
        int count = min + random.nextInt(max - min);
        for (int i=0; i<count; i++) {
            result.add(supplier.get());
        }
        return result;
    }
    
    public <T> Set<T> sampleSet(Supplier<T> supplier, String propertyName) {
        return sampleSet(supplier, propertyName, 1, 4);
    }
    
    public <T> Set<T> sampleSet(Supplier<T> supplier) {
        return sampleSet(supplier, 1, 4);
    }
    
    public <T> Set<T> sampleSet(Supplier<T> supplier, String propertyName, int min, int max) {
        return sampleSet(supplier, min, max);
    }
    
    public <T> Set<T> sampleSet(Supplier<T> supplier, int min, int max) {
        Set<T> result = new HashSet<>();
        int count = min + random.nextInt(max - min);
        for (int i=0; i<count; i++) {
            result.add(supplier.get());
        }
        return result;
    }
    
    public <T> List<T> pickSome(T[] alternatives) {
        return pickSome(alternatives, 1, 4);
    }
    
    public <T> List<T> pickSome(T[] alternatives, int min, int max) {
        int count = min + random.nextInt(max - min);
        List<T> result = new ArrayList<>(List.of(alternatives));
        Collections.shuffle(result);
        return result.subList(0, count);
    }
    
    public <T> Set<T> pickSubset(T[] alternatives) {
        return new HashSet<>(pickSome(alternatives, 1, 4));
    }
    
    public <T> Set<T> pickSubset(T[] alternatives, int min, int max) {
        return new HashSet<>(pickSome(alternatives, min, max));
    }
    
    public <T> Map<String, T> sampleMap(Supplier<T> supplier, String propertyName) {
        return sampleMap(supplier, propertyName, 1, 4);
    }
    
    public <T> Map<String, T> sampleMap(Supplier<T> supplier, String propertyName, int min, int max) {
        Map<String, T> result = new HashMap<>();
        int count = min + random.nextInt(max - min);
        for (int i=0; i<count; i++) {
            result.put(sampleString(propertyName), supplier.get());
        }
        return result;
    }
    
    public String sampleString(String propertyName, String dataFormat) {
        if (dataFormatFactories.containsKey(dataFormat)) {
            return dataFormatFactories.get(dataFormat).get();
        }
        if (propertyNameFactories.containsKey(propertyName)) {
            return propertyNameFactories.get(propertyName).get();
        }
        return "str" + sampleUUID(propertyName);
    }
    
    public String sampleString(String propertyName) {
        return sampleString(propertyName, null);
    }
    
    public UUID sampleUUID(String propertyName) {
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        return UUID.nameUUIDFromBytes(bytes);
    }
    
    public Long sampleLong(String propertyName) {
        return random.nextLong() % 10000L;
    }
    
    public Integer sampleInteger(String propertyName) {
        return random.nextInt(10000);
    }
    
    public BigDecimal sampleBigDecimal(String propertyName) {
        return BigDecimal.valueOf(sampleDouble(propertyName));
    }
    
    public Double sampleDouble(String propertyName) {
        return random.nextDouble() * 10000.0;
    }
    
    public Boolean sampleBoolean(String propertyName) {
        return random.nextBoolean();
    }
    
    public Object sampleObject(String propertyName) {
        Map<String, String> result = new HashMap<>();
        result.put(sampleString(propertyName + ".key"), sampleString(propertyName + ".value"));
        return result;
    }
    
    public LocalDate sampleLocalDate(String propertyName) {
        return LocalDate.of(2022, 1, 1).plusDays(random.nextInt(1000));
    }
    
    public LocalTime sampleLocalTime(String propertyName) {
        return LocalTime.of(0, 0).plusMinutes(random.nextInt(24*60));
    }
    
    public LocalDateTime sampleLocalDateTime(String propertyName) {
        return LocalDateTime.of(
            sampleLocalDate(propertyName), sampleLocalTime(propertyName)
        );
    }
    
    public ZoneId sampleZoneId(String propertyName) {
        return ZoneId.of(pickOne(ZoneId.getAvailableZoneIds()));
    }
    
    public ZonedDateTime sampleZonedDateTime(String propertyName) {
        return ZonedDateTime.of(
            sampleLocalDateTime(propertyName), sampleZoneId(propertyName)
        );
    }
    
    public OffsetDateTime sampleOffsetDateTime(String propertyName) {
        return sampleZonedDateTime(propertyName).toOffsetDateTime();
    }
    
    public Instant sampleInstant(String propertyName) {
        return sampleZonedDateTime(propertyName).toInstant();
    }
    
    public URI sampleURI(String propertyName) {
        return asURI("https://" + randomDomainName());
    }
    
    public String randomDomainName() {
        return pickOne(List.of("a", "b", "c")) +
            ".example." +
            pickOne(List.of("com", "net", "io"));
    }
    
    public String randomEmail() {
        return (
            randomGivenName().toLowerCase() +
            "." +
            randomFamilyName().toLowerCase() +
            "@" +
            randomDomainName()
        );
    }
    
    public String randomPersonName() {
        return randomGivenName() + " " + randomFamilyName();
    }
    
    public String randomGivenName() {
        return pickOne(List.of("James", "Mary", "John", "Patricia", "Robert", "Jennifer", "Linda"));
    }
    
    public String randomFamilyName() {
        return pickOne(List.of("Smith", "Williams", "Johnson", "Jones", "Brown", "Davis", "Wilson"));
    }
    
    public String randomPhoneNumber() {
        return "636-555-" + (1000 + random.nextInt(9000));
    }
    
    public <T> T pickOne(T[] alternatives) {
        return alternatives[random.nextInt(alternatives.length)];
    }
    
    public <T> T pickOne(List<T> alternatives) {
        return alternatives.get(random.nextInt(alternatives.size()));
    }
    
    public <T> T pickOne(Set<T> alternatives) {
        return pickOne(new ArrayList<>(alternatives));
    }
    
    public static URI asURI(String uri) {
        try {
            return new URI(uri);
        } catch (java.net.URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
