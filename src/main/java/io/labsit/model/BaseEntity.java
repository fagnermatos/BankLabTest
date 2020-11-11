package io.labsit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@MappedSuperclass
public class BaseEntity<T extends Serializable> {

    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = IDENTITY)
    private T id;
}
