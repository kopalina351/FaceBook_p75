package FB_HW1;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.HomePage;


public class LoginOnFaceBookAndCloseBrowser {
    WebDriver driver = new ChromeDriver();
    HomePage homePage = new HomePage(driver);
    AccountPage accountPage = new AccountPage(driver);

    @Test
    public void LoginOnFaceBookAndCloseBrowser() {

        homePage.openBrowserAndHomePage();
        homePage.inputLogin("+380637618268");
        homePage.inputPassword("qwerty123456");
        homePage.submitButtonLogIn();
        accountPage.isAccountPage();
    }

    @After
    public void tearDown() { accountPage.logOutAndCloseBrowser();
    }
}