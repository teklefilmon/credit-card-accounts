package com.aspire.openbanking.cardaccounts.dto;

import com.aspire.openbanking.cardaccounts.domain.AccountStatus;
import com.aspire.openbanking.cardaccounts.domain.AccountType;
import com.aspire.openbanking.cardaccounts.domain.CreditCardAccount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class CreditCardAccountResponse {
    private UUID accountId;
    private String accountNumber;
    private AccountType accountType;
    private AccountStatus accountStatus;

    public static CreditCardAccountResponse from(CreditCardAccount account) {
        CreditCardAccountResponse creditCardAccountResponse = new CreditCardAccountResponse();
        creditCardAccountResponse.setAccountId(account.getAccountId());
        creditCardAccountResponse.setAccountNumber(account.getAccountNumber());
        creditCardAccountResponse.setAccountType(account.getAccountType());
        creditCardAccountResponse.setAccountStatus(account.getAccountStatus());
        return creditCardAccountResponse;
    }
}
