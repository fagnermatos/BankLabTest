package io.labsit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = IDENTITY)
    @Min(value = 1, message = "O id deve ser no mínimo 1.")
    private Long id;
}
