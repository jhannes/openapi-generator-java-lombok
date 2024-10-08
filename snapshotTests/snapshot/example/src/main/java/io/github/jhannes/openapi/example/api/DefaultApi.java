package io.github.jhannes.openapi.example.api;

import io.github.jhannes.openapi.example.model.*;

import lombok.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.time.*;
import java.util.*;
import java.util.function.*;

import static java.net.URLEncoder.encode;
import static java.nio.charset.StandardCharsets.UTF_8;

public interface DefaultApi {
    /**
     * @param storeId  (path) (required)
     * @param PetDto  (optional)
     */
    void addPet(
            UUID storeId,
            Optional<PetDto> PetDto
    ) throws IOException;
    /**
     * @param petId  (path) (required)
     * @param name Updated name of the pet (required)
     * @param status Updated status of the pet (optional)
     */
    void addPetWithForm(
            UUID petId,
            String name,
            Optional<String> status
    ) throws IOException;

    @Data
    class AddPetWithFormForm {
        private String name;
        private String status;

        public String toUrlEncoded() {
            List<String> parameters = new ArrayList<>();
            if (name != null) parameters.add("name=" + encode(name.toString(), UTF_8));
            if (status != null) parameters.add("status=" + encode(status.toString(), UTF_8));
            return String.join("&", parameters);
        }
    }
    /**
     * @param storeId  (path) (required)
     * @param status  (query) (required)
     * @param bornAfter  (query) (required)
     * @param tags  (query) (optional
     * @return PetDto
     */
    PetDto listPets(
            UUID storeId,
            List<String> status,
            LocalDate bornAfter,
            Optional<List<String>> tags
    ) throws IOException;

    @Data
    class ListPetsQuery {
        private List<String> status;
        private List<String> tags;
        private LocalDate bornAfter;

        public String toUrlEncoded() {
            List<String> parameters = new ArrayList<>();
            if (status != null) parameters.add("status=" + encode(status.toString(), UTF_8));
            if (tags != null) parameters.add("tags=" + encode(tags.toString(), UTF_8));
            if (bornAfter != null) parameters.add("bornAfter=" + encode(bornAfter.toString(), UTF_8));
            return String.join("&", parameters);
        }
    }
}
