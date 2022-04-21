package testsuite;


import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.security.PublicKey;

public class LoginTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    //super class method to open the browser
    public void steUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        //loge in with valid username
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("AmySmith");

        //loge in with valid password
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("welcome123");

        //Login with login button
        WebElement login = driver.findElement(By.xpath("//input[@value='Log In']"));
        login.click();

        //Verify the ‘Accounts Overview’ text is display
        String expectedResult = "Accounts Overview";

        WebElement actualResultElement = driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        String actualResult = actualResultElement.getText();

        //verifying actual outcome with expected
        Assert.assertEquals("Error occurred", expectedResult, actualResult);
    }
    @Test
    public void verifyTheErrorMessage(){
      //  Verify the error message ‘The username and password could not be verified.’
        //loge in with valid username
        WebElement invalidName = driver.findElement(By.xpath("//input[@name='username']"));
        invalidName.sendKeys("AmySmith!!");

        //loge in with valid password
        WebElement invalidPassword = driver.findElement(By.xpath("//input[@name='password']"));
        invalidPassword.sendKeys("welcome12");

        //Login with login button
        WebElement login = driver.findElement(By.xpath("//input[@value='Log In']"));
        login.click();

        String expectedResult = "The username and password could not be verified.";

        WebElement actualResultElement = driver.findElement(By.xpath("//p[@class='error']"));
        String actualResult = actualResultElement.getText();

        //verifying actual outcome with expected
        Assert.assertEquals("Error occurred", expectedResult, actualResult);
    }
    @Test
    public void userShouldLogOutSuccessfully(){
        //loge in with valid username
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("AmySmith");

        //loge in with valid password
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("welcome123");

        //Login with login button
        WebElement login = driver.findElement(By.xpath("//input[@value='Log In']"));
        login.click();

        //log Out like
        WebElement logOut = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
        logOut.click();

        String expectedResult = "Customer Login";

        WebElement actualResultElement = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        String actualResult = actualResultElement.getText();

        Assert.assertEquals("error occurred", expectedResult, actualResult);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }

    }
