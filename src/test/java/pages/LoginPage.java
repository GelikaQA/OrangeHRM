package pages;

import org.openqa.selenium.devtools.v111.domsnapshot.model.StringIndex;
import tools.PropertiesLoader;

import java.util.DoubleSummaryStatistics;

import static tools.CommonTools.getByObject;
import static tools.CommonTools.sleep;

public class LoginPage extends BasePage {
    private static final String URL = "http://hrm-online.portnov.com/symfony/web/index.php/auth/login";
    private static final String LOGIN_USERNAME_INPUT_FIELD = "name=txtUsername";
    private static final String LOGIN_PASSWORD_INPUT_FIELD = "name=txtPassword";
    private static final String LOGIN_SUBMIT_BUTTON = "name=Submit";

    public static String getUrl() {
        return URL;
    }

    public static String getLoginUsernameInputField() {
        return LOGIN_USERNAME_INPUT_FIELD;
    }

    public static String getLoginPasswordInputField() {
        return LOGIN_PASSWORD_INPUT_FIELD;
    }

    public static String getLoginSubmitButton() {
        return LOGIN_SUBMIT_BUTTON;
    }

    public void openUrl() {
        driver.get(getUrl());
    }

    public void signIn() {
        openUrl();
        driver.findElement(getByObject(getLoginUsernameInputField())).sendKeys(PropertiesLoader.getProperties("username"));
        driver.findElement(getByObject(getLoginPasswordInputField())).sendKeys(PropertiesLoader.getProperties("password"));
        driver.findElement(getByObject(getLoginSubmitButton())).click();
    }
}
