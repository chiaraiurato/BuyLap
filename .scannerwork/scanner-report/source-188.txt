package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium {

    public static void main(String[] args) {

    }
    public WebElement openDriver(){
        System.setProperty("webdriver.chrome.driver", "src/androidTest/java/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cpubenchmark.net/cpu_list.php");
        driver.findElement(By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"autocomplete-list\"]")).sendKeys("I7-11700K");
        driver.findElement(By.xpath("//*[@id=\"main_content\"]/div[3]/div[1]/div/form/input[2]")).click();
        return driver.findElement(By.xpath("//*[@id=\"cpu3896\"]/td[1]/a"));
    }


}
