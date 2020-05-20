package TikiHomework;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tiki {
    WebDriver driver = Hooks.driver;
    @Given("Move to Tiki home page")
    public void moveToTikiHomePage() throws InterruptedException {
        this.driver.get("https://tiki.vn/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @When("Customer search product which want to buy")
    public void customerSearchProductWhichWantToBuy() throws InterruptedException {
        WebElement txtSearch = this.driver.findElement(By.xpath("//input[@type='text']"));
        txtSearch.sendKeys("kem chống nắng");
        txtSearch.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }

    @Then("Customer choose product to buy")
    public void customerChooseProductToBuy() throws InterruptedException {
        //Chọn sản phẩm thứ 2 trong list kết quả tìm kiếm
        WebElement product = this.driver.findElement(By.xpath("//div[@class='product-box-list']/div[2]//a//div//p[@class='title']"));
        product.click();
        Thread.sleep(3000);
        //Thêm sản phẩm vào giỏ hàng
        WebElement btnAddtocart = this.driver.findElement(By.xpath("//button[@class='btn btn-add-to-cart']"));
        btnAddtocart.click();
        //Check sản phẩm đã có trong giỏ hàng chưa
        Thread.sleep(300);
        WebElement btnViewcart = this.driver.findElement(By.xpath("//a[@class='btn-view-cart']"));
        btnViewcart.click();
        Thread.sleep(3000);
        //Get tên sản phẩm trong giỏ hàng
        WebElement productincart =this.driver.findElement(By.xpath("//a[@class='cart-products__name']"));
        String productnameincart = productincart.getText();
        System.out.println("product name 2 "+productnameincart);
        //Kiểm tra sản phẩm trong giỏ hàng
        Assert.assertTrue(productnameincart.contains("Sunplay Skin Aqua"));


    }
}
