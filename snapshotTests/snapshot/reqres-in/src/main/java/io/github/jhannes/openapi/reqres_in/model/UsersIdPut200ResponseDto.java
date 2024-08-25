package io.github.jhannes.openapi.reqres_in.model;

import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class UsersIdPut200ResponseDto {

    private String updatedAt = null;

    public boolean isEmpty() {
        return getUpdatedAt() == null
        ;
    }

    public UsersIdPut200ResponseDto putAll(UsersIdPut200ResponseDto o) {
        if (o.getUpdatedAt() != null) setUpdatedAt(o.getUpdatedAt());
        return this;
    }

    public UsersIdPut200ResponseDto removeWhereEqual(UsersIdPut200ResponseDto o) {
        if (Objects.equals(getUpdatedAt(), o.getUpdatedAt())) setUpdatedAt(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return List.of();
    }

}