package io.github.jhannes.openapi.javalombok.demo;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EventSourcingTest {

    public enum GenderDto {MALE, FEMALE, OTHER, UNSPECIFIED}

    public interface DataTransferObject<T extends DataTransferObject> {
        boolean isEmpty();

        default List<String> missingRequiredFields() {
            return missingRequiredFields("");
        }

        List<String> missingRequiredFields(String prefix);

        T putAll(T o);

        T removeWhereEqual(T o);
    }

    public interface PersonInterface extends DataTransferObject<PersonInterface> {
        String getFirstName();
        PersonInterface setFirstName(String firstName);

        String getLastName();
        PersonInterface setLastName(String lastName);

        GenderDto getGender();
        PersonInterface setGender(GenderDto gender);

        AddressDto getAddress();
        PersonInterface setAddress(AddressDto address);

        PersonInterface removeWhereEqual(PersonInterface o);

        PersonInterface putAll(PersonInterface person);

        void removeWhereEqualFromPersonDto(PersonDto o);

        void removeWhereEqualFromPersonSnapshot(PersonSnapshotDto o);

        default void copyToPersonInterface(PersonInterface o) {
            if (getFirstName() != null) o.setFirstName(getFirstName());
            if (getLastName() != null) o.setLastName(getLastName());
            if (getGender() != null) o.setGender(getGender());
            if (getAddress() != null) o.setAddress(getAddress());
        }

        default void removeWhereEqualFromPersonInterface(PersonInterface o) {
            if (Objects.equals(getAddress(), o.getAddress())) o.setAddress(null);
            if (Objects.equals(getFirstName(), o.getFirstName())) o.setFirstName(null);
            if (Objects.equals(getLastName(), o.getLastName())) o.setLastName(null);
            if (Objects.equals(getGender(), o.getGender())) o.setGender(null);
        }

        boolean isEmpty();

        default boolean isPersonEmpty() {
            return getFirstName() == null
                   && getLastName() == null
                   && getGender() == null
                   && getAddress() == null;
        }

        void copyToPersonSnapshot(PersonSnapshotDto o);

        void copyToPerson(PersonDto o);

        default List<String> missingRequiredFields(String prefix) {
            var result = new ArrayList<String>();
            if (getAddress() != null) result.addAll(getAddress().missingRequiredFields(prefix + "address."));
            return result;
        }
    }

    @Data
    public static class AddressDto implements DataTransferObject<AddressDto> {
        private String street;
        private Integer houseNumber;
        private String postalCode;

        public List<String> missingRequiredFields(String prefix) {
            var result = new ArrayList<String>();
            if (getStreet() == null) result.add(prefix + "street");
            if (getHouseNumber() == null) result.add(prefix + "houseNumber");
            if (getPostalCode() == null) result.add(prefix + "postalCode");
            return result;
        }

        @Override
        public AddressDto putAll(AddressDto o) {
            if (o.getStreet() != null) o.setStreet(getStreet());
            if (o.getHouseNumber() != null) o.setHouseNumber(getHouseNumber());
            if (o.getPostalCode() != null) o.setPostalCode(getPostalCode());
            return this;
        }

        @Override
        public AddressDto removeWhereEqual(AddressDto o) {
            return this;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }

    public interface ChangeTrackedInterface {
        Instant getCreatedAt();

        ChangeTrackedInterface setCreatedAt(Instant createdAt);

        Instant getUpdatedAt();

        ChangeTrackedInterface setUpdatedAt(Instant updatedAt);

        ChangeTrackedInterface putAll(ChangeTrackedInterface o);

        void copyToPersonSnapshot(PersonSnapshotDto o);

        void copyToChangeTrackedDto(ChangeTrackedDto changeTrackedDto);

        default void copyToChangeTrackedInterface(ChangeTrackedInterface o) {
            if (getCreatedAt() != null) o.setCreatedAt(getCreatedAt());
            if (getUpdatedAt() != null) o.setUpdatedAt(getUpdatedAt());
        }

        default void removeWhereEqualFromChangeTrackedInterface(PersonSnapshotDto o) {
            if (Objects.equals(getCreatedAt(), o.getCreatedAt())) o.setCreatedAt(null);
            if (Objects.equals(getUpdatedAt(), o.getUpdatedAt())) o.setUpdatedAt(null);
        }

        default boolean isChangeTrackedEmpty() {
            return getCreatedAt() == null
                    && getUpdatedAt() == null;
        }
    }

    @Data
    public static class PersonSnapshotDto implements PersonInterface, ChangeTrackedInterface {
        private String firstName;
        private String lastName;
        private GenderDto gender;
        private AddressDto address;
        private Instant createdAt;
        private Instant updatedAt;

        public PersonSnapshotDto putAll(PersonSnapshotDto o) {
            o.copyToPersonSnapshot(this);
            return this;
        }

        @Override
        public PersonSnapshotDto putAll(ChangeTrackedInterface o) {
            o.copyToPersonSnapshot(this);
            return this;
        }

        @Override
        public PersonSnapshotDto putAll(PersonInterface o) {
            o.copyToPersonSnapshot(this);
            return this;
        }

        @Override
        public boolean isEmpty() {
            return isPersonEmpty() && isChangeTrackedEmpty();
        }

        @Override
        public List<String> missingRequiredFields(String prefix) {
            var result = new ArrayList<String>();
            if (getAddress() != null) result.addAll(getAddress().missingRequiredFields(prefix + "address."));
            if (getFirstName() == null) result.add(prefix + "firstName");
            if (getLastName() == null) result.add(prefix + "lastName");
            if (getGender() == null) result.add(prefix + "gender");
            return result;
        }

        @Override
        public PersonSnapshotDto removeWhereEqual(PersonInterface o) {
            o.removeWhereEqualFromPersonSnapshot(this);
            return this;
        }

        @Override
        public void removeWhereEqualFromPersonDto(PersonDto o) {
            removeWhereEqualFromPersonInterface(o);
        }

        @Override
        public void removeWhereEqualFromPersonSnapshot(PersonSnapshotDto o) {
            removeWhereEqualFromPersonInterface(o);
            removeWhereEqualFromChangeTrackedInterface(o);
        }

        @Override
        public void copyToPersonSnapshot(PersonSnapshotDto o) {
            copyToPersonInterface(o);
            copyToChangeTrackedInterface(o);
        }

        @Override
        public void copyToPerson(PersonDto o) {
            copyToPersonInterface(o);
        }

        @Override
        public void copyToChangeTrackedDto(ChangeTrackedDto o) {
            copyToChangeTrackedInterface(o);
        }
    }

    @Data
    public static class PersonDto implements PersonInterface {
        private String firstName;
        private String lastName;
        private GenderDto gender;
        private AddressDto address;

        @Override
        public PersonDto putAll(PersonInterface o) {
            o.copyToPerson(this);
            return this;
        }

        @Override
        public List<String> missingRequiredFields(String prefix) {
            return new ArrayList<>();
        }

        @Override
        public void copyToPersonSnapshot(PersonSnapshotDto o) {
            copyToPersonInterface(o);
        }

        @Override
        public void copyToPerson(PersonDto o) {
            copyToPersonInterface(o);
        }

        @Override
        public PersonDto removeWhereEqual(PersonInterface o) {
            o.removeWhereEqualFromPersonDto(this);
            return this;
        }

        @Override
        public void removeWhereEqualFromPersonDto(PersonDto o) {
            removeWhereEqualFromPersonInterface(o);
        }

        @Override
        public void removeWhereEqualFromPersonSnapshot(PersonSnapshotDto o) {
            removeWhereEqualFromPersonInterface(o);
        }

        @Override
        public boolean isEmpty() {
            return isPersonEmpty();
        }
    }

    @Data
    public static class ChangeTrackedDto implements ChangeTrackedInterface {
        private Instant createdAt;
        private Instant updatedAt;

        public ChangeTrackedDto putAll(ChangeTrackedInterface o) {
            o.copyToChangeTrackedDto(this);
            return this;
        }

        @Override
        public void copyToChangeTrackedDto(ChangeTrackedDto o) {
            copyToChangeTrackedInterface(o);
        }

        @Override
        public void copyToPersonSnapshot(PersonSnapshotDto o) {
            copyToChangeTrackedInterface(o);
        }
    }

    @Data
    public static class UpdatePersonEventDto {
        private Instant timestamp;
        private PersonDto person;
    }

    @Data
    public static class AuditEventDto {
        private PersonSnapshotDto originalSnapshot;
        private PersonSnapshotDto finalSnapshot;
        private ChangeTrackedDto changeTracked;
        private PersonDto minimizedDelta;
    }


    private final ZoneOffset offset = ZoneOffset.ofHours(5);

    @Test
    void shouldCreateUsefulMethods() {
        var day = LocalDate.of(2024, 1, 1);
        var createdTime = day.atTime(LocalTime.of(8, 1)).toInstant(offset);
        var originalUpdatedTime = day.atTime(LocalTime.of(8, 8)).toInstant(offset);
        var finalUpdatedTime = day.atTime(LocalTime.of(8, 8)).toInstant(offset);

        var originalFirstName = "John";
        var unchangedLastName = "Doe";
        var updatedFirstName = "Jane";

        var originalPerson = new PersonSnapshotDto()
                .setCreatedAt(createdTime)
                .setUpdatedAt(originalUpdatedTime)
                .setFirstName(originalFirstName)
                .setLastName(unchangedLastName)
                .setGender(GenderDto.MALE);

        var event = new UpdatePersonEventDto().setTimestamp(finalUpdatedTime).setPerson(new PersonDto()
                .setFirstName(updatedFirstName)
                .setLastName(unchangedLastName)
                .setGender(GenderDto.FEMALE)
        );

        var auditEvent = reduce(originalPerson, event);
        assertThat(auditEvent.getOriginalSnapshot())
                .isEqualTo(new PersonSnapshotDto()
                        .setCreatedAt(createdTime)
                        .setUpdatedAt(originalUpdatedTime)
                        .setFirstName(originalFirstName)
                        .setLastName(unchangedLastName)
                        .setGender(GenderDto.MALE));
        assertThat(auditEvent.getMinimizedDelta())
                .isEqualTo(new PersonDto().setFirstName(updatedFirstName).setGender(GenderDto.FEMALE));
        assertThat(auditEvent.getFinalSnapshot())
                .isEqualTo(new PersonSnapshotDto()
                        .setCreatedAt(createdTime)
                        .setUpdatedAt(originalUpdatedTime)
                        .setFirstName(updatedFirstName)
                        .setLastName(unchangedLastName)
                        .setGender(GenderDto.FEMALE));

        assertThat(reduce(auditEvent.getFinalSnapshot(), event))
                .isNull();
    }


    @Test
    void shouldGenerateMissingRequiredFields() {
        assertThatThrownBy(() -> reduce(new PersonSnapshotDto(), new UpdatePersonEventDto()
                .setPerson(new PersonDto().setLastName("Doe"))
        )).hasMessage("Missing required fields in person snapshot: [firstName, gender]");
    }

    @Test
    void shouldGenerateMissingRequiredNestedFields() {
        assertThatThrownBy(() -> reduce(
                new PersonSnapshotDto().setFirstName("John").setLastName("Doe").setGender(GenderDto.MALE),
                new UpdatePersonEventDto().setPerson(new PersonDto().setAddress(new AddressDto().setStreet("A Street").setHouseNumber(1)))
        )).hasMessage("Missing required fields in person snapshot: [address.postalCode]");
    }


    private AuditEventDto reduce(PersonSnapshotDto originalPerson, UpdatePersonEventDto event) {
        var changeTracked = new ChangeTrackedDto()
                .putAll(originalPerson)
                .setUpdatedAt(event.getTimestamp());
        var minimizedDelta = event.getPerson().removeWhereEqual(originalPerson);
        if (minimizedDelta.isEmpty()) {
            return null;
        }
        var finalSnapshot = new PersonSnapshotDto()
                .putAll(originalPerson)
                .putAll(changeTracked)
                .putAll(minimizedDelta);

        if (!finalSnapshot.missingRequiredFields().isEmpty()) {
            throw new IllegalStateException("Missing required fields in person snapshot: " + finalSnapshot.missingRequiredFields());
        }

        return new AuditEventDto()
                .setOriginalSnapshot(originalPerson)
                .setChangeTracked(changeTracked)
                .setMinimizedDelta(minimizedDelta)
                .setFinalSnapshot(finalSnapshot);
    }
}
