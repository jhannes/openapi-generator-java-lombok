package io.github.jhannes.openapi.reqres_in.model;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Data
public final class UsersGet200ResponseDto {

    private Integer page = null;
    private Integer per_page = null;
    private Integer total = null;
    private Integer total_pages = null;
    private List<UserDto> data = new ArrayList<>();

}