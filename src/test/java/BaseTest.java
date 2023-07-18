import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.driver.DriverFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    @BeforeMethod
    @Parameters({"platform"})
    public void setUp(String platform) {

        WebDriverRunner.closeWebDriver();

        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
        AppiumDriver<?> driver = new DriverFactory().createInstance(platform);

        WebDriverRunner.setWebDriver(driver);
    }
}
