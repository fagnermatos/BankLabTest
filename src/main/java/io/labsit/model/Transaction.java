package io.labsit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static javax.persistence.EnumType.STRING;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
@EqualsAndHashCode(callSuper = true)
public class Transaction extends BaseEntity {

    @JsonProperty("data")
    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @JsonProperty("valor")
    @Column(name = "amount", nullable = false)
    @Min(value = 0, message = "{transaction.amount.min}")
    @Max(value = 250000, message = "{transaction.amount.max}")
    private BigDecimal amount;

    @Enumerated(STRING)
    @JsonProperty("tipo")
    @Column(name = "kind", nullable = false)
    private KindTransaction kind;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "fk_account_transaction"))
    private Account account;

    public static Transaction of(BigDecimal amount, KindTransaction kind, Account account) {
        return new Transaction(now(), amount, kind, account);
    }
}
