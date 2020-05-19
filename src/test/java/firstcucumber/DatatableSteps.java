package firstcucumber;

import com.google.common.collect.Maps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class DatatableSteps {
    WebDriver driver = Hooks.driver;



    @Given("The user input information for 10 record")
    public void theUserInputInformationForRecord(DataTable table) {

        List<Map<String, String>> lst = table.asMaps(String.class, String.class);
        for (Map<String, String> m : lst) {
            System.out.println(m.get("fullname"));
            System.out.println(m.get("dateofbirth"));
        }
    }

    @And("The user find with the keyword {string}")
    public void theUserFindWithTheKeyword(String arg0) {
    }

    @Then("The information about Khan Tran is showed")
    public void theInformationAboutKhanTranIsShowed() {

    }


    List<Map<String, String>> lst;
    @Given("The user add 5 items")
    public void theUserAddItems(DataTable dataTable) throws InterruptedException {
        this.driver.get("http://todomvc.com/examples/react-backbone/");
        Thread.sleep(2000);
        lst = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> m : lst) {
            WebElement txtItem = this.driver.findElement(By.xpath("//input[@class='new-todo']"));
            txtItem.sendKeys(m.get("item"));
            System.out.println(m.get("item"));
            txtItem.sendKeys(Keys.ENTER);
        }

    }

    @When("User refresh browser")
    public void userRefreshBrowser() {
        this.driver.navigate().refresh();
    }

    @Then("Check items are shorted")
    public void checkItemsAreShorted() {
        int index = 1;
        for (Map<String, String> m : lst) {
            WebElement todoItem = this.driver.findElement(By.xpath("(//li//div[@class='view'])[" + index + "]"));
            System.out.println(todoItem.getText());
            Assert.assertEquals(m.get("item"),todoItem.getText());
            index= index+1;
        }


    }
}

