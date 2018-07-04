package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Page {

   public HomePage (WebDriver driver, WebDriverWait wait) {
      super(driver, wait);
   }

   String homePageURL = "http://store.demoqa.com/";
   By samplePageLink = By.cssSelector("a[href=\"http://store.demoqa.com/sample-page/\"]");


   public HomePage goToStoreDemoQA (){
      driver.get(homePageURL);
      return this;
   }

   public Page clickSamplePageLink() {
      click(samplePageLink);
      return this;
   }

   @Override
   protected By getVisibilityCheckIdentifier() {
      return By.cssSelector(".current_page_item [href=\"http://store.demoqa.com/\"]");
   }
}