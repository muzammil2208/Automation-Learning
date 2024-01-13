package ActionsClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class setup {
    static WebDriver driver;
    public static WebDriver driversetup(String browserName) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Muzammil\\OneDrive\\Desktop\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
}
