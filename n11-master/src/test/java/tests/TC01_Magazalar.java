package tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.MagazalarPage;
import utilities.ExcelMaganer;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class TC01_Magazalar {
    public WebDriverWait wait;
    public SoftAssert sa;
    private static RemoteWebDriver driver;
    @BeforeTest
    public void setupTestData(){
        ExcelMaganer.setExcelFileSheet("magazalar");
    }

    @BeforeClass
    @Parameters(value={"browser"})
    public void setup (String browser) throws MalformedURLException {
        //Set Browser to ThreadLocalMap
        driver = Browser.getDriver(browser);
        driver.manage().window().maximize();
        sa = new SoftAssert();
        wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    HomePage homePage;
    MagazalarPage magazalarPage;

    @Test(priority = 0)
    public void magazalar() throws InterruptedException {
        homePage = new HomePage(driver, wait, sa);
        magazalarPage = new MagazalarPage(driver, wait, sa);

        homePage.goToN11()
                .clickLocationBtn();
           homePage.handleNotPopup();
           homePage.clickMagazalariGor();
        magazalarPage.handleCookiePopup();
        magazalarPage.writeMagazalarToExcelV2();
        magazalarPage.goToMagaza();
        magazalarPage.checkStoreComments();

    }
    @AfterClass
    public void tearDown() {
        if(driver!=null){
            driver.quit();
        }
    }
}
