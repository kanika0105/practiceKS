package testng;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshot {

    public static WebDriver driver;

    @BeforeSuite
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Reporter.log("browser is opening");
        driver.get("https://www.online-calculator.com/");
    }

    @Test
    public void testPass() {
        Assert.assertEquals(driver.getTitle(), "W3Schools Online Web Tutorials");
        Reporter.log("testPass executed");
    }

    @Test
    public void testFail() {
        Assert.assertEquals(driver.getTitle(), "Online Web Tutorials");
        Reporter.log("testFail executed");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    public static String capture(String screenshotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + ".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
        Reporter.log("path for the screenshot is : "+ dest);
        return dest;
    }
}
