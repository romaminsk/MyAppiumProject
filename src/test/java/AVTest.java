import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AVTest {
    private AndroidDriver<AndroidElement> driver;

    @BeforeMethod
    public void setUp() {
        // Set up Appium capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/roma/Downloads/av.apk");

        // Set up Selenide configuration
        Configuration.browser = "appium";
        Configuration.browserCapabilities = capabilities;

        // Initialize Appium driver
        try {
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void exampleTest() {
        // Find an element using Selenide syntax
        SelenideElement element = $("your-element-selector");

        // Perform actions on the element
        element.shouldBe(visible).click();

        // Add more test assertions and actions here
    }

    @AfterMethod
    public void tearDown() {
        // Quit the driver and close the app
        if (driver != null) {
            driver.quit();
        }
    }
}
