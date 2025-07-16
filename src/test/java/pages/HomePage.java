package pages;

import com.fasterxml.jackson.databind.ser.Serializers;

import static tools.CommonTools.getByObject;
import static tools.CommonTools.sleep;

public class HomePage extends BasePage {

    private static final String HOME_PAGE_WELCOME_MESSAGE = "id=welcome";

    public static String getHomePageWelcomeMessage() {
        return HOME_PAGE_WELCOME_MESSAGE;
    }

    public void assertHomePageIsOpened() {
        wait.forElementToBeDisplayed(10,
                getByObject(getHomePageWelcomeMessage()),
                "Welcome message");
    }
}
