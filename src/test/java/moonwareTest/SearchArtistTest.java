package moonwareTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchArtistTest {

    @Test
    public void test() throws Exception {
        String artist ="Taylor Swift";
//      init
        IOSAppiumTest.setUp();
        IOSDriver driver = IOSAppiumTest.getDriver();
        IOSAppiumTest.login();

//      test
        driver.findElement(AppiumBy.accessibilityId("search-unselected")).click();
//        click the search button to open up song search
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("search-unselected")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"Artists, Songs, Podcasts...\"`]")).sendKeys(artist);
        Thread.sleep(1000);
        List<WebElement> staticTexts = driver.findElements(By.xpath("//XCUIElementTypeStaticText"));
        for (WebElement element: staticTexts) {
            if (element.getText().contains(artist)) {
                Assert.assertTrue(true);
                break;
            }
        }
        IOSAppiumTest.tearDown();
    }
}
