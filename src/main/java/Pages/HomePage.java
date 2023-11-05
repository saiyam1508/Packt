package Pages;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import Reports.ExtentReportsPage;
import library.Browser;
import library.ReusableMethods;
import library.ScreenShot;
import library.UseProperties;

public class HomePage extends ExtentReportsPage {
	static WebDriver driver;
	static ReusableMethods rm = new ReusableMethods(driver);
	ExtentReportsPage ep = new ExtentReportsPage();
	static ScreenShot sc = new ScreenShot();

	@FindBy(xpath = "//h2[text()='Advance your knowledge in tech']")
	WebElement advanceKnowledge;

	@FindBy(xpath = "//a[text()='Start FREE trial']")
	WebElement startFreeTrial;

	@FindBy(xpath = "//input[@placeholder='Search titles …']")
	WebElement search;

	@FindBy(xpath = "//nav[@id='packt-navbar']")
	WebElement navBarElements;

	@FindBy(xpath = "//div[@class='d-flex justify-content-between mt-4 pt-4']")
	WebElement carousel;

	@FindBy(xpath = "//h2[@class='text-white']")
	WebElement mainTitle;

	@FindBy(xpath = "//button[@class='slick-arrow slick-next']")
	WebElement clickNext;

	@FindBy(xpath = "(//a[text()='Browse Library'])[1]")
	WebElement Browse;

	@FindBy(xpath = "//button[@class='reset-button']")
	WebElement Reset;

	@FindBy(xpath = "//div[text()='Published Year']")
	WebElement filterYear;

	@FindBy(xpath = "//div[text()='2021']")
	WebElement SelectYear;

//    @FindBy(xpath = "//div[text()='2021']")
//    WebElement searchInput;

//    public void ObjectInitialization() {
//    		driver=Browser.getWebDriver(UseProperties.getBrowser());
//    	 	ReusableMethods reusableMethods = new ReusableMethods(driver);
//	        reusableMethods.launchApplication(UseProperties.getUrl());
////	        HomePage alert =new HomePage(driver);
//	        Alert();   	 
//
//    }
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void VerifyBrowseLibrary() {
		Browse.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Reset.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		filterYear.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		SelectYear.click();
		String[] searchWords = { "Python", "Paint", "Secure", "Tableau" };
		for (String word : searchWords) {
			WebElement searchInput = driver.findElement(By.xpath("(//input[@placeholder='Search titles …'])[2]"));
			searchInput.clear();
			searchInput.sendKeys(word);
			searchInput.sendKeys(Keys.ENTER);
			// Wait for search results to load
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='product-title mb-3']"));
			boolean allTitlesContainWord = searchResults.stream().allMatch(element -> element.getText().contains(word));
			if (allTitlesContainWord) {
				System.out.println("All titles contain the word: " + word);
			} else {
				System.out.println("Not all titles contain the word: " + word);
			}
		}
		
		 driver.navigate().to("https://subscription.packtpub.com/");
		 test3.log(Status.PASS,"VerifyBrowseLibrary Passed");

	}

	public void VerifyColor() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String expectedColorHex = "#ffffff";
		String actualColor = advanceKnowledge.getCssValue("color");
		String actualColorHex = Color.fromString(actualColor).asHex();
		System.out.println("Color is: " + actualColor);
		System.out.println("Hex code for color: " + actualColorHex);
		Assert.assertEquals(expectedColorHex, actualColorHex);
		ScreenShot.TakeScreenShot(driver);
		String logMessage = "Color Verified Successfully";
		System.out.println(logMessage);
		Reporter.log(logMessage);
		test3.log(Status.PASS,logMessage);

	}

	public void VerifyPosition() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String expectedPosition = "inline-block";
		String actualPosition = startFreeTrial.getCssValue("display");
		Point location = startFreeTrial.getLocation();
		System.out.println("X, Y - coordinates: " + location);
		System.out.println("Position: " + actualPosition);
		Assert.assertEquals(actualPosition, expectedPosition);
		ScreenShot.TakeScreenShot(driver);
		String logMessage = "Position Verified Successfully!";
		System.out.println(logMessage);
		test3.log(Status.PASS, logMessage);

	}

	public void VerifyText() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String expectedText = "Start FREE trial";
		String actualText = startFreeTrial.getText();
		System.out.println("TEXT: " + actualText);
		Assert.assertEquals(actualText, expectedText);
		ScreenShot.TakeScreenShot(driver);
		System.out.println("Text Verified Successfully!");
		test3.log(Status.PASS, "Text Verified Successfully!");

	}

	public void VerifyNavBar() throws InterruptedException {
		java.util.List<WebElement> navLinks = navBarElements
				.findElements(By.xpath("// nav[@id='packt-navbar']/div/a"));     ////div[@class='d-none d-lg-inline navbar-nav']/a
		for (WebElement navLink : navLinks) {
			navLink.click();
			Thread.sleep(5000);
			System.out.println("Navigated to Pages Successfully!");
			String pageTitle = driver.getTitle();
			if (isPageValid(pageTitle)) {
				System.out.println("Verification successful for link");
			} else {
				System.out.println("Verification failed for link");
			}
//			driver.navigate().to("https://subscription.packtpub.com/");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		}
		test3.log(Status.PASS,"VerifyNavBar Passed");
	}

	public void VerifySuggestedTitles() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		java.util.List<WebElement> elements = driver
				.findElements(By.xpath("//h5[@class='justify-content-end text-white mt-4 title-name']"));
		int j = 0;
		for (WebElement element : elements) {
			String elementText = element.getText();
			element.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			String mainElementText = mainTitle.getText();
			j++;
			if (elementText.equals(mainElementText)) {
				System.out.println("Verification successful for element: " + mainElementText);
			} else {
				System.out.println("Verification failed for element: " + elementText);
			}
			if (j == 3 || j == 7) {
				clickNext.click();
				Thread.sleep(4000);
			}

		}
		test3.log(Status.PASS,"VerifySuggestedTitles Passed");
	}

	public static boolean isPageValid(String pageTitle) {
		String browseLibraryTitle = "Search | Packt Subscription";
		String advanceSearchTitle = "Advanced Search | Packt Subscription";

		if (browseLibraryTitle.contains(pageTitle)) {
			return true;
		} else if (advanceSearchTitle.contains(pageTitle)) {
			return true;
		} else {
			return false;
		}
	}

	public void Alert() {
		try {
			driver.findElement(By.xpath("//button[text()='Allow all']")).click();
		} catch (Exception e) {
			System.out.println("Alert not present.");
		}
	}

	

}