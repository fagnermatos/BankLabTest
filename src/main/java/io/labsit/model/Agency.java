package io.labsit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "agency")
@EqualsAndHashCode(callSuper = true)
public class Agency extends BaseEntity {

    @JsonProperty("numero")
    @Column(name = "number", nullable = false, unique = true)
    @NotNull(message = "{agency.number.notnull}")
    @Min(value = 1, message = "{agency.number.min}")
    @Max(value = 9999, message = "{agency.number.max}")
    private Integer number;
}
