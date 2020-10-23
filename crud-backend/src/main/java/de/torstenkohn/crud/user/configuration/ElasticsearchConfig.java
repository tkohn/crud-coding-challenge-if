package de.torstenkohn.crud.user.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "de.torstenkohn.crud.elasticsearch")
public class ElasticsearchConfig {
    private String host;
    private int port;

    public void setHost(String host){
        this.host = host;
    }

    public void setPort(int port){
        this.port = port;
    }

    public String hostAndPort() {
        return "%s:%s".formatted(host, port);
    }
}
