package com.cartisan.configuration;

import ch.qos.logback.access.jetty.RequestLogImpl;
import com.cartisan.constants.CommonConstants;
import com.cartisan.database.Dao.VehicleDao;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.skife.jdbi.v2.DBI;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@Order(1)
@Profile(CommonConstants.DEFAULT_PROFILE)
public class DependencyConfiguration {
    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder objectMapperBuilder = new Jackson2ObjectMapperBuilder();
        objectMapperBuilder.serializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapperBuilder;
    }

    @Bean
    public NamedParameterJdbcTemplate namedJdbcTempate(DataSource source) {
        return new NamedParameterJdbcTemplate(source);
    }


    @Bean
    public DBI getDBI(DataSource dataSource) {
        return new DBI(dataSource);
    }

    @Bean
    public VehicleDao vehicleDao(DBI dbi) {
        return dbi.onDemand(VehicleDao.class);
    }

    @Bean
    public EmbeddedServletContainerFactory jettyConfigBean() {
        JettyEmbeddedServletContainerFactory jef = new JettyEmbeddedServletContainerFactory();
        jef.addServerCustomizers((JettyServerCustomizer) server -> {
            RequestLogImpl requestLog = new RequestLogImpl_Fix_LOGBACK_1052();
            requestLog.setResource("/src/main/resources/logback-access.xml");
            requestLog.setName("access_logs");
            /* wrap all server handlers with the requestLogHandler */
            RequestLogHandler requestLogHandler = new RequestLogHandler();
            requestLogHandler.setRequestLog(requestLog);
            requestLogHandler.setHandler(server.getHandler());
            server.setHandler(requestLogHandler);
        });
        return jef;
    }
}



