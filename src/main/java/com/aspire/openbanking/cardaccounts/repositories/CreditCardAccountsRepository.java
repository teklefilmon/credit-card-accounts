package com.aspire.openbanking.cardaccounts.repositories;

import com.aspire.openbanking.cardaccounts.domain.CreditCardAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardAccountsRepository extends JpaRepository<CreditCardAccount, Long> {
}
