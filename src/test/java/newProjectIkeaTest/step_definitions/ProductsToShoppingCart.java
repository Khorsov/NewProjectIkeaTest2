package newProjectIkeaTest.step_definitions;
import java.awt.Robot;
import io.cucumber.java.en.*;
import newProjectIkeaTest.pages.MainPage;
import newProjectIkeaTest.utilities.BrowserUtils;
import newProjectIkeaTest.utilities.ConfigurationReader;
import newProjectIkeaTest.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsToShoppingCart extends MainPage {

    WebDriverWait wait = new WebDriverWait(driver,5);
    Actions action = new Actions(driver);

    @Given("the user is on the main page search sofa at the bar")
    public void the_user_is_on_the_main_page_search_sofa_at_the_bar() {

        //Navigate to: https://www.ikea.com/us/en
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        //Using search bar at the top of the page - search for "sofa"
        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        searchBar.sendKeys(addProduct1()+Keys.ENTER);
        BrowserUtils.sleep(1);
        //action.sendKeys(Keys.ESCAPE).build().perform();
        //JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("arguments[0].click()",closeBtn);
    }

    @When("the user sees list of sofa")
    public void the_user_sees_list_of_sofa() {

       String expectedTitleName = "sofa";
       Assert.assertTrue(expectedTitleName.contains(getActualTitleName()));
    }

    @Then("the user picks 1rd item to the Shopping Cart")
    public void the_user_picks_1rd_item_to_the_shopping_cart() {

        //On the first page of search results, pick the 1st item in the list and add it to the cart
        BrowserUtils.sleep(5);
        BrowserUtils.hover(productNumberOneInList);
        wait.until(ExpectedConditions.elementToBeClickable(productNumberOneInList));
        wait.until(ExpectedConditions.elementToBeClickable(toShoppingCartBtn));
        toShoppingCartBtn.click();
    }

    @Given("the user on the main page search table at the bar")
    public void the_user_on_the_main_page_search_table_at_the_bar() {

        //Using search bar at the top of the page - search for "table"
        BrowserUtils.sleep(3);
        driver.navigate().back();
        driver.navigate().refresh();
        searchBar.sendKeys(addProduct2()+ Keys.ENTER);
        action.sendKeys(Keys.ESCAPE).build().perform();
    }

    @When("the user sees list of table")
    public void the_user_sees_list_of_tables() {
        String expectedTitleName = "table";
        Assert.assertTrue(expectedTitleName.contains(getActualTitleName()));
    }

    @Then("the user picks 3rd item to the Shopping Cart")
    public void the_user_picks_3rd_item_to_the_shopping_cart() {

        //n the first page of search results, pick the 3rd item in the list and add it to the cart
        BrowserUtils.sleep(5);
        BrowserUtils.hover(productNumberThreeInList);
        wait.until(ExpectedConditions.elementToBeClickable(productNumberThreeInList));
        wait.until(ExpectedConditions.elementToBeClickable(toShoppingCartBtn));
        toShoppingCartBtn.click();
    }

}
