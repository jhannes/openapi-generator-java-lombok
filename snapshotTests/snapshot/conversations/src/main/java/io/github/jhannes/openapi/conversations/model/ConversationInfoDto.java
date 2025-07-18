package io.github.jhannes.openapi.conversations.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class ConversationInfoDto {

    private String title;
    private String summary = null;

    public boolean hasNoOptionalProperties() {
        return getSummary() == null
        ;
    }

    public ConversationInfoDto putAll(ConversationInfoDto o) {
        o.copyToConversationInfo(this);
        return this;
    }

    public ConversationInfoDto removeWhereEqual(ConversationInfoDto o) {
        o.removeWhereEqualFromConversationInfo(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getTitle() == null) fields.add(prefix + "title");
        return fields;
    }

    public void copyToConversationInfo(ConversationInfoDto o) {
        if (getTitle() != null) o.setTitle(getTitle());
        if (getSummary() != null) o.setSummary(getSummary());
    }

    public void removeWhereEqualFromConversationInfo(ConversationInfoDto o) {
        if (Objects.equals(getSummary(), o.getSummary())) o.setSummary(null);
    }
}