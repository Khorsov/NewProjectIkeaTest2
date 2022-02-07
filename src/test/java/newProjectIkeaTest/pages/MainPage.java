package newProjectIkeaTest.pages;


import newProjectIkeaTest.base.BasePage;
import newProjectIkeaTest.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage {


    static String product1 = "sofa";
    static String product2 = "table";

    public static String addProduct1() {
        String result = product1;
        return result;
    }

    public static String addProduct2() {
        String rst = product2;
        return rst;
    }

    public String getActualTitleName() {
        String str = Driver.getDriver().getTitle();
        return str;
    }

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBar;

    @FindBy(xpath = "//div[@data-ref-id='50211104']")
    public WebElement productNumberThreeInList;

    @FindBy(xpath = "//div[@data-ref-id='19389835']")
    public WebElement productNumberOneInList;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement toShoppingCartBtn;

    @FindBy(xpath = "//span[@class='hnf-btn__label']")
    public WebElement shoppingCartBtn;

    @FindBy(xpath = "//button[@id='search-box__searchbutton']")
    public WebElement searchBtn;

    @FindBy(xpath = "//button[@id='hnf-menu-close-btn']")
    public WebElement closeBtn;

}

