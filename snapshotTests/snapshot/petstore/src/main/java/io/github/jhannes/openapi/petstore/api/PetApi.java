package io.github.jhannes.openapi.petstore.api;

import io.github.jhannes.openapi.petstore.model.*;

import lombok.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.time.*;
import java.util.*;
import java.util.function.*;

import static java.net.URLEncoder.encode;
import static java.nio.charset.StandardCharsets.UTF_8;

public interface PetApi {
    /**
     * Add a new pet to the store
     * @param PetDto Pet object that needs to be added to the store (optional)
     */
    void addPet(
            Optional<PetDto> PetDto
    ) throws IOException;
    /**
     * Deletes a pet
     * @param petId Pet id to delete (path) (required)
     * @param api_key  (optional)
     */
    void deletePet(
            Long petId,
            Optional<String> api_key
    ) throws IOException;

    @Data
    class DeletePetHeaders {
        private String apiKey;
    }
    /**
     * downloads image
     * @param petId  (path) (required)
     * @return File
     */
    byte[] downloadImage(
            Long petId
    ) throws IOException;
    /**
     * Finds Pets by status
     * Multiple status values can be provided with comma separated strings
     * @param status Status values that need to be considered for filter (query) (optional
     * @return List&lt;PetDto&gt;
     */
    List<PetDto> findPetsByStatus(
            Optional<List<String>> status
    ) throws IOException;

    @Data
    class FindPetsByStatusQuery {
        private List<String> status;

        public String toUrlEncoded() {
            List<String> parameters = new ArrayList<>();
            if (status != null) {
                parameters.add("status=" + encode(status.toString(), UTF_8));
            }
            return String.join("&", parameters);
        }
    }
    /**
     * Finds Pets by tags
     * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     * @param tags Tags to filter by (query) (optional
     * @return List&lt;PetDto&gt;
     * @deprecated
     */
    @Deprecated
    List<PetDto> findPetsByTags(
            Optional<List<String>> tags
    ) throws IOException;

    @Data
    class FindPetsByTagsQuery {
        private List<String> tags;

        public String toUrlEncoded() {
            List<String> parameters = new ArrayList<>();
            if (tags != null) {
                parameters.add("tags=" + encode(tags.toString(), UTF_8));
            }
            return String.join("&", parameters);
        }
    }
    /**
     * Find pet by ID
     * Returns a pet when ID &lt; 10.  ID &gt; 10 or nonintegers will simulate API error conditions
     * @param petId ID of pet that needs to be fetched (path) (required)
     * @return PetDto
     */
    PetDto getPetById(
            Long petId
    ) throws IOException;
    /**
     * Update an existing pet
     * @param PetDto Pet object that needs to be added to the store (optional)
     */
    void updatePet(
            Optional<PetDto> PetDto
    ) throws IOException;
    /**
     * Updates a pet in the store with form data
     * @param petId ID of pet that needs to be updated (path) (required)
     * @param name Updated name of the pet (optional)
     * @param status Updated status of the pet (optional)
     */
    void updatePetWithForm(
            String petId,
            Optional<String> name,
            Optional<String> status
    ) throws IOException;

    @Data
    class UpdatePetWithFormForm {
        private String name;
        private String status;

        public String toUrlEncoded() {
            List<String> parameters = new ArrayList<>();
            if (name != null) {
                parameters.add("name=" + encode(name.toString(), UTF_8));
            }
            if (status != null) {
                parameters.add("status=" + encode(status.toString(), UTF_8));
            }
            return String.join("&", parameters);
        }
    }
    /**
     * uploads an image
     * @param petId ID of pet to update (path) (required)
     * @param additionalMetadata Additional data to pass to server (optional)
     * @param file file to upload (optional)
     */
    void uploadFile(
            Long petId,
            Optional<String> additionalMetadata,
            Optional<File> file
    ) throws IOException;

    @Data
    class UploadFileForm {
        private String additionalMetadata;
        private File _file;

        public String toUrlEncoded() {
            List<String> parameters = new ArrayList<>();
            if (additionalMetadata != null) {
                parameters.add("additionalMetadata=" + encode(additionalMetadata.toString(), UTF_8));
            }
            if (_file != null) {
                parameters.add("file=" + encode(_file.toString(), UTF_8));
            }
            return String.join("&", parameters);
        }
    }
}
