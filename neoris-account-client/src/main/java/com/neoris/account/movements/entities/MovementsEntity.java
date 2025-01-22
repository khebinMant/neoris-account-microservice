package com.neoris.account.movements.entities;

import com.neoris.account.account.entities.AccountEntity;
import com.neoris.account.common.entities.AbstractBaseAuditable;
import com.neoris.account.model.Client;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/*
 * All the Auditory fields are in the AbstractBaseAuditable class
 * included status as a string value 1 to active 0 inactive
 * */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table( name = "movement", schema = "account")
public class MovementsEntity extends AbstractBaseAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movement_id", nullable = false, updatable = false)
    private Long movementId;

    @Column(name = "movement_date")
    private Date movementDate;

    @Column(name = "movement_type")
    private String movementType;

    @Column(name = "transaction_value")
    private Long transactionValue;

    @Column(name = "balance")
    private Long balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity accountEntity;
}
