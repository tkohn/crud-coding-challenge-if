package de.torstenkohn.crud.user.configuration;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "de.torstenkohn.crud.user.repository")
@ComponentScan(basePackages = { "de.torstenkohn.crud.user.service" })
public class RestClientConfig extends AbstractElasticsearchConfiguration {

    private final ElasticsearchConfig elasticsearchConfig;

    public RestClientConfig(ElasticsearchConfig elasticsearchConfig) {
        this.elasticsearchConfig = elasticsearchConfig;
    }

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration =
        ClientConfiguration
        .builder()
        .connectedTo(elasticsearchConfig.hostAndPort())
        .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
