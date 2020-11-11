package io.labsit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

import static javax.persistence.CascadeType.ALL;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
@EqualsAndHashCode(callSuper = true)
public class Account extends BaseEntity<Long> {

    @JsonProperty("numero")
    @Column(name = "number", nullable = false)
    @NotNull(message = "{account.number.notnull}")
    @Min(value = 1, message = "{account.number.min}")
    @Max(value = 999999999, message = "{account.number.max}")
    private Long number;

    @JsonProperty("saldo")
    @Column(name = "balance", nullable = false)
    @NotNull(message = "{account.balance.notnull}")
    @Min(value = 0, message = "{account.balance.min}")
    @Max(value = 250000, message = "{account.balance.max}")
    private BigDecimal balance;

    @ManyToOne(cascade = ALL)
    @JsonProperty("agencia")
    @JoinColumn(name = "agency_id", foreignKey = @ForeignKey(name = "fk_account_agency"))
    @NotNull(message = "{account.agency.notnull}")
    private Agency agency;

    @JsonIgnore
    @PrimaryKeyJoinColumn
    @OneToOne(mappedBy = "account", cascade = ALL)
    private Client client;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;
}
