package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;

@Configuration
public class TestConfiguration {

    @Bean
    DataSourceInitializer init(DataSource dataSource){
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();

        dataSourceInitializer.setDataSource(dataSource);
        ResourceDatabasePopulator rdp=new ResourceDatabasePopulator();

        rdp.setScripts(new ClassPathResource("schema.sql"), new ClassPathResource("data.sql"));
        dataSourceInitializer.setDatabasePopulator(rdp);

        return dataSourceInitializer;
    }
}
