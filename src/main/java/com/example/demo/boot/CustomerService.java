package com.example.demo.boot;

import com.example.demo.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomerService {

    private JdbcTemplate jdbcTemplate;

    public CustomerService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Collection<Customer> findAll() {
        /*RowMapper<Customer> rowMapper = new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Customer customer =  new Customer();
                customer.setId(rs.getLong(0));
                customer.setEmail(rs.getString(1));
                return customer;
            }
        };*/

//        java 8
        RowMapper<Customer> rowMapper = (rs, i) -> new Customer(rs.getLong("id"), rs.getString("email"));
        return this.jdbcTemplate.query("SELECT * FROM CUSTOMERS", rowMapper);
    }
}
