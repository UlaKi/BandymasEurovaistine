package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static units.WaitUtils.waitForElementToBeVisible;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public By cookieBanner = By.id("onetrust-button-group");
    public By acceptCookies = By.id("onetrust-accept-btn-handler");
    public By login = By.id("user-block");

    public WebElement acceptCookies() { return driver.findElement(acceptCookies); }
    public WebElement findLogin() {return driver.findElement(login); }

    public void clickAcceptCookies() {
        waitForElementToBeVisible(driver, cookieBanner, 5);
        acceptCookies().click();
    }

    public void clickLogin(){
        findLogin().click();
    }
}
