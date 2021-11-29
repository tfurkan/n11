package tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class TC02_Products {
    public WebDriverWait wait;
    public SoftAssert sa;

    private static RemoteWebDriver driver;

    @BeforeClass
    @Parameters(value = {"browser"})
    public void setup(String browser) throws MalformedURLException {
        //Set Browser to ThreadLocalMap
        driver = Browser.getDriver(browser);
        driver.manage().window().maximize();
        sa = new SoftAssert();
        wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    HomePage homePage;
    MagazalarPage magazalarPage;
    SearchPage searchPage;
    ProductPage productPage;
    BasketPage basketPage;

    @Test(priority = 0)
    public void basketDiscount() throws InterruptedException {
        homePage = new HomePage(driver, wait, sa);
        magazalarPage = new MagazalarPage(driver, wait, sa);
        searchPage = new SearchPage(driver, wait, sa);
        productPage = new ProductPage(driver, wait, sa);
        basketPage = new BasketPage(driver, wait, sa);

        homePage.goToN11()
                .clickLocationBtn();
        homePage.handleNotPopup();
        homePage.searchProduct("tablet");
        searchPage.clickMarka();
        searchPage.selectThirdProduct();
        productPage.addToCart().goToBasket();
        basketPage.handlePopUpKVKK();
        basketPage.assertCount("2");

    }

    /*  @Test(priority = 0)
      public void basketDiscountSecond() throws InterruptedException {
          homePage = new HomePage(driver, wait, sa);
          magazalarPage = new MagazalarPage(driver, wait, sa);
          searchPage = new SearchPage(driver, wait, sa);
          productPage = new ProductPage(driver, wait, sa);
          basketPage = new BasketPage(driver, wait, sa);

          homePage.goToN11()
                  .clickLocationBtn();
          homePage.searchProduct("samsung");
          searchPage.clickMarka();
          searchPage.selectThirdProduct();
          productPage.addToCart().goToBasket();
          basketPage.handlePopUpKVKK();
          basketPage.assertCount("2");

      }*/
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
