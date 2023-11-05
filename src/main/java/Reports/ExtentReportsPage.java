package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsPage {
    public static ExtentHtmlReporter reporter;
    public static ExtentReports rep;
    public static ExtentTest test1,test2,test3,test4;

    public void extentReport()                     //To create the Extent Report
     {
        try
        {
          reporter=new ExtentHtmlReporter(System.getProperty("user.dir") + "./Reports/ExtentReport_Packt.html");
          rep=new ExtentReports();
          rep.attachReporter(reporter);
          
          reporter.config().setDocumentTitle("Packt");
          reporter.config().setReportName("Packt_Module");
          
          rep.setSystemInfo("OS", "Windows 11 Enterprise");
          rep.setSystemInfo("Environment", "Packt");
          rep.setSystemInfo("Version", "95");
          rep.setSystemInfo("Browser","Chrome");
         
          test1=rep.createTest("Browser");
          test2=rep.createTest("ReusableMethods");
          test3=rep.createTest("HomePage");
          test4=rep.createTest("ScreenShot");

        }
        catch(Exception e)
        {
            System.out.println("Error occured while printing the Extent Report");
        }
          
     }
}
