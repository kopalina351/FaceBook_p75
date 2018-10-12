package pages;

import libs.ConfigData;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class AccountPage {
    private final WebDriverWait webDriverWait;
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can't work with input ";
    final String errorButton = "Can not work with button ";
    final String errorCheckBox = "Can not work with checkbox ";
    final String baseUrl = "http://facebook.com";

    @FindBy(id = "userNavigationLabel")
    WebElement buttonAccountSettings;

    @FindBy(xpath = "//span[@class='_54nh']/form[@method='post']")
    WebElement buttonLogOut;

    @FindBy(xpath = "//a[@title]/span/span[contains(text(),'Home')]")
    WebElement isAccountPagePresent;


    public AccountPage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void isAccountPage() {
        String handle= driver.getWindowHandle();
        driver.switchTo().window(handle);
       /* Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept(); */
       try {
            isAccountPagePresent.isDisplayed();
            logger.info("Title is displayed");
        }catch (Exception e){
            logger.error("Can not work with AccountPage");
            Assert.fail("Can not work with AccountPage");
        }
    }

    /**
     * Method clicks on Button 'Account Settings'
     */
    public void clickOnMenuAccountSettings() {
        try {
            buttonAccountSettings.click();
            logger.info("Button 'Account Settings' was clicked");
        }catch (Exception e){
            logger.error(errorButton);
            Assert.fail(errorButton);
        }
    }

    /**
     * Method clicks On Button LogOut
     */
    public void clickOnButtonLogOut() {
        try {
            buttonLogOut.click();
            logger.info("Button 'LogOut' was clicked");
        } catch (Exception e) {
            logger.error(errorButton);
            Assert.fail(errorButton);
        }
    }
    private void waitSomeSec (int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method does logOut And Close Browser
     */
    public void logOutAndCloseBrowser() {
    //    clickOnMenuAccountSettings();
    //    clickOnButtonLogOut();
        driver.quit();
        logger.info("Browser was closed");
    }
    /**
     * Method does Close Browser
     */
    public void closeBrowser() {
        driver.quit();
        logger.info("Browser was closed");
    }
}
