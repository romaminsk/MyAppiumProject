import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.example.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$;

public class AVTest {
    private AppiumDriver<MobileElement> driver;

    @BeforeMethod
    public void setUp() {
        WebDriverRunner.closeWebDriver();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
        capabilities.setCapability(MobileCapabilityType.APP, "C:/Users/User/Downloads/av.apk");
        try {
            driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        WebDriverRunner.setWebDriver(driver);
    }

    @Test
    public void exampleTest() {
        SelenideElement allowButton = $(By.id("com.android.permissioncontroller:id/permission_allow_button"));

        Waiters.waitUntilClickable(allowButton);
        allowButton.click();

        SelenideElement clickView = $(By.id("clickView"));
        clickView.click();

        SelenideElement myAdText = $(By.xpath("//android.widget.TextView[@text='Мои объявления']"));

        Assert.assertTrue(myAdText.isDisplayed());
    }
}
