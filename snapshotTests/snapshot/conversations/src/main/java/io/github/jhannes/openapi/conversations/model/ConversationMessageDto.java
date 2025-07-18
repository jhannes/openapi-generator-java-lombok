package io.github.jhannes.openapi.conversations.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lombok.Data;

@Data
public final class ConversationMessageDto implements ConversationMessageInterface {

    private String text;
    private Set<String> tags = new HashSet<>();

    public boolean hasNoOptionalProperties() {
        return getTags() == null
                && hasNoOptionalPropertiesForConversationMessage()
        ;
    }

    public ConversationMessageDto putAll(ConversationMessageInterface o) {
        o.copyToConversationMessage(this);
        return this;
    }

    public ConversationMessageDto removeWhereEqual(ConversationMessageInterface o) {
        o.removeWhereEqualFromConversationMessage(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getText() == null) fields.add(prefix + "text");
        return fields;
    }

    public void copyToConversationMessage(ConversationMessageDto o) {
        copyToConversationMessageInterface(o);
    }

    public void removeWhereEqualFromConversationMessage(ConversationMessageDto o) {
        removeWhereEqualFromConversationMessageInterface(o);
    }
}