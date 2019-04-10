package com.dwp.datakeyservice;

import static org.junit.Assert.assertNotNull;

import com.dwp.datakeyservice.Controller.DataKeyController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataKeyServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

    @Test
    public void testAppHasAGreeting() {
        DataKeyController classUnderTest = new DataKeyController();
        assertNotNull("app should have a greeting", classUnderTest.Generate());
    }
}