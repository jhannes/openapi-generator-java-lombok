package io.github.jhannes.openapi.typeHierarchyAllOf.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public final class FoodDto implements ItemDto {

    private final String type = "Food";
    private String itemCode;

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public FoodDto putAll(FoodDto o) {
        o.copyToFood(this);
        return this;
    }

    public FoodDto putAll(ItemDto o) {
        o.copyToFood(this);
        return this;
    }

    public FoodDto removeWhereEqual(FoodDto o) {
        o.removeWhereEqualFromFood(this);
        return this;
    }

    public FoodDto removeWhereEqual(ItemDto o) {
        o.removeWhereEqualFromFood(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getItemCode() == null) fields.add(prefix + "itemCode");
        return fields;
    }

    public void copyToFood(FoodDto o) {
        if (getItemCode() != null) o.setItemCode(getItemCode());
    }

    public void removeWhereEqualFromFood(FoodDto o) {
    }
}