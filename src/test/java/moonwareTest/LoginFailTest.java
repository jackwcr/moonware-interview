package moonwareTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.junit.Test;

public class LoginFailTest {

    @Test
    public void test() throws Exception {
//        setup
        IOSAppiumTest.setUp();
        IOSDriver driver = IOSAppiumTest.getDriver();

//        test
        System.out.println("clicking LOG IN button");
        driver.findElement(AppiumBy.accessibilityId("LOG IN")).click();
        Thread.sleep(5000);
        System.out.print("typing email/username");
        driver.findElement(AppiumBy.name("Email or username")).sendKeys("haha");
        driver.findElement(AppiumBy.name("Done")).click();
        Thread.sleep(2000);
        System.out.println("typing passowrd");
        driver.findElement(AppiumBy.name("Password")).sendKeys("dasdsa");
        System.out.println("clicking log in");
        driver.findElement(AppiumBy.accessibilityId("Log In")).click();
        Assert.assertTrue(driver.findElement(AppiumBy.accessibilityId("Incorrect username or password.")).isDisplayed());

    }
}
