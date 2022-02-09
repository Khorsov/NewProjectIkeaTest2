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

    @FindBy(xpath = "//*[@id="search-results"]/div[3]/a/div")
    public WebElement productNumberThreeInList;

    @FindBy(xpath = "//*[@id="search-results"]/div[1]/a/div")
    public WebElement productNumberOneInList;

    @FindBy(xpath = "//*[@id="search-results"]/div[1]/section/div/button")
    public WebElement toShoppingCartBtn1;

    @FindBy(xpath = "//*[@id="search-results"]/div[3]/section/div/button")
    public WebElement toShoppingCartBtn2;

}

