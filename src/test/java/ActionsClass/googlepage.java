package ActionsClass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class googlepage  {

    static WebDriver driver;
    static WebDriverWait wait;
    static String browser;
    static String url;
    static Properties prop=new Properties();
    static String path=System.getProperty("user.dir");

    static Actions actions;
    @FindBy(xpath="//textarea[@id=\"APjFqb\"]")
    public static WebElement searchArea;

    @FindBy(xpath="//img[@class=\"jfN4p\"]")
    public static WebElement   firstSearch;

    @FindBy(xpath="//textarea[@id=\"APjFqb\"]")
    public static WebElement secondSearchArea;

   public googlepage(WebDriver driver) {
       this.driver=driver;
       actions=new Actions(driver);
       wait= new WebDriverWait(driver, Duration.ofSeconds(10));
       PageFactory.initElements(driver, this);
   }
   public static void setup()
   {

       try{
           InputStream input=new FileInputStream(path+"/configuration.properties");
           prop.load(input);
           url=prop.getProperty("url");

       }
       catch (Exception e)
       {
           System.out.println("error while retriving data from configrations file");
       }
       System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriverPath"));
       driver.get(url);

   }
   public void search()
   {
       searchArea.sendKeys("hello");
       actions.sendKeys(Keys.ENTER).perform();

   }
   public void dragFirstSearch()
   {
       wait.until(ExpectedConditions.visibilityOf(secondSearchArea));
       actions.dragAndDrop(firstSearch,secondSearchArea).build().perform();
   }





}
