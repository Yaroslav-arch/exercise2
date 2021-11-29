package com.example.exercise2.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Configuration
public class RestTemplateConfiguration {

    private static String scheme;
    private static String neo4jUrl;
    private static String sqlUrl;
    private static String neo4jPort;
    private static String sqlPort;
    private static String urn;

    public RestTemplateConfiguration(@Value("${connection.scheme}") String scheme, @Value("${neo4j.url}") String neo4jUrl, @Value("${sql.url}") String sqlUrl,
                                     @Value("${neo4j.port}") String neo4jPort, @Value("${sql.port}") String sqlPort, @Value("${movie.urn}") String urn) {
        RestTemplateConfiguration.scheme = scheme;
        RestTemplateConfiguration.neo4jUrl = neo4jUrl;
        RestTemplateConfiguration.sqlUrl = sqlUrl;
        RestTemplateConfiguration.neo4jPort = neo4jPort;
        RestTemplateConfiguration.sqlPort = sqlPort;
        RestTemplateConfiguration.urn = urn;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean(name = "neo4jUri")
    public URI neo4jUri() {
        return UriComponentsBuilder.newInstance()
                .scheme(scheme).host(neo4jUrl).port(neo4jPort).path(urn).build().toUri();
    }

    @Bean(name = "sqlUri")
    public URI sqlUri() {
        return UriComponentsBuilder.newInstance()
                .scheme(scheme).host(sqlUrl).port(sqlPort).path(urn).build().toUri();
    }

}
