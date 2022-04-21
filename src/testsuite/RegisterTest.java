package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){

        //Getting registration link
        WebElement registerLink = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        registerLink.click();

        //Verify the text ‘Signing up is easy!’
        String expectedResult = "Signing up is easy!";

        WebElement actualResultElement = driver.findElement(By.xpath("//h1[@class='title']"));
        String actualResult = actualResultElement.getText();

        Assert.assertEquals("Message not found", expectedResult,actualResult);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        //Getting registration link
        WebElement registerLink = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        registerLink.click();

        WebElement firstName = driver.findElement(By.id("customer.firstName"));
        firstName.sendKeys("Amy");
        WebElement lastName = driver.findElement(By.name("customer.lastName"));
        lastName.sendKeys("Smith");
        WebElement address = driver.findElement(By.name("customer.address.street"));
        address.sendKeys("3, Station Road");
        WebElement city = driver.findElement(By.id("customer.address.city"));
        city.sendKeys("London");
        WebElement state = driver.findElement(By.id("customer.address.state"));
        state.sendKeys("England");
        WebElement zipCode = driver.findElement(By.name("customer.address.zipCode"));
        zipCode.sendKeys("AB42 XYZ");
        WebElement phone = driver.findElement(By.name("customer.phoneNumber"));
        phone.sendKeys("03587495022");
        WebElement ssn = driver.findElement(By.id("customer.ssn"));
        ssn.sendKeys("007");
        WebElement userName = driver.findElement(By.id("customer.username"));
        userName.sendKeys("AmySmith03");
        WebElement passWord = driver.findElement(By.id("customer.password"));
        passWord.sendKeys("welcome123!");
        WebElement confirm = driver.findElement(By.name("repeatedPassword"));
        confirm.sendKeys("welcome123!");
        WebElement registerButton = driver.findElement(By.xpath("//input[@value='Register']"));
        registerButton.click();

        //Verify the text 'Your account was created successfully. You are now logged in.’
        //Your account was created successfully. You are now logged in.
        String expectedResult = "Your account was created successfully. You are now logged in.";

        WebElement actualResultElement = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in.')]"));
        String actualResult = actualResultElement.getText();

        Assert.assertEquals("error occurred" , expectedResult, actualResult);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
