import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumTest

{
    @Test
    void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/test/resource/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.torum.com/");
        Thread.sleep(3000);
        WebElement login = driver.findElement(By.xpath("/html[1]/body[1]/div[8]/div[1]"));
        login.click();


        driver.close();



}
}
