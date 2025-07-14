package io.github.jhannes.openapi.reqres_in.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class UsersIdGet200ResponseDto {

    private UserDto data = null;

    public boolean hasNoOptionalProperties() {
        return getData() == null
        ;
    }

    public UsersIdGet200ResponseDto putAll(UsersIdGet200ResponseDto o) {
        o.copyTo_users__id__get_200_response(this);
        return this;
    }

    public UsersIdGet200ResponseDto removeWhereEqual(UsersIdGet200ResponseDto o) {
        o.removeWhereEqualFrom_users__id__get_200_response(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyTo_users__id__get_200_response(UsersIdGet200ResponseDto o) {
        if (getData() != null) o.setData(getData());
    }

    public void removeWhereEqualFrom_users__id__get_200_response(UsersIdGet200ResponseDto o) {
        if (Objects.equals(getData(), o.getData())) o.setData(null);
    }
}