package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utilities.Log4jManager;

import java.util.List;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver, WebDriverWait wait, SoftAssert sa) {
        super(driver, wait, sa);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='filterList']//input[@data-is='m']")
    List<WebElement> checkBoxMarka;
    @FindBy(xpath = "//*[contains(@class,'productName ')]")
    List<WebElement> products;


    public void clickMarka(){
        try {
            click(checkBoxMarka.get(0));
            Log4jManager.info("Marka Seçildi");
        } catch (Exception e) {
            Log4jManager.error("Marka Seçilemedi",e);
        }
    }

    public void selectThirdProduct() throws InterruptedException {
        try {
            click(products.get(2));
            Log4jManager.info("Üçüncü Ürün Seçildi");
        } catch (Exception e) {
            Log4jManager.error("Ürün Seçilemedi",e);
            throw(e);
        }
    }
}
