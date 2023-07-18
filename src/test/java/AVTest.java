import com.codeborne.selenide.SelenideElement;
import org.example.utils.Waiters;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class AVTest extends BaseTest {

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
