/*package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utilities.ExcelMaganer;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



public class BaseTest {
   // public static WebDriver driver;
    public WebDriverWait wait;
    public SoftAssert sa;


  //  String browser = "remote";

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
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 15);
            sa = new SoftAssert();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else if (browser.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            FirefoxProfile profile = new FirefoxProfile();
            //Accept Untrusted Certificates
            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(false);
            //Use No Proxy Settings
            profile.setPreference("network.proxy.type", 0);
            //Set Firefox profile to capabilities
            options.setCapability(FirefoxDriver.PROFILE, profile);
            driver = new FirefoxDriver();
            wait = new WebDriverWait(driver, 15);
            sa = new SoftAssert();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } else if(browser.equals("remote")){
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("version","");
            capabilities.setPlatform(Platform.LINUX);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
            wait = new WebDriverWait(driver, 15);
            sa = new SoftAssert();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println(driver.getTitle());

        }else {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 15);
            sa = new SoftAssert();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    @AfterClass
    public void tearDown() {
        if(driver!=null){
            driver.quit();
        }
    }

}*/



