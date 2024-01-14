package ActionsClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Reports.Reports;
public class trialactions extends setup{
    static WebDriver driver;

    @Test
    public void test1()
    {

        googlepage pg=new googlepage(driver);
        System.out.println("implemented abstract class");
        pg.search();
        pg.dragFirstSearch();
        Reports.logpass("successfully implemented actions class");

    }
    @BeforeTest
    public void setup()
    {
        driver=driversetup("chrome");
        driver.get("https://www.google.co.in");
        Reports.setup("Google Test");

    }
    @AfterTest
    public void tearDown()
    {
        driver.quit();
        Reports.reportsSave();

    }




}

