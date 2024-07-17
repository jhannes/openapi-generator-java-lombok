package io.github.jhannes.openapi.conversations.model;

import lombok.*;

public sealed interface MessageToServerDto permits CommandToServerDto, RequestToServerDto {

}