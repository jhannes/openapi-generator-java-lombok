package io.github.jhannes.openapi.conversations.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.*;

@Data
public final class ConversationInfoDto {

    private String title;
    private String summary = null;

    public boolean isEmpty() {
        return getSummary() == null
        ;
    }

    public ConversationInfoDto putAll(ConversationInfoDto o) {
        if (o.getTitle() != null) setTitle(o.getTitle());
        if (o.getSummary() != null) setSummary(o.getSummary());
        return this;
    }

    public ConversationInfoDto removeWhereEqual(ConversationInfoDto o) {
        if (Objects.equals(getSummary(), o.getSummary())) setSummary(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getTitle() == null) fields.add(prefix + "title");
        return fields;
    }

}