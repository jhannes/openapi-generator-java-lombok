package io.github.jhannes.openapi.conversations.model;

import lombok.*;

public sealed interface MessageFromServerDto permits EventFromServerDto, SnapshotSetDto {

}