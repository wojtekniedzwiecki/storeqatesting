package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommentPage extends Page {


   public CommentPage(WebDriver driver, WebDriverWait wait) {

      super(driver, wait);
   }

   public static By commentList = By.cssSelector(".commentlist");
   public static By waitingMessage = By.cssSelector(".commentlist em");
   public static By commentAuthor = By.cssSelector(".comment-author cite");



   @Override
   public By getVisibilityCheckIdentifier() {
      return commentList;
   }

}