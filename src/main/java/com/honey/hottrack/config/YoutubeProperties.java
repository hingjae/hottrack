package com.honey.hottrack.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sns.youtube")
public class YoutubeProperties {
    @Getter @Setter private String url;
    @Getter @Setter private String key;
}
