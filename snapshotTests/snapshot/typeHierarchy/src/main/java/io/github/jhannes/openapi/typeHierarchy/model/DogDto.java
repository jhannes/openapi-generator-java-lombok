package io.github.jhannes.openapi.typeHierarchy.model;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public sealed class DogDto extends PetBaseDto implements PetDto permits WorkingDogDto {

    @Getter
    @RequiredArgsConstructor
    public enum BreedEnum {
        DINGO("Dingo"),
        HUSKY("Husky"),
        RETRIEVER("Retriever"),
        SHEPHERD("Shepherd");
    
        private final String value;
    
        @Override
        public String toString() {
            return value;
        }
    }

    private String pet_type = "Dog";
    private Boolean bark = null;
    private BreedEnum breed = null;

}