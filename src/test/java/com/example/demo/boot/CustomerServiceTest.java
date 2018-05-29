package com.example.demo.boot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = AppConfiguration.class)
@RunWith(SpringRunner.class)
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void findAll(){
        int size=this.customerService.findAll().size();

        Assert.assertEquals(2,size);
    }
}
