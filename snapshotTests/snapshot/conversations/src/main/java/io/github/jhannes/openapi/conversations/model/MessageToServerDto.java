package io.github.jhannes.openapi.conversations.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.*;

public sealed interface MessageToServerDto permits CommandToServerDto, RequestToServerDto {


    boolean isEmpty();
    List<String> missingRequiredFields(String prefix);
}