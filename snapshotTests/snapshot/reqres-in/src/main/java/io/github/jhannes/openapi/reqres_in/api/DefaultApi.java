package io.github.jhannes.openapi.reqres_in.api;

import io.github.jhannes.openapi.reqres_in.model.*;

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
     * Creates a session
     * @param LoginPostRequestDto  (required)
     * @return LoginPost200ResponseDto
     */
    LoginPost200ResponseDto loginPost(
            LoginPostRequestDto LoginPostRequestDto
    ) throws IOException;
    /**
     * Ends a session
     */
    void logoutPost(
    ) throws IOException;
    /**
     * Creates a user
     * @param LoginPostRequestDto  (required)
     * @return RegisterPost200ResponseDto
     */
    RegisterPost200ResponseDto registerPost(
            LoginPostRequestDto LoginPostRequestDto
    ) throws IOException;
    /**
     * Fetches a user list
     * @param page  (query) (optional)
     * @param per_page  (query) (optional)
     * @return UsersGet200ResponseDto
     */
    UsersGet200ResponseDto usersGet(
            Optional<Integer> page,
            Optional<Integer> per_page
    ) throws IOException;

    @Data
    class UsersGetQuery {
        private Integer page;
        private Integer perPage;

        public String toUrlEncoded() {
            List<String> parameters = new ArrayList<>();
            if (page != null) {
                parameters.add("page=" + encode(page.toString(), UTF_8));
            }
            if (perPage != null) {
                parameters.add("per_page=" + encode(perPage.toString(), UTF_8));
            }
            return String.join("&", parameters);
        }
    }
    /**
     * Deletes a user
     * @param id  (path) (required)
     */
    void usersIdDelete(
            Integer id
    ) throws IOException;
    /**
     * Fetches a user
     * @param id  (path) (required)
     * @return UsersIdGet200ResponseDto
     */
    UsersIdGet200ResponseDto usersIdGet(
            Integer id
    ) throws IOException;
    /**
     * Updates a user
     * @param id  (path) (required)
     * @return UsersIdPut200ResponseDto
     */
    UsersIdPut200ResponseDto usersIdPatch(
            Integer id
    ) throws IOException;
    /**
     * Updates a user
     * @param id  (path) (required)
     * @return UsersIdPut200ResponseDto
     */
    UsersIdPut200ResponseDto usersIdPut(
            Integer id
    ) throws IOException;
}
