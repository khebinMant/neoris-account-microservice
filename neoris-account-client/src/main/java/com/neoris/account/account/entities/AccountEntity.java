package com.neoris.account.account.entities;

import com.neoris.account.common.entities.AbstractBaseAuditable;
import com.neoris.account.model.Client;
import com.neoris.account.movements.entities.MovementsEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/*
 * All the Auditory fields are in the AbstractBaseAuditable class
 * included status as a string value 1 to active 0 inactive
 *  in this case Person Entity al ready extends AbstractBaseAuditable
 * */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table( name = "account", schema = "account")
public class AccountEntity extends AbstractBaseAuditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false, updatable = false)
    private Long accountId;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "opening_balance")
    private Long openingBalance;

    @Column(name = "client_id")
    private Long clientId;

    @Transient
    private Client client;
}
