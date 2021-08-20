package com.aspire.openbanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.support.DatabaseStartupValidator;

import javax.sql.DataSource;
import javax.transaction.Transactional;

@SpringBootApplication
public class CreditCardAccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditCardAccountsApplication.class, args);
    }

    @Bean
    public DatabaseStartupValidator databaseStartupValidator(DataSource dataSource) {
        var dsv = new DatabaseStartupValidator();
        dsv.setDataSource(dataSource);
        dsv.setValidationQuery(DatabaseDriver.MYSQL.getValidationQuery());
        return dsv;
    }
}
