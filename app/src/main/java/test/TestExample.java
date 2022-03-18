package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebElement;

@RunWith(JUnit4.class)
public class TestExample {
    @Test
    public void TestExample() throws InterruptedException {
        TestSelenium testSelenium = new TestSelenium();
        WebElement txtBox = testSelenium.openDriver();
        String output = txtBox.getText();
        int numberWord = Integer.parseInt(output);
        System.out.println(numberWord);
        assertTrue(" (" + numberWord + ") should be greater than (" + 800 + ")", numberWord > 800);
    }
}
