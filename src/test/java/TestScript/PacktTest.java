package TestScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import Reports.ExtentReportsPage;
import library.Browser;
import library.ReusableMethods;
import library.UseProperties;
import Pages.HomePage;

public class PacktTest extends ExtentReportsPage {
    static WebDriver driver;
    ReusableMethods objRMethod;
    ExtentReportsPage ep=new ExtentReportsPage();

    
//    @BeforeSuite(groups= {"smoke","Regression"})
    @Test(priority = 1,groups= {"smoke","Regression"})
    public void BrowserCall() throws InterruptedException
    {   
        driver=Browser.getWebDriver(UseProperties.getBrowser());

    }
    @Test(priority = 2,groups= {"smoke","Regression"})
    public void extentReportFile()
    {
        ep.extentReport();
    }
    
    @Test(priority = 3,groups = {"smoke","Regression"})
    public void LaunchApp() throws InterruptedException
    {
    
        ReusableMethods objRMethod=new ReusableMethods(driver);
        objRMethod.launchApplication();
    }
    
    @Test(priority = 4,groups = {"smoke","Regression"})
    public void AcceptAlert() throws InterruptedException
    {
    
    	HomePage alert =new HomePage(driver);
        alert.Alert();
    }

    @Test(priority = 5,groups = {"smoke","Regression"})
    public void VerifyPositioinColorAndText() throws InterruptedException
    {   
        HomePage verify =new HomePage(driver);
        verify.VerifyColor(); // Assertion on advanceKnowledge
        verify.VerifyPosition(); // Assertion on start free trial
        verify.VerifyText();  // Assertion on start free trial
        test5.log(Status.PASS,"Position , Color and Text Verified");
        rep.flush();
        
    }
    
    @Test(priority = 6,groups = {"Regression"})
    public void VerifyBrowse() throws Exception
    {
        HomePage browse=new HomePage(driver);
        browse.VerifyBrowseLibrary();
        test5.log(Status.PASS,"Verified Browse Library for Year 2021");
        rep.flush();
        
    }
    
    @Test(priority = 7,groups = {"Regression"})
    public void VerifySuggestedTitles() throws Exception
    {
        HomePage titles=new HomePage(driver);
        titles.VerifySuggestedTitles();
        test5.log(Status.PASS,"Verified carousel title with main title");
        rep.flush();
    }
    
    
    
    @Test(priority = 8,groups = {"smoke","Regression"})
    public void search() throws InterruptedException
    {
    	 HomePage navBar=new HomePage(driver); 
    	 navBar.VerifyNavBar();
    	 test5.log(Status.PASS,"Verified nav bar elements");
    	 rep.flush();
    }

    @AfterSuite(groups= {"smoke","Regression"})
    public void CloseBrowser()
    {
        ReusableMethods objRMethod=new ReusableMethods(driver);
        objRMethod.closeApplication(); 
    }
    
}