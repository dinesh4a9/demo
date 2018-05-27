package com.example.demo.javaconfig;

import com.example.demo.Customer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private final DataSource dataSource;
    public CustomerService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        try{
            Connection connection = dataSource.getConnection();
            Statement statement=connection.createStatement();

            ResultSet rs=statement.executeQuery("SELECT * FROM CUSTOMERS");

            while(rs.next()){
                customerList.add(new Customer(rs.getLong("id"),rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return customerList;
    }
}
