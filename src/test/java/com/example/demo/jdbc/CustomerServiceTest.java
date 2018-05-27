package com.example.demo.jdbc;

import com.example.demo.Customer;
import com.example.demo.TestConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class, TestConfiguration.class})
public class CustomerServiceTest {
    @Autowired
    CustomerService customerService;

    @Test
    public void findAllTest(){
        int size =customerService.findAll().size();
        Assert.assertEquals(2,size);
    }

}
