package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class Page {

   WebDriver driver;
   public WebDriverWait wait;

   public Page(WebDriver driver, WebDriverWait wait){
      this.driver = driver;
      this.wait = wait;
   }

   protected abstract By getVisibilityCheckIdentifier();


   public void click (By elementLocation) {
      driver.findElement(elementLocation).click();
   }

   public Page writeText (By elementLocation, String text) {
      driver.findElement(elementLocation).sendKeys(text);
      return this;
   }

}