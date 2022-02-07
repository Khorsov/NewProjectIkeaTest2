package newProjectIkeaTest.step_definitions;

import io.cucumber.java.en.*;
import newProjectIkeaTest.pages.ShoppingCartPage;
import org.junit.Assert;

public class ValidateDiscountFunctionality extends ShoppingCartPage {

    @Given("User on the Shipping Cart page")
    public void user_on_the_shipping_cart_page() {
        //Navigate to shopping cart page
        String expectedTitleName = "Shopping bag - IKEA";
        Assert.assertEquals(expectedTitleName,getActualTitleName());
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
