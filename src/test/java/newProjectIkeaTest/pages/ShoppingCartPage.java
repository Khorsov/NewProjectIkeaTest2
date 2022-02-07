package newProjectIkeaTest.pages;

import com.github.javafaker.Faker;
import newProjectIkeaTest.base.BasePage;
import newProjectIkeaTest.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = " //div[@data-testid='product_contents_19389835']")
    public WebElement Product1;
    @FindBy(xpath = "//div[@data-testid='product_contents_70294339']")
    public WebElement Product2;
    @FindBy(xpath = "//div[starts-with(@itemtype,'http://schema.org/Product')]")
    public List<WebElement> actualProductList;
    @FindBy(xpath = "//span[@class='cart-ingka-accordion-item-header__title']")
    public WebElement useDiscountCodeBtn;
    @FindBy(xpath = "//span[@class='cart-ingka-btn__inner']")
    public WebElement applyDiscountBtn;
    @FindBy(xpath = "//span[@class='cart-ingka-btn__inner']")
    public WebElement inputDiscountCode;
    @FindBy(linkText = "You've added an invalid coupon code. Please try again. ")
    public WebElement invalidCouponMsg;

    public String fakerData(){
    Faker fakerData = new Faker();
    // How to set up specific amount of char (15)
    String discountCode = String.valueOf(fakerData.code());
    return discountCode;
    }
    public List<WebElement> expectedListOfProducts(){
        List<WebElement> listOfProductsExpected= new ArrayList<>() ;
        listOfProductsExpected.add(Product1);
        listOfProductsExpected.add(Product2);
        return listOfProductsExpected;
    }
    public String getActualTitleName() {
        String str = Driver.getDriver().getTitle();
        return str;
    }
}
