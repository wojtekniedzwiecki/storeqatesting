package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorPage extends Page {


   public ErrorPage(WebDriver driver, WebDriverWait wait) {

      super(driver, wait);
   }

   public static By errorStrong = By.cssSelector("p strong");
   public static By backButton = By.cssSelector("p a");


   @Override
   public By getVisibilityCheckIdentifier() {
      return errorStrong;
   }

}