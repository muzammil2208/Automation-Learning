package Setup;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.FindBy;
import io.restassured.response.*;
import io.restassured.RestAssured;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AmazonTrial {
    private static WebDriver driver;

    @Test
    public static void LearningTest()
    {
        WebElement search=driver.findElement(By.xpath("//input[@class=\"Pke_EE\"]"));
        WebElement searchBtn=driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        search.sendKeys("cricket bat");
        searchBtn.click();
        List<WebElement> products=new ArrayList<WebElement>();
        products=driver.findElements(By.xpath("//a[@class=\"s1Q9rs\"]"));
        printProducts(products);
        List<WebElement> allLinks=new ArrayList<>();
        allLinks=driver.findElements(By.tagName("a"));
        checkAllLinksWorking(allLinks);
        driver.quit();


    }
    public static void checkAllLinksWorking(List<WebElement> links)
    {
        List<String> urls=new ArrayList<>();
        for(WebElement link:links)
        {
            String url=link.getAttribute("href");
            urls.add(url);

        }
        for(String url:urls)
        {
            Response response=RestAssured.get(url);
            int status= response.statusCode();
            if(status==200)
                System.out.println(url+ "is working");
            else
                System.out.println(url+ " is not working and failing with status code"+status);
        }
    }

    public static void printProducts(List<WebElement> products)
    {
        List<String> productNames=new ArrayList<>();
        for(WebElement product:products)
        {
            String names=product.getText();
            productNames.add(names);
        }
        System.out.println(productNames);
    }
    @BeforeTest
    public static void setup()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Muzammil\\OneDrive\\Desktop\\WebDrivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.flipkart.com");
    }

    @AfterTest
    public void tearDown()
    {
        driver.close();
    }

}
