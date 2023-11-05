package library;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import Reports.ExtentReportsPage;

public class ReusableMethods extends ExtentReportsPage
{

    WebDriver driver;
    ExtentReportsPage ep=new ExtentReportsPage();
    public ReusableMethods(WebDriver driver)
    {
        this.driver=driver;
    }

    public void launchApplication() throws InterruptedException              //To Launch the Application
    {
        driver.get(UseProperties.getUrl());
        Thread.sleep(1000);

        String PageTitle=driver.getTitle();

        if(PageTitle.contains("Packt Subscription | Advance your knowledge in tech"))
        {
            System.out.println("Entered Application is Packt");            
        }
        else
        {
            System.out.println("Error occured while opening application");
        }
        test2.log(Status.PASS,"Entered the Packt Application");
        rep.flush();
        
    }
    

    public void closeApplication()                              //To close the Application
    {
        driver.quit();              
    }
}
