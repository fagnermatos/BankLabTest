package io.labsit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.OBJECT;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = OBJECT)
public enum KindTransaction {

    DEPOSIT("Deposito"),
    WITHDRAW("Saque");

    @JsonProperty("descricao")
    private final String description;
}