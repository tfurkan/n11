package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utilities.ExcelMaganer;
import utilities.Log4jManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MagazalarPage extends BasePage{
    public MagazalarPage(WebDriver driver, WebDriverWait wait, SoftAssert sa) {
        super(driver, wait, sa);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"cookieUsagePopIn\"]/span")
    public WebElement btnCookiePopup;
    By letters = By.xpath("//*[@class='tabPanel allSellers']//*[contains(@class, 'active')]");
    @FindBy(xpath = "//*[@class='tabPanel allSellers']//*[contains(@class, 'active')]")
    List<WebElement> listLetters;
    @FindBy(xpath = "//*[@class='tabPanel allSellers']//*[@class='sellerListHolder']/ul/li")
    List<WebElement> listMagaza;
    @FindBy(xpath = "//*[@class='tab']//*[contains(text(),'Mağaza Yorumları')]")
    public WebElement btnMagazaYorumlari;
    @FindBy(xpath = "//*[@class='pageCount']")
    public WebElement pageCount;
    @FindBy(xpath = "//*[@class='comment']")
    List<WebElement> listComments;
    @FindBy(xpath = "//*[@class='selectedReview']")
    public WebElement infoMagaza;
    @FindBy(xpath = "//em[contains(text(),'Mağaza ile ilgili değerlendirme yapılmamış')]")
    public WebElement infoNoComment;
    @FindBy(xpath = "//*[@class='pageInfo']//input[@type='text']")
    public WebElement txtPage;


    public void handleCookiePopup(){
        try {
            btnCookiePopup.click();
            Log4jManager.info("Popup Kapatıldı");
        } catch (Exception e) {
            Log4jManager.warn("Popup Açılmadı");
        }
    }
    public void writeMagazalarToExcel() throws InterruptedException { //V2'den hızlı çalışan fonksiyon
        ArrayList<String> magazalar = new ArrayList<String>();
        int sizeLetters = driver.findElements(letters).size();
        String str = "";
        String text ;
        for (int j = 1; j <= sizeLetters; j++){
            int sizeMagaza = driver.findElements(By.xpath("//*[@class='tabPanel allSellers']//*[@class='sellerListHolder']/ul/li")).size();
            str = Integer.toString(j);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='tabPanel allSellers']//*[contains(@class, 'active')]["+str+"]"))));
            driver.findElement(By.xpath("//*[@class='tabPanel allSellers']//*[contains(@class, 'active')]["+str+"]")).click();
          //  Thread.sleep(1000);
            for (int i = 1; i <= sizeMagaza; i++){
                str = Integer.toString(i);
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='tabPanel allSellers']//*[@class='sellerListHolder']/ul/li["+str+"]"))));
                text = driver.findElement(By.xpath("//*[@class='tabPanel allSellers']//*[@class='sellerListHolder']/ul/li["+str+"]")).getText();
                System.out.println(text);
                magazalar.add(text);
            }
            Thread.sleep(1000);
        }
        ExcelMaganer.setCellData(magazalar);
    }
    public void writeMagazalarToExcelV2() throws InterruptedException {
        try {
            ArrayList<String> magazalar = new ArrayList<String>();
            String str = "";
            String text ;
            for (int j = 0; j <= listLetters.size(); j++){
                click(listLetters.get(j));
                //  Thread.sleep(1000);
                for (int i = 0; i <= listMagaza.size(); i++){
                    magazalar.add(listMagaza.get(i).getText());
                }
            //    Thread.sleep(1000);
            }
            ExcelMaganer.setCellData(magazalar);
            Log4jManager.info("Excel'e yazıldı");
        } catch (Exception e) {
            Log4jManager.error("Excel'e Yazılamadı",e);
            throw(e);
        }
    }

    public void goToMagaza() throws InterruptedException {
        try {
            Thread.sleep(2000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1250)","");
            Random r = new Random();
            int randomValue = r.nextInt(listLetters.size());
            click(listLetters.get(randomValue));
            randomValue = r.nextInt(listMagaza.size());
            click(listMagaza.get(randomValue));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkStoreComments(){
        int totalComments;
        try {
            click(btnMagazaYorumlari);
            totalComments = ((Integer.parseInt(pageCount.getText()) - 1) * 10);
            click(txtPage);
            writeTextWithClear(txtPage, pageCount.getText());
            txtPage.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            totalComments +=listComments.size();
            String countComments = Integer.toString(totalComments);
            String[] infoComment = readText(infoMagaza).split(" ");
            assertText(infoComment[2], countComments);
        } catch (Exception e) {
            try{
                totalComments = listComments.size();
                String countComments = Integer.toString(totalComments);
                String[] infoComment = readText(infoMagaza).split(" ");
                assertText(infoComment[2], countComments);

            }catch (Exception a){
                assertText(infoNoComment.getText(), "Mağaza ile ilgili değerlendirme yapılmamış");
            }
        }


    }
}
