package moonwareTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.Config;

import java.time.Duration;

public class LoginTest {
    @Test
    public void test() throws Exception {
        try {
//            setup
            IOSAppiumTest.setUp();
            Config config = new Config();
            IOSDriver driver = IOSAppiumTest.getDriver();

//            test
//            TODO: fix these explicit thread calls
            System.out.println("clicking LOG IN button");
            driver.findElement(AppiumBy.accessibilityId("LOG IN")).click();
            Thread.sleep(5000);
            System.out.print("typing email/username " + config.getEmail());
            driver.findElement(AppiumBy.name("Email or username")).sendKeys(config.getEmail());
            driver.findElement(AppiumBy.name("Done")).click();
            Thread.sleep(2000);
            System.out.println("typing passowrd");
            driver.findElement(AppiumBy.name("Password")).sendKeys(config.getPassword());
            System.out.println("clicking log in");
            driver.findElement(AppiumBy.accessibilityId("Log In")).click();
            Thread.sleep(5000);
            Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("settings")).isDisplayed());

//            teardown
            IOSAppiumTest.tearDown();
        } catch (Error e) {
            System.out.println("Error for login test: " + e);
        }

    }
}
