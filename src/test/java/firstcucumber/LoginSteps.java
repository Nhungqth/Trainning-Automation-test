package firstcucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginSteps {
    WebDriver driver;

    @Given("Move to login page")
    public void moveToLoginPage() {
        this.driver.get("http://testmaster.vn/Account/Login");
    }

    @When("User abv")
    public void userAbv() {
        WebElement txtUserName = this.driver.findElement(By.cssSelector("input[type=\"email\"]"));
        WebElement txtPassword = this.driver.findElement(By.cssSelector("input[type=\"password\"]"));
        WebElement btnLogin = this.driver.findElement(By.cssSelector("button.btn-login"));
        txtUserName.sendKeys("khanh.tx@live.com");
        txtPassword.sendKeys("abc123");
        btnLogin.click();

    }

    @Then("Abc")
    public void abc() throws InterruptedException {
    Thread.sleep(3000);
        String title = this.driver.getTitle();
        Assert.assertEquals("Home Page[ - Testmaster.vn]",title);
    }

    @And("ancc")
    public void ancc() {
    }


    @When("User attemp to login with {string} and {string}")
    public void userAttempToLoginWithAnd(String username, String password) throws InterruptedException {
        WebElement txtUserName = this.driver.findElement(By.cssSelector("input[type=\"email\"]"));
        WebElement txtPassword = this.driver.findElement(By.cssSelector("input[type=\"password\"]"));
        WebElement btnLogin = this.driver.findElement(By.cssSelector("button.btn-login"));
        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
        Thread.sleep(500);
    }


    @Then("Error {string} will be showed")
    public void errorWillBeShowed(String arg0) {
    }

}
