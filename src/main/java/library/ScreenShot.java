package library;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.google.common.io.Files;
import Reports.ExtentReportsPage;

public class ScreenShot  {
    public static void TakeScreenShot( WebDriver driver) {

          // TODO Auto-generated method stub
            File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

         //save the screenshot to the "screenshot" folder
            try {
                FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshot\\"+System.currentTimeMillis()+".jpg"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
}