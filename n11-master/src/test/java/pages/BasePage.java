package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BasePage {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static SoftAssert sa;
    public BasePage (WebDriver driver, WebDriverWait wait, SoftAssert sa){
        this.driver = driver;
        this.wait = wait;
        this.sa = sa;

    }
    public void click(WebElement clickElement) {
        wait.until(ExpectedConditions.elementToBeClickable(clickElement));
        clickElement.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        public void writeText(WebElement sendKeysElement, String text){
            wait.until(ExpectedConditions.elementToBeClickable(sendKeysElement));
            sendKeysElement.sendKeys(text);
        }
    public void writeTextWithClear(WebElement sendKeysElement, String text){
        wait.until(ExpectedConditions.elementToBeClickable(sendKeysElement));
        sendKeysElement.clear();
        sendKeysElement.sendKeys(text);
    }
    public String readText(WebElement getTextElement){
        wait.until(ExpectedConditions.visibilityOf(getTextElement));
        return getTextElement.getText();
    }
    public void softAssertText(String actual, String expectedText){
        sa.assertEquals(actual, expectedText);
    }
    public  void assertText(String actual, String expectedText){
        Assert.assertEquals(actual, expectedText);
    }
}
