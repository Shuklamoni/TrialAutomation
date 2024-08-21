import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FaceBookAutomation {


    public static void main(String[]args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\IdeaProjects\\TrialAutomation\\src\\test\\resources\\chromedriver.exe");
        // Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // Disable or enable the notification popup
        Map<String, Object> prefs = new HashMap<>();

        // To block notifications
        prefs.put("profile.default_content_setting_values.notifications", 2); // 1: Allow, 2: Block

        options.setExperimentalOption("prefs", prefs);

        // Launch Chrome with the specified options
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

       try {
           driver.get("https://www.google.com");

          Thread.sleep(5000);

         WebElement textInput =  driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        textInput.sendKeys("https://www.facebook.login" + Keys.ENTER);
        WebElement faceBook = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/login/']"));
        faceBook.click();

           String username = "kalicharan411@yahoo.com";
           String password = "kanchanekta13579";


        WebElement inputUsername = driver.findElement(By.xpath("//input[@type = 'text']"));
        inputUsername.sendKeys(username);

        WebElement inputPassword = driver.findElement(By.xpath("//input[@type = 'password']"));
        inputPassword.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[@id = 'loginbutton']"));
        loginButton.click();
        Thread.sleep(3000);

           WebElement feedStatus = driver.findElement(By.xpath("//div[@class='xi81zsa x1lkfr7t xkjl1po x1mzt3pk xh8yej3 x13faqbe']//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6']"));
          // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", feedStatus);
           feedStatus.click();

           Thread.sleep(2000);


         //WebElement feedStatus = driver.findElement(By.xpath("//div[@class='xi81zsa x1lkfr7t xkjl1po x1mzt3pk xh8yej3 x13faqbe']//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6']"));
        // feedStatus.click();   ////div[@class='xi81zsa x1lkfr7t xkjl1po x1mzt3pk xh8yej3 x13faqbe']//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6']


         WebElement status = driver.findElement(By.xpath("//p[@class='xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8']"));
         status.sendKeys("Hello  ");

         WebElement postButton = driver.findElement(By.xpath("//div[@aria-label='Post']//div[@class='x6s0dn4 x78zum5 xl56j7k x1608yet xljgi0e x1e0frkt']"));
         postButton.click();

           //List<WebElement> posts = driver.findElements(By.cssSelector("#mount_0_0_9M > div > div:nth-child(1) > div > div.x9f619.x1n2onr6.x1ja2u2z > div > div > div.x78zum5.xdt5ytf.x1t2pt76.x1n2onr6.x1ja2u2z.x10cihs4 > div.x9f619.x1n2onr6.x1ja2u2z.x78zum5.x2lah0s.xl56j7k.x1qjc9v5.xozqiw3.x1q0g3np.x1t2pt76.x17upfok > div > div.x9f619.x1n2onr6.x1ja2u2z.x78zum5.x1iyjqo2.xs83m0k.xeuugli.xl56j7k.x1qjc9v5.xozqiw3.x1q0g3np.x1iplk16.x1xfsgkm.xqmdsaz.x1mtsufr.x1w9j1nh > div > div > div > div.x78zum5.x1q0g3np.xl56j7k > div > div.x1hc1fzr.x1unhpq9.x6o7n8i > div > div:nth-child(3) > div:nth-child(1) > div > div > div > div > div > div > div > div > div > div > div > div > div > div:nth-child(13) > div > div > div:nth-child(4) > div > div > div:nth-child(1) > div > div.xq8finb.x16n37ib > div > div:nth-child(1) > div.x1i10hfl.x1qjc9v5.xjbqb8w.xjqpnuy.xa49m3k.xqeqjp1.x2hbi6w.x13fuv20.xu3j5b3.x1q0q8m5.x26u7qi.x972fbf.xcfux6l.x1qhh985.xm0m39n.x9f619.x1ypdohk.xdl72j9.x2lah0s.xe8uvvx.xdj266r.x11i5rnm.xat24cr.x1mh8g0r.x2lwn1j.xeuugli.xexx8yu.x4uap5.x18d9i69.xkhd6sd.x1n2onr6.x16tdsg8.x1hl2dhg.x1ja2u2z.x1t137rt.x1o1ewxj.x3x9cwd.x1e5q0jg.x13rtm0m.x3nfvp2.x1q0g3np.x87ps6o.x1lku1pv.x1a2a7pz.x5ve5x3 > div.x9f619.x1n2onr6.x1ja2u2z.x78zum5.x1r8uery.x1iyjqo2.xs83m0k.xeuugli.xl56j7k.x6s0dn4.xozqiw3.x1q0g3np.xn6708d.x1ye3gou.xexx8yu.xcud41i.x139jcc6.x4cne27.xifccgj.xn3w4p2.xuxw1ft"));
           int postCount = 0;

           while (postCount < 3) {
               // Scroll down slightly to load more posts
               ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
               Thread.sleep(2000); // Wait for the posts to load

               // Re-fetch the list of posts
               posts = driver.findElements(By.cssSelector("div[role='article']"));

               // Check if we have found at least 3 posts
               postCount = posts.size();
           }

           // Scroll to the third post
           WebElement thirdPost = posts.get(2);
           ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", thirdPost);

           // Additional actions on the third post (if needed)
           System.out.println("Scrolled to the third post");


    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Close the browser
        driver.quit();
    }


    }

}
