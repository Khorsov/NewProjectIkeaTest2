package newProjectIkeaTest.step_definitions;
import java.awt.*;

import io.cucumber.java.en.*;
import newProjectIkeaTest.pages.MainPage;
import newProjectIkeaTest.utilities.BrowserUtils;
import newProjectIkeaTest.utilities.ConfigurationReader;
import newProjectIkeaTest.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsToShoppingCart extends MainPage {

    WebDriverWait wait = new WebDriverWait(driver,5);
    Actions action = new Actions(driver);
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='hnf-overlay']")));

    public ProductsToShoppingCart() throws AWTException {
    }

    @Given("the user is on the main page search sofa at the bar")
    public void the_user_is_on_the_main_page_search_sofa_at_the_bar() throws AWTException {
        //Navigate to: https://www.ikea.com/us/en
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        //Using search bar at the top of the page - search for "sofa"
        if(invisible){
            searchBar.sendKeys(addProduct1()+Keys.ENTER);
        }
    }

    @Then("the user picks 1rd item to the Shopping Cart")
    public void the_user_picks_1rd_item_to_the_shopping_cart() throws InterruptedException {
        //On the first page of search results, pick the 1st item in the list and add it to the cart
        if(invisible){
            executor.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//div[@data-ref-id][1]//section[@class='gpr__variant-links']")));
            action.moveToElement(driver.findElement(By.xpath("//div[@data-ref-id][1]//section[@class='gpr__variant-links']")),20,20).perform();
            Thread.sleep(2000);
            toShoppingCartBtn1.click();
            //wait.until(ExpectedConditions.visibilityOfElementLocated((By) toShoppingCartBtn1)).click();

            //productNumberOneInList.click();
            searchBar.clear();
        }
    }

    @Given("the user on the main page search table at the bar")
    public void the_user_on_the_main_page_search_table_at_the_bar() {
        //Using search bar at the top of the page - search for "table"
        if(invisible){
            searchBar.clear();
            searchBar.sendKeys(addProduct2()+Keys.ENTER);
        }

    }

    @Then("the user picks 3rd item to the Shopping Cart")
    public void the_user_picks_3rd_item_to_the_shopping_cart() {
        BrowserUtils.sleep(3);
        if(invisible){
            executor.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//div[@data-ref-id][3]//section[@class='gpr__variant-links']")));
            BrowserUtils.sleep(1);
            action.moveToElement(driver.findElement(By.xpath("//div[@data-ref-id][3]//section[@class='gpr__variant-links']")),20,20).perform();
            //wait.until(ExpectedConditions.visibilityOfElementLocated((By) toShoppingCartBtn2)).click();
            toShoppingCartBtn2.click();
            searchBar.clear();
        }
    }

}
