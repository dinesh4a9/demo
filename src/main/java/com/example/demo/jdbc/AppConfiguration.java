package com.example.demo.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class AppConfiguration {

    /**
     * Datasource is where we establish the connection configuration witha particular database.
     * define bean names for datasource incase using mulyiple db's
     * use @Qualifier annotation to define the datasource if relates to in a template.
     * @return
     */
    @Bean
    DataSource dataSource(){
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).setName("CUSTOMERS").build();
    }

    /*
    JdbcTemplate is from Spring jdbc , if we use spring jdbc template we avoid boiler plate code such as
     opening and  closing of a connection and sql exceptions will be handled automatically
     ex: database down , duplicate keys etc.
     */
    @Bean
//    @Qualifier("myDB")
    JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
