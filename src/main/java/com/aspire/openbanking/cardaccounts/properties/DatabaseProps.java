package com.aspire.openbanking.cardaccounts.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@NoArgsConstructor
//@ConfigurationProperties(prefix = "spring.datasource")
public class DatabaseProps {
    private String url;
    private String username;
    private String password;
}
