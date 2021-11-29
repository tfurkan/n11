package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utilities.Log4jManager;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver, WebDriverWait wait, SoftAssert sa) {
        super(driver, wait,sa);
        PageFactory.initElements(driver, this);
    }
    String baseURL = "https://www.n11.com/";

    @FindBy(xpath = "//span[contains(text(),'Mağazalar')]")
    public WebElement btnMagazalar;
    @FindBy(xpath = "//a[contains(text(),'Mağazaları Gör')]")
    public WebElement btnMagazalariGor;
    @FindBy(xpath = "//*[@id=\"myLocation-close-info\"]")
    public WebElement btnLocationInfo;
    @FindBy(id = "searchData")
    public WebElement lblSearch;
    @FindBy(xpath = "//*[@class='searchBtn']")
    public WebElement btnSearch;
    @FindBy(xpath = "//button[@class='dn-slide-deny-btn']")
    public WebElement btnDnyPopup;

    public HomePage goToN11(){
        try {
            driver.get(baseURL);
            softAssertText(driver.getCurrentUrl(), baseURL);
            Log4jManager.info("Websitesi Açıldı");
        } catch (Exception e) {
            Log4jManager.error("Websitesi açılmadı",null);
            throw(e);
        }
        return this;
    }
    public HomePage clickMagazalariGor() {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(btnMagazalar);
            actions.perform();
            click(btnMagazalariGor);
            Log4jManager.info("Mağazaları Gör Butonuna Tıklandı");
        } catch (Exception e) {
            Log4jManager.error("Mağazaları Gör Butonuna tıklanamadı",e);
            throw(e);
        }
        return this;
    }

    public HomePage clickLocationBtn(){
        try {
            btnLocationInfo.click();
            Log4jManager.info("Konum Popupı Kapatıldı");
        } catch (Exception e) {
            Log4jManager.warn("Konum Popupı Kapatılamadı");
        }
        return this;
    }
    public void handleNotPopup(){
        try {
            click(btnDnyPopup);
            Log4jManager.info("Bildirim Popupı Kapatıldı");
        } catch (Exception e) {
            Log4jManager.warn("Bildirim Popupı Kapatılamadı");
        }
    }
    public void searchProduct(String str){

        click(lblSearch);
        writeTextWithClear(lblSearch, str);
        click(btnSearch);
    }



}
