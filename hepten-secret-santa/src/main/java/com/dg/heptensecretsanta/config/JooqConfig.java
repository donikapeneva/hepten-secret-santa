package com.dg.heptensecretsanta.config;

import javax.sql.DataSource;

import org.jooq.DSLContext;
import org.jooq.ExecuteContext;
import org.jooq.SQLDialect;
import org.jooq.conf.MappedSchema;
import org.jooq.conf.RenderMapping;
import org.jooq.conf.Settings;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListener;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JooqConfig {
    private AppConfig appConfig;
    private DataSource dataSource;

    @Autowired
    public JooqConfig(AppConfig appConfig, DataSource dataSource) {
        this.appConfig = appConfig;
        this.dataSource = dataSource;
    }

    @Bean
    public DSLContext create() {
        return new DefaultDSLContext(configuration());
    }

    @Bean
    public DataSourceConnectionProvider connectionProvider() {
        return new DataSourceConnectionProvider(
                new TransactionAwareDataSourceProxy(dataSource));
    }

    @Bean
    public ExceptionTranslator exceptionTransformer() {
        return new ExceptionTranslator();
    }

    private DefaultConfiguration configuration() {
        DefaultConfiguration jooqConfig = new DefaultConfiguration();
        jooqConfig.set(connectionProvider());
        jooqConfig.set(new DefaultExecuteListenerProvider(exceptionTransformer()));
        jooqConfig.set(SQLDialect.valueOf(appConfig.getJooq().getSqlDialect()));

        Settings settings = new Settings();
        settings.withRenderMapping(new RenderMapping().withSchemata(
                new MappedSchema().withInput(appConfig.getDb().getSchemaDefault())
                        .withOutput(appConfig.getDb().getSchema())));

        jooqConfig.setSettings(settings);

        return jooqConfig;
    }

    class ExceptionTranslator extends DefaultExecuteListener {
        @Override
        public void exception(ExecuteContext context) {
            SQLDialect dialect = context.configuration().dialect();

            SQLExceptionTranslator translator =
                    new SQLErrorCodeSQLExceptionTranslator(dialect.name());

            context.exception(translator.translate("Access database using jOOQ",
                    context.sql(), context.sqlException()));
        }
    }
}