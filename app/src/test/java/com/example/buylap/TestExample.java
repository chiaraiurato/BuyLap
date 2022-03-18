package com.example.buylap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebElement;

import test.TestSelenium;


public class TestExample {
    @Test
    public void TestExample() throws InterruptedException {
        TestSelenium TestSelenium = new TestSelenium();
        WebElement txtBox = TestSelenium.openDriver();
        String output = txtBox.getText();
        assertEquals(output, "Intel Core i7-11700K @ 3.60GHz");
    }


    @Test
    public void anotherExample(){
        assertEquals("ciao", "ciao");
    }
}
