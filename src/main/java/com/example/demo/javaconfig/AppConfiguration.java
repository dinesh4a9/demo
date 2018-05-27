package com.example.demo.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class AppConfiguration {

    @Bean
    public DataSource dataSource(){
        DataSource dataSource = new EmbeddedDatabaseBuilder().setName("CUSTOMERS").setType(EmbeddedDatabaseType.H2).build();
        return dataSource;
    }

    @Bean
    CustomerService customerService(DataSource dataSource){
        return new CustomerService(dataSource);
    }

}
