package io.github.jhannes.openapi.conversations.model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lombok.Data;

@Data
public final class ConversationMessageDto implements ConversationMessageInterface {

    private String text;
    private Set<String> tags = new LinkedHashSet<>();

    public boolean hasNoOptionalProperties() {
        return getTags() == null
                && hasNoOptionalPropertiesForConversationMessage()
        ;
    }

    @Override
    public ConversationMessageDto putAll(ConversationMessageInterface o) {
        o.copyToConversationMessage(this);
        return this;
    }

    @Override
    public ConversationMessageDto removeWhereEqual(ConversationMessageInterface o) {
        o.removeWhereEqualFromConversationMessage(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getText() == null) fields.add(prefix + "text");
        return fields;
    }

}