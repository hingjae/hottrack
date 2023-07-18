package com.honey.hottrack.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sns.key")
public class KeyProperties {
    @Getter @Setter private String youtube;
}
