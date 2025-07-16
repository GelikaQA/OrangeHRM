package steps;

import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import pages.LoginPage;

public class HomePageSteps {
    private static final Logger log = LoggerFactory.getLogger(HomePageSteps.class);
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("a user is on Home Page")
    public void userIsOnHomePage() {
        loginPage.signIn();
        homePage.assertHomePageIsOpened();
    }
}
