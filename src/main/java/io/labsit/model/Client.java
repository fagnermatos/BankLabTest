package io.labsit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.labsit.model.validator.ValidClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@ValidClient
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
@EqualsAndHashCode(callSuper = true)
public class Client extends BaseEntity {

    @JsonProperty("nome")
    @Column(name = "name", nullable = false)
    @NotNull(message = "{client.name.notnull}")
    @Size(min = 3, max = 20, message = "{client.name.size}")
    private String name;

    @JsonProperty("sobrenome")
    @Column(name = "lastName", nullable = false)
    @NotNull(message = "{client.lastName.notnull}")
    @Size(min = 3, max = 20, message = "{client.lastName.size}")
    private String lastName;

    @CPF
    @JsonProperty("cpf")
    @Column(name = "cpf", unique = true)
    private String cpf;

    @CNPJ
    @JsonProperty("cnpj")
    @Column(name = "cnpj", unique = true)
    private String cnpj;

    @OneToOne
    @MapsId
    @JsonProperty("conta")
    @JoinColumn(name = "account_id")
    @NotNull(message = "{client.account.notnull}")
    private Account account;

}
