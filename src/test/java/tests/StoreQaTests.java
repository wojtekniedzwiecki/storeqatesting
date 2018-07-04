package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommentPage;
import pages.ErrorPage;
import pages.HomePage;
import pages.SamplePage;

import static org.junit.Assert.assertEquals;


public class StoreQaTests {
   public static WebDriver driver;
   public static WebDriverWait wait;


   HomePage homePage = new HomePage(this.driver, this.wait);
   SamplePage samplePage = new SamplePage(this.driver, this.wait);
   ErrorPage errorPage = new ErrorPage(this.driver, this.wait);
   CommentPage commentPage = new CommentPage(this.driver, this.wait);

   @BeforeClass
   public static void setup () {
      System.setProperty("webdriver.chrome.driver", "/Users/niedzww/workspace/chromedriver");
      driver = new ChromeDriver();
      wait = new WebDriverWait(driver,15);
      driver.manage().window().maximize();
   }

   @AfterClass
   public static void teardown () {
      ChromeDriver driver = new ChromeDriver();
      driver.quit();
   }

   @Test
   public void sendCommentWithWrongEmail() {
      homePage.goToStoreDemoQA().clickSamplePageLink()
         .wait.until(ExpectedConditions.presenceOfElementLocated(samplePage.getVisibilityCheckIdentifier()));
      samplePage.writeText(samplePage.commentTextField, "test comment" )
         .writeText(samplePage.authorTextField, "test author")
         .writeText(samplePage.emailTextField, "wrong email")
         .click(samplePage.submitButton);
      errorPage.wait.until(ExpectedConditions.presenceOfElementLocated(errorPage.getVisibilityCheckIdentifier()));
      assertEquals(driver.findElement(errorPage.errorStrong).getText(), "ERROR");
      driver.findElement(errorPage.backButton).click();
      samplePage.wait.until(ExpectedConditions.presenceOfElementLocated(samplePage.getVisibilityCheckIdentifier()));
   }

   @Test
   public void sendCommentWithValidEmail() {
      homePage.goToStoreDemoQA().clickSamplePageLink()
         .wait.until(ExpectedConditions.presenceOfElementLocated(samplePage.getVisibilityCheckIdentifier()));
      samplePage.writeText(samplePage.commentTextField, "test comment" )
         .writeText(samplePage.authorTextField, "test author")
         .writeText(samplePage.emailTextField, "validemail@adidas.com")
         .click(samplePage.submitButton);
      commentPage.wait.until(ExpectedConditions.presenceOfElementLocated(commentPage.getVisibilityCheckIdentifier()));
      assertEquals(driver.findElement(commentPage.commentAuthor).getText(), "test author");
      assertEquals(driver.findElement(commentPage.waitingMessage).getText(), "Your comment is awaiting moderation.");

   }
}