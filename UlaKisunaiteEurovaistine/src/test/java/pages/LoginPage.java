package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By registration = By.id("customer_registration");
    public By registrationButton = By.xpath("//button[contains(@class,'btn btn-green')]");

    public By visibleLogin = By.className("default-form");

    public By registrationEmail = By.id("customer_registration_email");
    public By password = By.id("customer_registration_user_plainPassword_first");
    public By repeatPassword = By.id("customer_registration_user_plainPassword_second");

    public By generalOffers = By.id("customer_registration_marketing_generalOffers");
    public By personalOffers = By.id("customer_registration_marketing_personalOffers");

    public By addressInput = By.id("customer_registration_marketing_typeAddress");
    public By registrationForm = By.xpath("//div[starts-with(@class, 'datatable')]");


    public WebElement getLogin() {return driver.findElement(visibleLogin); }
    public WebElement getRegistration() { return driver.findElement(registration); }
    public WebElement getRegistrationButton() { return driver.findElement(registrationButton); }

    public WebElement getEmail(){ return driver.findElement(registrationEmail); }
    public WebElement getPassword(){ return  driver.findElement(password); }
    public WebElement repeatPassword(){ return  driver.findElement(repeatPassword); }

    public WebElement getGeneralOffers(){ return  driver.findElement(generalOffers); }
    public WebElement getPersonalOffers(){ return  driver.findElement(personalOffers); }
    public WebElement getAddressInput(){ return  driver.findElement(addressInput); }


    public void registrationFormIsFillUp() {
        String text = "testas@gmail.com";
        String passText = "Testukas5";

        getEmail().sendKeys(text);
        getPassword().sendKeys(passText);
        repeatPassword().sendKeys(passText);
        getGeneralOffers().click();
        getPersonalOffers().click();
        getAddressInput().click();
    }

    public void pressRegistrationButton(){
        getRegistration();
        getRegistrationButton().click();
    }
}
