package com.dg.heptensecretsanta.vo;

public enum EmailTemplate {
    MISSING_EMAIL("no-email@missing.data");

    String value;

    EmailTemplate(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
