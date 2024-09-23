package moonwareTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class MusicPlaybackTest {

    @Test
    public void test() throws Exception{
//        init
        IOSAppiumTest.setUp();
        IOSDriver driver = IOSAppiumTest.getDriver();
        IOSAppiumTest.login();

//        test
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeApplication[@name=\"SpotifyClone\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage[2]")).click();
        String timestampAfterStart = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, '00:')]")).getText();
        driver.findElement(AppiumBy.accessibilityId("circle-play")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.accessibilityId("circle-stop")).click();
        String timestampAfterStop = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, '00:')]")).getText();
        Assert.assertNotEquals(timestampAfterStart, timestampAfterStop);

//        teardown
        IOSAppiumTest.tearDown();

    }
}
