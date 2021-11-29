package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
public class Browser {
    public static RemoteWebDriver getDriver(String browser) throws MalformedURLException {
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getBrowserCapabilities(browser));
    }

    private static DesiredCapabilities getBrowserCapabilities(String browserType) {

        if(browserType.equalsIgnoreCase("firefox"))
        {
            System.out.println("Opening firefox driver");
            return DesiredCapabilities.firefox();
        }
       else if(browserType.equalsIgnoreCase("chrome"))
        {
            System.out.println("Opening chrome driver");
            return DesiredCapabilities.chrome();
        }
       else{
            return DesiredCapabilities.chrome();
        }
    }
}
