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

public interface UserApi {
    /**
     * Create user
     * This can only be done by the logged in user.
     * @param UserDto Created user object (optional)
     */
    void createUser(
            Optional<UserDto> UserDto
    ) throws IOException;
    /**
     * Creates list of users with given input array
     * @param UserDto List of user object (optional
     */
    void createUsersWithArrayInput(
            Optional<List<UserDto>> UserDto
    ) throws IOException;
    /**
     * Creates list of users with given input array
     * @param UserDto List of user object (optional
     */
    void createUsersWithListInput(
            Optional<List<UserDto>> UserDto
    ) throws IOException;
    /**
     * Delete user
     * This can only be done by the logged in user.
     * @param username The name that needs to be deleted (path) (required)
     */
    void deleteUser(
            String username
    ) throws IOException;
    /**
     * Get user by user name
     * @param username The name that needs to be fetched. Use user1 for testing.  (path) (required)
     * @return UserDto
     */
    UserDto getUserByName(
            String username
    ) throws IOException;
    /**
     * Logs user into the system
     * @param username The user name for login (query) (optional)
     * @param password The password for login in clear text (query) (optional)
     * @return String
     */
    String loginUser(
            Optional<String> username,
            Optional<String> password
    ) throws IOException;

    @Data
    class LoginUserQuery {
        private String username;
        private String password;

        public String toUrlEncoded() {
            List<String> parameters = new ArrayList<>();
            if (username != null) parameters.add("username=" + encode(username.toString(), UTF_8));
            if (password != null) parameters.add("password=" + encode(password.toString(), UTF_8));
            return String.join("&", parameters);
        }
    }
    /**
     * Logs out current logged in user session
     */
    void logoutUser(
    ) throws IOException;
    /**
     * Updated user
     * This can only be done by the logged in user.
     * @param username name that need to be deleted (path) (required)
     * @param UserDto Updated user object (optional)
     */
    void updateUser(
            String username,
            Optional<UserDto> UserDto
    ) throws IOException;
}
