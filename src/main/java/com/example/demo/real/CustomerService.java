package com.example.demo.real;

import com.example.demo.Customer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerService {

    private final DataSource dataSource = new EmbeddedDatabaseBuilder().setName("CUSTOMERS")
            .setType(EmbeddedDatabaseType.H2).build();

    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        DataSource dataSource = customerService.dataSource;

        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);

        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.setScripts(new ClassPathResource("schema.sql"),
                new ClassPathResource("data.sql"));
        initializer.setDatabasePopulator(resourceDatabasePopulator);
        initializer.afterPropertiesSet();

        int count=customerService.findAll().size();

        Assert.isTrue(count==2);
    }

    private Collection<Customer> findAll() {
        List<Customer> customerList = new ArrayList<Customer>();

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs=statement.executeQuery("select * from CUSTOMERS");
            while (rs.next()){
                customerList.add(new Customer(rs.getLong("ID"),rs.getString("EMAIL")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
