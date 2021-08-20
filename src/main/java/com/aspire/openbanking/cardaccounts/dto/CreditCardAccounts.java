package com.aspire.openbanking.cardaccounts.dto;

import com.aspire.openbanking.cardaccounts.dto.CreditCardAccountResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CreditCardAccounts {
    private UUID customerId;
    private List<CreditCardAccountResponse> accounts = new ArrayList<>();

    public void addAccount(CreditCardAccountResponse account) {
        if (account != null) {
            accounts.add(account);
        }
    }
}
