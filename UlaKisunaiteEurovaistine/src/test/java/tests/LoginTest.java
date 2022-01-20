package tests;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;
import static units.WaitUtils.waitForElementToBeVisible;

public class LoginTest extends BaseTest {

    @Test (priority = 0)
    public void acceptAllCookiesLoginAndRegister() {
        BasePage basePage = new BasePage(driver);
        basePage.clickAcceptCookies();
        basePage.clickLogin();
    }

    @Test(priority = 1)
    public void loginAndRegistrationFormIsDisplayed() {
            LoginPage loginPage = new LoginPage(driver);

            boolean loginVisible = loginPage.getLogin().isDisplayed();
            assertTrue(loginVisible, "Something is wrong");

            boolean registrationFormVisible = loginPage.getRegistration().isDisplayed();
            assertTrue(registrationFormVisible, "Registration form not visible");

            waitForElementToBeVisible(driver,loginPage.registrationForm, 5);
            loginPage.registrationFormIsFillUp();
            loginPage.pressRegistrationButton();
    }
}
