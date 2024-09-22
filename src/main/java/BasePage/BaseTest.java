package BasePage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected WebDriver driver;
    public static Logger logger;
    protected SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        System.setProperty("Webdriver.chrome.driver", "C:\\Users\\SushilRathour\\Documents\\chromedriver-win32\\chromedriver.exe");
        
        driver = new ChromeDriver();
        
        logger=Logger.getLogger("Blazedemo");
        PropertyConfigurator.configure("log4j.properties");
        
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  //      WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://blazedemo.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)) ;
		softAssert = new SoftAssert();

    }

    @AfterMethod
    public void tearDown() {
        // Close the WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }
    
//    public void captureScreen(WebDriver driver, String tname) throws IOException
//	{
//		TakesScreenshot ts=(TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
//		FileUtils.copyFile(source, target);
//		System.out.println("Screenshot taken");
//		
//	}
    
    public void captureScreen(String testName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
        String fileName = testName + "_" + timeStamp + ".png";

        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + fileName);
        FileUtils.copyFile(source, target);

        System.out.println("Screenshot taken: " + fileName);
    }
}
