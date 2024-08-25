package io.github.jhannes.openapi.conversations.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.*;

public sealed interface MessageFromServerDto permits EventFromServerDto, SnapshotSetDto {


    boolean isEmpty();
    List<String> missingRequiredFields(String prefix);
}