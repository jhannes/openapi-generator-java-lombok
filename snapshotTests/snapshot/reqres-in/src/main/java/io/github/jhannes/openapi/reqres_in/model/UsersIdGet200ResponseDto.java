package io.github.jhannes.openapi.reqres_in.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class UsersIdGet200ResponseDto {

    private UserDto data = null;

    public boolean isEmpty() {
        return getData() == null
        ;
    }

    public UsersIdGet200ResponseDto putAll(UsersIdGet200ResponseDto o) {
        if (o.getData() != null) setData(o.getData());
        return this;
    }

    public UsersIdGet200ResponseDto removeWhereEqual(UsersIdGet200ResponseDto o) {
        if (Objects.equals(getData(), o.getData())) setData(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return List.of();
    }

}