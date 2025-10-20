package com.poc.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.poc.lib.AppLib;
import com.poc.lib.TestAllureReportListener;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;

public class AbstractBaseTest {
	public WebDriver driver;
	private AppLib applib;
	public static Logger logger = LogManager.getLogger(AbstractBaseTest.class);
	public TestAllureReportListener listener;
	@BeforeTest
	public void beforeTest() {
        // instantiate listener without passing driver (listener will obtain driver per-test when needed)
        listener = new TestAllureReportListener(driver);    
    }
	
	@Parameters({"browser","url"})
	@BeforeMethod(alwaysRun=true)
	public void setUp(@Optional("chrome") String browser,@Optional("http://automationexercise.com") String url,ITestResult result) {
		//listener.onStart(result.getMethod().getMethodName());
		if(browser.equalsIgnoreCase("chrome")) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
	    //WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sreehari\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver(options);
		logger.info("Chrome browser is launched");
		}else if(browser.equalsIgnoreCase("edge")) {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\sreehari\\edgedriver_win64\\msedgedriver.exe");
		//WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();	
		logger.info("Edge browser is launched");
		}
		else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
		//elementsHomepage = new Ebay_Homepage_elements(driver);
		applib = new AppLib(driver);
		App().Flow().getUrl(url);
		
	}
	
	public void screenshotapture(ITestResult result)
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            try
            {
                captureScreenshot(result.getMethod().getMethodName());
                logger.info("Screenshot captured for failed method "+result.getMethod().getMethodName());
            }
            catch (Exception e)
            {
                logger.info("Exception for the method "+result.getMethod().getMethodName()+":"+e.getMessage());
            }
        }
    }
	
	public void captureScreenshot(String filename) throws IOException
    {
        try
        {
            Date currentdate = new Date();
            String screenshotfilename=currentdate.toString().replace(" ", "-").replace(":", "-");
            File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("./screenshots/"+filename+screenshotfilename+".png"));
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
        }
    }
	
	@AfterMethod(alwaysRun=true)
	  protected void screenShotIfFail(ITestResult result) throws IOException {
        if (!result.isSuccess())
        {
            // first write screenshot file to ./screenshots
            try {
                captureScreenshot(result.getMethod().getMethodName());
            } catch (Exception e) {
                logger.warn("captureScreenshot failed: " + e.getMessage());
            }

            // try to find the most recent screenshot file for this test method
            try {
                java.io.File screenshotsDir = new java.io.File("./screenshots");
                java.io.File[] matches = screenshotsDir.listFiles(new java.io.FilenameFilter() {
                    @Override
                    public boolean accept(java.io.File dir, String name) {
                        return name.startsWith(result.getMethod().getMethodName()) && name.toLowerCase().endsWith(".png");
                    }
                });

                if (matches != null && matches.length > 0) {
                    java.util.Arrays.sort(matches, new java.util.Comparator<java.io.File>() {
                        @Override
                        public int compare(java.io.File f1, java.io.File f2) {
                            return Long.compare(f2.lastModified(), f1.lastModified()); // newest first
                        }
                    });
                    java.io.File latest = matches[0];
                    String path = latest.getAbsolutePath();

                    // attach the file bytes to Allure using java.nio.file.Files
                    try (java.io.InputStream is = new ByteArrayInputStream(Files.readAllBytes(latest.toPath()))) {
                        Allure.addAttachment("Failure Screenshot", is);
                    }

                    // let the listener also save/attach as needed
                    try {
                        listener.saveScreenshotFromFile(path);
                    } catch (Exception e) {
                        logger.warn("listener.saveScreenshotFromFile failed: " + e.getMessage());
                    }
                } else {
                    // fallback to direct driver screenshot (listener handles driver->bytes)
                    try {
                        listener.saveScreenshotPNG(driver);
                    } catch (Exception e) {
                        logger.warn("listener.saveScreenshotPNG failed: " + e.getMessage());
                    }
                }
            } catch (Exception e) {
                logger.warn("Unable to attach saved screenshot: " + e.getMessage());
                // final fallback
                try { listener.saveScreenshotPNG(driver); } catch (Exception ex) { /*ignore*/ }
            }

            screenshotapture(result);
            logger.info(result.getMethod().getMethodName()+" failed and captured the screenshot.");
        }
        else
        {
            logger.info(result.getMethod().getMethodName()+" executed successfully.");
        }
        logger.info("-------------------------------------------------------");
        driver.quit();
    }
	
	public AppLib App() {
		return applib;
		
	}

}