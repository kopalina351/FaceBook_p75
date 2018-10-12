package pages;

import libs.ConfigData;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class HomePage {
    private final WebDriverWait webDriverWait;
    WebDriver driver;
    Logger logger;
    final String errorInput = "Can't work with input ";
    final String errorButton = "Can not work with button ";
    final String baseUrl = "http://facebook.com";

    @FindBy(id = "email")
    WebElement inputLogin;

    @FindBy(id = "pass")
    WebElement inputPass;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement buttonLogIn;


    public HomePage(WebDriver exterDriver) {
        this.driver = exterDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    /**
     * Method opens Browser And HomePage
     */
    public void openBrowserAndHomePage() {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.get(ConfigData.getCfgValue("BASE_URL"));
            if (driver.getCurrentUrl().toString().equals(baseUrl) == true) {
                logger.info("Home page was opened");
            } else logger.error("Home page wasn't opened");
        } catch (Exception e) {
            logger.error("Can not work with HomePage");
            Assert.fail("Can not work with HomePage");
        }
    }

    /**
     * Method inputs Login
     * @param logIn
     */
    public void inputLogin(String logIn) {
        try {
            inputLogin.clear();
            inputLogin.sendKeys(logIn);
            logger.info("Login "+ "'"+logIn+"'"+" was inputted");
        } catch (Exception e) {
            logger.error(errorInput);
            Assert.fail(errorInput);
        }
    }

    /**
     * Method inputs Password
     */
    public void inputPassword(String pass) {
        try {
            inputPass.clear();
            inputPass.sendKeys(pass);
            logger.info("Password"+"'"+pass+"'"+" was inputted");
        }catch (Exception e){
            logger.error(errorInput);
            Assert.fail(errorInput);
        }
    }

    /**
     * Method clicks On Button LogOut
     */
    public void submitButtonLogIn() {
        try {
            buttonLogIn.submit();
            logger.info("Button 'LogIn' was submitted");
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
     * Method does Close Browser
     */
    public void closeBrowser() {
        driver.quit();
        logger.info("Browser was closed");
    }
}
