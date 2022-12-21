package com.dg.heptensecretsanta.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@ConfigurationProperties(prefix = "config")
@Configuration
public class AppConfig {

    private final Db db = new Db();

    private final Jooq jooq = new Jooq();

    public Db getDb() {
        return db;
    }

    public Jooq getJooq() {
        return jooq;
    }

    @ConfigurationProperties(prefix = "db")
    @Data
    public class Db {
        private String schema;
        private String schemaDefault;
    }

    @ConfigurationProperties(prefix = "jooq")
    @Data
    public class Jooq {
        private String sqlDialect;
    }
}