package Setup;
import Setup.DriverSetup;
import io.appium.java_client.android.AndroidDriver;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

public class trial {
     static WebDriver driver;
    static AndroidDriver androidDriver;
    @Test
    public static void mainTest()throws MalformedURLException, InterruptedException
    {
        //passing on webdriver to get method
//        start(androidDriver);
        start(driver);
        start(driver,"https://www.amazon.in");
        start(driver,"firefox","https://flipkart.com");
    }

    public static void start(WebDriver driver)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Muzammil\\OneDrive\\Desktop\\WebDrivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.google.co.in");

    }

    public static void start(WebDriver driver, String url)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Muzammil\\OneDrive\\Desktop\\WebDrivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(url);
    }

    public static void start(WebDriver driver,String browser,String url)
    {
        if(browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Muzammil\\OneDrive\\Desktop\\WebDrivers\\chromedriver.exe");
            driver=new ChromeDriver();
            driver.get(url);
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Muzammil\\OneDrive\\Desktop\\WebDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(url);
        }
        else if(browser.equalsIgnoreCase("edge"))
        {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\Muzammil\\OneDrive\\Desktop\\WebDrivers\\msedgedriver.exe");
            driver = new EdgeDriver();
            driver.get(url);
        }
        else
        {
            System.out.println("please choose from chrome,firefox or edge");
        }
    }

    public static void start(AndroidDriver driver)throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities ds=new DesiredCapabilities();
        ds.setCapability("platformName","Android");
        ds.setCapability("platformVersion","13.0");
        ds.setCapability("deviceName","QA_ASSINGMENT_MUZAMMIL");
        ds.setCapability("automationName","UiAutomator2");
        ds.setCapability("app","C:\\Users\\Muzammil\\OneDrive\\Desktop\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        ds.setCapability("appPackage","com.swaglabsmobileapp");
        ds.setCapability("appActivity","com.swaglabsmobileapp.MainActivity");
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/"),ds);
    }
    @AfterTest
    public void teardown()
    {
        driver.quit();
    }

}
