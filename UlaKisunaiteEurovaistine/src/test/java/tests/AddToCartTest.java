package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.BasePage;
import tests.BaseTest;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static units.WaitUtils.waitForElementToBeVisible;

public class AddToCartTest extends BaseTest {

    public List<WebElement> element;

    String inputText;
    String expectedText;

   // @Factory(dataProvider = "navigation")
   // public enterInformation(String inputText, String expectedText){
   //     this.inputText = inputText;
    //    this.expectedText = expectedText;
   // }

    //@DataProvider(name = "search")
    //public static Object[][] searchData(){
    //    return new Object[][] {
        //       {("Gripex, plėvele dengtos tabletės, N12"), ("Gripex, plėvele dengtos tabletės, N24")}
       // };
    //}

    @Test(priority = 0)
    public void acceptAllCookies() {
        BasePage basePage = new BasePage(driver);
        basePage.clickAcceptCookies();
    }

    @Test(priority = 1)
    public void enterTextClickSearchAndPressEnterCheckSearchName() {
        WebElement element = driver.findElement(By.className("sn-suggest-input"));
        String searchText = "Nereceptiniai vaistai";
        String expectedResults = "Paieškos rezultatai ieškant \"Nereceptiniai vaistai\"";
        element.sendKeys(searchText);
        element.sendKeys(Keys.ENTER);
        String pageName = driver.findElement(By.tagName("h1")).getText();
        assertEquals(pageName,expectedResults,"Page title was not correct");
    }

    @Test(priority = 2)
    public void enterProductBrand() {
        AddToCartPage addToCartPage = new AddToCartPage(driver);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCartPage.productBrand));
        element = driver.findElements(addToCartPage.productBrandTitle);
        WebElement productBrand = element.stream()
                .filter(zodis -> zodis.getText().contains("Prekės ženklas:")).findAny().get();
        productBrand.click();

        driver.findElement(addToCartPage.productName).sendKeys("GRIPEX");

        WebDriverWait waiting = new WebDriverWait(driver,Duration.ofSeconds(2));
        waiting.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@value=GRIPEX]")));
        driver.findElement(By.xpath("input[@value='GRIPEX']")).click();
        //WebDriverWait waiting = new WebDriverWait(driver,Duration.ofSeconds(2));
        //waiting.until(ExpectedConditions.attributeToBe(By.xpath("//*(contains(@class,'filter-input'))")),"filter-input","GRIPEX");
        //driver.findElement(By.xpath("//input[@value=GRIPEX]")).click();
    }

   // @Test(priority = 3)
    //public void checkProductsTitles() {
    //    List<WebElement> searchResults = driver.findElements(By.cssSelector(".product-card--link"));
     //   System.out.println("Puslapyje atvaizduojama prekių: " + searchResults.size());

     //   searchResults.stream()
       //         .filter(searchResult -> searchResult.getText().contains("GRIPEX"))
       //         .findFirst().get().click();
   // }

   // @Test(priority = 4)
   // public void itemPutInCart() throws InterruptedException {
     //   if (driver.findElement(By.cssSelector("#stickyCartButton")).isDisplayed()) {
      //      System.out.println("\"Į krepšelį\" mygtukas pasirodė" );
       // }
      //  boolean modalIsVisible = driver.findElement(By.cssSelector(".modal-content-inner")).isDisplayed();
       // Thread.sleep(2000);
      //  if (modalIsVisible == true) {
       //     System.out.println("Prekė sėkmingai įdėta į krepšelį");
       // } else {
       //     System.out.println("Prekė neįdėta į krepšelį");
       // }
   // }
}
