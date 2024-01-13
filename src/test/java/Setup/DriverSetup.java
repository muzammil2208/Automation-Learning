package Setup;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {


    public void start(WebDriver driver)
    {
        driver.get("https://www.google.co.in");

    }
    public void start(AndroidDriver driver)throws MalformedURLException, InterruptedException
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
}
