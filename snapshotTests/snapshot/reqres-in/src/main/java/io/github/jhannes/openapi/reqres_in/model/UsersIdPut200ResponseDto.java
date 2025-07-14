package io.github.jhannes.openapi.reqres_in.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class UsersIdPut200ResponseDto {

    private String updatedAt = null;

    public boolean hasNoOptionalProperties() {
        return getUpdatedAt() == null
        ;
    }

    public UsersIdPut200ResponseDto putAll(UsersIdPut200ResponseDto o) {
        o.copyTo_users__id__put_200_response(this);
        return this;
    }

    public UsersIdPut200ResponseDto removeWhereEqual(UsersIdPut200ResponseDto o) {
        o.removeWhereEqualFrom_users__id__put_200_response(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyTo_users__id__put_200_response(UsersIdPut200ResponseDto o) {
        if (getUpdatedAt() != null) o.setUpdatedAt(getUpdatedAt());
    }

    public void removeWhereEqualFrom_users__id__put_200_response(UsersIdPut200ResponseDto o) {
        if (Objects.equals(getUpdatedAt(), o.getUpdatedAt())) o.setUpdatedAt(null);
    }
}