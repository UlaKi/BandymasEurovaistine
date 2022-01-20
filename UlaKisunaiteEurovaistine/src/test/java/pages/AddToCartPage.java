package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartPage {

   public WebDriver driver;

   public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

   //public By searchInput = By.className("sn-suggest-input");
   //public By pageTitle = By.tagName("h1");
   public By productBrand = By.cssSelector(".filter-hdr");
   public By productBrandTitle = By.className("filter-hdr");
   public By productName = By.cssSelector(".filter-text-search .form-control");

    //public WebElement getPageTitle = driver.findElement(pageTitle);
}
