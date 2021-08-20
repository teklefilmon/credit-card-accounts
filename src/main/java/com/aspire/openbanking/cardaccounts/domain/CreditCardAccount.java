package com.aspire.openbanking.cardaccounts.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CREDIT_CARD_ACCOUNTS")
public class CreditCardAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ACCOUNT_ID")
    private UUID accountId;
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name = "ACCOUNT_TYPE")
    private AccountType accountType;
    @Column(name = "ACCOUNT_STATUS")
    private AccountStatus accountStatus;
}
