package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


public class BasketPage extends BasePage{
    public BasketPage(WebDriver driver, WebDriverWait wait, SoftAssert sa) {
        super(driver, wait, sa);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='btn btnBlack']")
    public WebElement handlePopupBtn;
    @FindBy(xpath = "//input[@type='text'and @name='quantity']")
    public WebElement basketCount;


    public void handlePopUpKVKK(){
        try {
            Thread.sleep(3000);
            handlePopupBtn.click();
        } catch (Exception e) {
            System.out.println("Aydınlatma Metni Çıkmadı");
        }
    }

    public void assertCount(String str) throws InterruptedException {
        assertText(basketCount.getAttribute("value"),str);
    }
}
