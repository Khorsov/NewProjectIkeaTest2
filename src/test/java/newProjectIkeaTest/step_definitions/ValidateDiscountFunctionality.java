package newProjectIkeaTest.step_definitions;

import io.cucumber.java.en.*;
import newProjectIkeaTest.pages.ShoppingCartPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidateDiscountFunctionality extends ShoppingCartPage {
    WebDriverWait wait = new WebDriverWait(driver,5);
    Actions action = new Actions(driver);
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    @Given("User on the Shipping Cart page")
    public void user_on_the_shipping_cart_page() {
        System.out.println(shoppingCartBtn.isDisplayed());
        boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='hnf-overlay']")));
        if(invisible){
            shoppingCartBtn.click();
        }
    }

    @Then("User can see correct amount of products that added")
    public void user_can_see_correct_amount_of_products_that_added() {
        //Validate that 2 items are added to the cart
        Assert.assertEquals(actualProductList.size(),expectedListOfProducts().size());
    }

    @When("User clicks on Use a discount code")
    public void userClicksOnUseADiscountCode() {
        //Click on "Use a discount code" link
        useDiscountCodeBtn.click();
    }

    @When("User add discount code")
    public void user_add_discount_code() {
        //enter random string of 15 characters as discount code
        inputDiscountCode.sendKeys(fakerData());
    }
    @And("User Click Apply discount")
    public void userClickApplyDiscount() {
        //click "Apply discount" button
        applyDiscountBtn.click();
    }

    @Then("Invalid coupon code error message is displayed")
    public void invalidCouponCodeErrorMessageIsDisplayed() {
        //Validate that "invalid coupon code" error message is displayed
        invalidCouponMsg.isDisplayed();
    }



}
