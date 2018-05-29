package com.example.demo.aop;

import com.example.demo.TestConfiguration;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class,TestConfiguration.class})
public class CustomerServiceTest {

    @Rule
    public OutputCapture outputCapture =new OutputCapture();

    @Autowired
    private CustomerService customerService;

    @Test
    public void findAll() throws  Exception{
        int size= this.customerService.findAll().size();
        Assert.assertEquals(2,size);

        String consoleOutput = this.outputCapture.toString();

        Assert.assertThat(consoleOutput, Matchers.containsString("Starting @"));
        Assert.assertThat(consoleOutput, Matchers.containsString("Stopping @"));
    }
}
