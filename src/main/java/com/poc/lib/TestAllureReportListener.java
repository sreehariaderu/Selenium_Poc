package com.poc.lib;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.qameta.allure.Attachment;

public class TestAllureReportListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestAllureReportListener.class);
    private WebDriver driver;
    
    public TestAllureReportListener(WebDriver driver) {
		this.driver = driver;
    }
    
    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        if (driver != null && driver instanceof TakesScreenshot) {
            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        }
        logger.warn("WebDriver is null or does not support screenshots.");
        return new byte[0];
    }

    @Attachment(value = "Saved Screenshot", type = "image/png")
    public byte[] saveScreenshotFromFile(String path) {
        try {
            java.nio.file.Path p = java.nio.file.Paths.get(path);
            if (java.nio.file.Files.exists(p)) {
                long size = java.nio.file.Files.size(p);
                logger.info("Attaching screenshot file to Allure: " + path + " (" + size + " bytes)");
                return java.nio.file.Files.readAllBytes(p);
            } else {
                logger.warn("Screenshot file does not exist: " + path);
            }
        } catch (Exception e) {
            logger.warn("Unable to read screenshot file: " + e.getMessage());
        }
        return new byte[0];
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    public void screenshotapture(ITestResult iTestResult) {
        logger.info("Screenshot captured for test: " + iTestResult.getName());
    }

    private WebDriver getDriverFromTestResult(ITestResult iTestResult) {
        try {
            Object testClass = iTestResult.getInstance();
            if (testClass != null) {
                // avoid importing AbstractBaseTest here by using reflection to get 'driver' field if available
                try {
                    java.lang.reflect.Field driverField = testClass.getClass().getField("driver");
                    Object drv = driverField.get(testClass);
                    if (drv instanceof WebDriver) {
                        return (WebDriver) drv;
                    }
                } catch (NoSuchFieldException nsfe) {
                    // field not found, try declared field
                    try {
                        java.lang.reflect.Field driverField = testClass.getClass().getDeclaredField("driver");
                        driverField.setAccessible(true);
                        Object drv = driverField.get(testClass);
                        if (drv instanceof WebDriver) {
                            return (WebDriver) drv;
                        }
                    } catch (Exception e) {
                        // ignore
                    }
                } catch (Exception e) {
                    // ignore
                }
            }
        } catch (Exception e) {
            logger.warn("Unable to obtain WebDriver from test instance: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        WebDriver drv = getDriverFromTestResult(iTestResult);
        saveScreenshotPNG(drv);
        screenshotapture(iTestResult);
        saveTextLog(iTestResult.getMethod().getConstructorOrMethod().getName() + " failed and screenshot taken");
        logger.info("-------------------------------------------------------");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info("-------------------------------------------------------");
        logger.info("Test started: " + iTestResult.getName());
        logger.info("-------------------------------------------------------");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("Test passed: " + iTestResult.getName());
        logger.info("-------------------------------------------------------");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("Test skipped: " + iTestResult.getName());
        logger.info("-------------------------------------------------------");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logger.info("Test failed but within success percentage: " + iTestResult.getName());
        logger.info("-------------------------------------------------------");
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test context started: " + context.getName());
        logger.info("-------------------------------------------------------");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Closed the driver instance");
        logger.info("-------------------------------------------------------");
        logger.info("Test context finished: " + context.getName());
        logger.info("-------------------------------------------------------");
    }
}