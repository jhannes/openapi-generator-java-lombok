package io.github.jhannes.openapi.reqres_in.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class UsersGet200ResponseDto {

    private Integer page = null;
    private Integer per_page = null;
    private Integer total = null;
    private Integer total_pages = null;
    private List<UserDto> data = new ArrayList<>();

    public boolean hasNoOptionalProperties() {
        return getPage() == null
                && getPer_page() == null
                && getTotal() == null
                && getTotal_pages() == null
                && getData() == null
        ;
    }

    public UsersGet200ResponseDto putAll(UsersGet200ResponseDto o) {
        o.copyTo_users_get_200_response(this);
        return this;
    }

    public UsersGet200ResponseDto removeWhereEqual(UsersGet200ResponseDto o) {
        if (Objects.equals(getPage(), o.getPage())) setPage(null);
        if (Objects.equals(getPer_page(), o.getPer_page())) setPer_page(null);
        if (Objects.equals(getTotal(), o.getTotal())) setTotal(null);
        if (Objects.equals(getTotal_pages(), o.getTotal_pages())) setTotal_pages(null);
        if (Objects.equals(getData(), o.getData())) setData(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyTo_users_get_200_response(UsersGet200ResponseDto o) {
        if (getPage() != null) o.setPage(getPage());
        if (getPer_page() != null) o.setPer_page(getPer_page());
        if (getTotal() != null) o.setTotal(getTotal());
        if (getTotal_pages() != null) o.setTotal_pages(getTotal_pages());
        if (getData() != null) o.setData(getData());
    }
}