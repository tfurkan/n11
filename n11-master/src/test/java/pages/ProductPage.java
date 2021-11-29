package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utilities.Log4jManager;

import java.util.List;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver, WebDriverWait wait, SoftAssert sa) {
        super(driver, wait, sa);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='spinnerFieldContainer']//*[@class='spinnerUp spinnerArrow']\n")
    List<WebElement> btnUp;
    @FindBy(xpath = "//*[@class='product-add-cart']")
    public WebElement btnAddToCart;
    @FindBy(xpath = "//i[@class='icon iconBasket']")
    public WebElement btnBasket;

    public ProductPage addToCart(){
        try {
            click(btnUp.get(0));
            click(btnAddToCart);
            Log4jManager.info("Ürün Sepete Eklendi");
        } catch (Exception e) {
            Log4jManager.error("Ürün Sepete Eklenemedi",e);
            throw(e);
        }
        return this;
    }
    public ProductPage goToBasket(){
        try {
            click(btnBasket);
            Log4jManager.info("Sepete Gidildi");
        } catch (Exception e) {
            Log4jManager.error("Sepet Gidilemedi",e);
            throw(e);
        }
        return this;
    }

}
