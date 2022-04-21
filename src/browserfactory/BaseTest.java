package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    //Declaring driver
    public static WebDriver driver;

    public void openBrowser(String baseUrl){
      System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
      driver = new ChromeDriver();

        // Launch the URL.
        driver.get(baseUrl);

        //Getting maximum window
        driver.manage().window().maximize();

        //Getting implicet time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser(){

        driver.quit();

    }




}
