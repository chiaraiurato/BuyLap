package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {
    public static void main(String[] args) throws Exception {

        openDriver();
    }

    public static String openDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "app/src/androidTest/java/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cpubenchmark.net/cpu_list.php");
        WebElement txtBox=driver.findElement(By.xpath("//*[@id=\"gsc_rsb_st\"]/tbody/tr[1]/td[2]"));
        Thread.sleep(15000);

        return txtBox.getText();


    }


}
