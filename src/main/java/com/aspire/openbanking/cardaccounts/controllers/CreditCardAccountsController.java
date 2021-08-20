package com.aspire.openbanking.cardaccounts.controllers;

import com.aspire.openbanking.cardaccounts.domain.AccountStatus;
import com.aspire.openbanking.cardaccounts.domain.AccountType;
import com.aspire.openbanking.cardaccounts.domain.CreditCardAccount;
import com.aspire.openbanking.cardaccounts.dto.CreditCardAccounts;
import com.aspire.openbanking.cardaccounts.dto.CreditCardAccountResponse;
import com.aspire.openbanking.cardaccounts.repositories.CreditCardAccountsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@Log4j2
public class CreditCardAccountsController {

    private final CreditCardAccountsRepository repository;

    public CreditCardAccountsController(CreditCardAccountsRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/v1/creditcard/accounts/details", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCardAccounts> getCreditCardAccountsDetails() {
        List<CreditCardAccount> accounts = repository.findAll();
        List<CreditCardAccountResponse> accountResponses = repository.findAll().stream()
                                         .map(CreditCardAccountResponse::from)
                                         .collect(Collectors.toList());
        CreditCardAccounts response = new CreditCardAccounts();
        response.setCustomerId(UUID.randomUUID());
        accountResponses.forEach(response::addAccount);
        return ResponseEntity.ok(response);
    }

    @EventListener
    @Transactional
    public void onApplicationReady(ApplicationReadyEvent event) {
        CreditCardAccount account = new CreditCardAccount();
        account.setAccountId(UUID.randomUUID());
        account.setAccountNumber("987654355");
        account.setAccountType(AccountType.CREDIT_CARD);
        account.setAccountStatus(AccountStatus.ACTIVE);
        this.repository.save(account);
    }
}
