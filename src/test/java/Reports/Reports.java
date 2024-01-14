package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
    static ExtentReports reports;
    static ExtentSparkReporter spark;
    static ExtentTest test;

    public static void setup(String name)
    {
        String path=System.getProperty("user.dir")+"/Results";
        reports=new ExtentReports();
        spark=new ExtentSparkReporter(path+"/"+name+".html");
        reports.attachReporter(spark);
        test=reports.createTest(name);
    }
    public static void logFail(String expected,String actual)
    {
        test.fail("Failed due to expected value is "+expected+" and actual value is "+actual);
    }
    public static void logpass(String message){
        test.pass(message);
    }
    public static void reportsSave()
    {
        reports.flush();
    }

}
