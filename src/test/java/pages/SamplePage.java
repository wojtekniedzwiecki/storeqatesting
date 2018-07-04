package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SamplePage extends Page {


   public SamplePage(WebDriver driver, WebDriverWait wait) {
      super(driver, wait);
   }


   public static By samplePageHeader = By.cssSelector("h1.entry-title");
   public static By commentTextField = By.id("comment");
   public static By authorTextField = By.id("author");
   public static By emailTextField = By.id("email");
   public static By submitButton = By.id("submit");

   @Override
   public By getVisibilityCheckIdentifier() {
      return samplePageHeader;
   }

}