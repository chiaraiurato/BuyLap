package com.example.buylap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static test.TestSelenium.main;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import test.TestSelenium;


public class TestExample {
    @Test
    public void testingExample() {
        TestSelenium testSelenium = new TestSelenium();
        WebElement txtBox = testSelenium.openDriver();
        String output = txtBox.getText();
        assertEquals(output, "Intel Core i7-11700K @ 3.60GHz");
    }


    @Test
    public void anotherExample(){
        assertEquals("ciao", "ciao");
    }
}
