package moonwareTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import settings.Config;

import java.net.URL;

public class IOSAppiumTest {
    private static IOSDriver driver;
    private static final String appPath = "/Users/jack.cruzan/Library/Developer/Xcode/DerivedData/SpotifyClone-cchhqihqognxizeoopewsetwqmco/Build/Products/Debug-iphonesimulator/SpotifyClone.app";

    @BeforeClass
    public static void setUp() throws Exception {
        XCUITestOptions options = new XCUITestOptions();
        options.setCapability("platformName", "iOS");
        options.setCapability("platformVersion", "18.0");
        options.setCapability("deviceName", "iPhone 16 Pro");
        options.setCapability("app", appPath);
        options.setCapability("automationName", "XCUITest");
        options.setCapability("maxTypingFrequency", 10);

        driver = new IOSDriver(new URL("http://localhost:4723"), options);
    }
    public static void login() throws InterruptedException {
        Config config = new Config();
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

    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static IOSDriver getDriver() {
        return driver;
    }

}
