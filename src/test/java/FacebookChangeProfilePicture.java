import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

    public class FacebookChangeProfilePicture {

        public static void main(String[] args) {
            // Set up WebDriver (Make sure to replace the path with your actual path to chromedriver)
            System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
            WebDriver driver = new ChromeDriver();

            try {
                // Navigate to Facebook
                driver.get("https://www.facebook.com/");

                // Log in to Facebook
                WebElement email = driver.findElement(By.id("email"));
                WebElement password = driver.findElement(By.id("pass"));
                WebElement loginButton = driver.findElement(By.name("login"));

                email.sendKeys("your_email@example.com");  // Replace with your email
                password.sendKeys("your_password");        // Replace with your password
                loginButton.click();

                // Wait for the profile button to be visible
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Profile']")));

                // Navigate to your profile
                profileButton.click();

                // Wait for the profile picture element to be visible
                WebElement profilePicture = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Change Profile Picture']")));
                profilePicture.click();

                // Click on "Update Profile Picture"
                WebElement updatePictureButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Update profile picture']")));
                updatePictureButton.click();

                // Upload a new profile picture
                WebElement uploadPhotoInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
                uploadPhotoInput.sendKeys("/path/to/your/new/profile/picture.jpg");  // Replace with the path to your new profile picture

                // Confirm the upload (adjust the selector based on Facebook's current UI)
                WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Save']")));
                saveButton.click();

                // Wait for the profile picture to be updated (this might take a few seconds)
                Thread.sleep(5000);  // Simple sleep; better to use WebDriverWait

                // Validate if the profile picture has been changed
                WebElement updatedProfilePicture = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Profile picture']")));
                String srcAfterChange = updatedProfilePicture.getAttribute("src");

                // Check if the profile picture URL has changed (simplified validation)
                if (srcAfterChange.contains("new_profile_picture.jpg")) {  // Simplified check
                    System.out.println("Profile picture has been successfully updated.");
                } else {
                    System.out.println("Failed to update the profile picture.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Close the browser
                driver.quit();
            }
        }
    }

