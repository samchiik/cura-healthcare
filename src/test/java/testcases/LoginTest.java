package testcases;

import factory.BaseTest;
import factory.data.Users;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AppointmentPage;
import pages.HomePage;
import pages.LoginPage;
import utils.Verify;
import utils.VerifyInDriver;

public class LoginTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private VerifyInDriver verify;

    @BeforeMethod
    private void injectDriver(){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        verify = new VerifyInDriver(driver);
    }

    @Test
    public void successfulLoginTest(){
        homePage.navigateToPage();
        homePage.makeAppointment();
        loginPage.login();
        verify.url(AppointmentPage.url);
    }

    @Test
    public void wrongUsernameTest(){
        homePage.navigateToPage();
        homePage.makeAppointment();
        loginPage.login(Users.WRONG.username, Users.JOHN_DOE.password);
        verify.url(LoginPage.url);
        Verify.elementText(loginPage.getLoginErrorMessage(), loginPage.expectedLoginErrorMessage);
    }

    @Test
    public void wrongPasswordTest(){
        homePage.navigateToPage();
        homePage.makeAppointment();
        loginPage.login(Users.JOHN_DOE.username, Users.WRONG.password);
        verify.url(LoginPage.url);
        Verify.elementText(loginPage.getLoginErrorMessage(), loginPage.expectedLoginErrorMessage);
    }

    @Test
    public void wrongUsernameAndPasswordTest(){
        homePage.navigateToPage();
        homePage.makeAppointment();
        loginPage.login(Users.WRONG.username, Users.WRONG.password);
        verify.url(LoginPage.url);
        Verify.elementText(loginPage.getLoginErrorMessage(), loginPage.expectedLoginErrorMessage);
    }

    @Test
    public void emptyUsernameTest(){
        homePage.navigateToPage();
        homePage.makeAppointment();
        loginPage.login(Users.EMPTY.username, Users.JOHN_DOE.password);
        verify.url(LoginPage.url);
        Verify.elementText(loginPage.getLoginErrorMessage(), loginPage.expectedLoginErrorMessage);
    }

    @Test
    public void emptyPasswordTest(){
        homePage.navigateToPage();
        homePage.makeAppointment();
        loginPage.login(Users.JOHN_DOE.username, Users.EMPTY.password);
        verify.url(LoginPage.url);
        Verify.elementText(loginPage.getLoginErrorMessage(), loginPage.expectedLoginErrorMessage);
    }

    @Test
    public void emptyUsernameAndPasswordTest(){
        homePage.navigateToPage();
        homePage.makeAppointment();
        loginPage.login(Users.EMPTY.username, Users.EMPTY.password);
        verify.url(LoginPage.url);
        Verify.elementText(loginPage.getLoginErrorMessage(), loginPage.expectedLoginErrorMessage);
    }

    /**
     * Non passant avec un data provider
     *
     */
    /*@DataProvider(name = "Non-Passing")
    private Object[][] dataProvidingMethod(){
        return new Object[][]{
                {Users.WRONG.username, Users.JOHN_DOE.password}
                ,{Users.JOHN_DOE.username, Users.WRONG.password}
                ,{Users.WRONG.username, Users.WRONG.password}
                ,{Users.EMPTY.username, Users.JOHN_DOE.password}
                ,{Users.JOHN_DOE.username, Users.EMPTY.password}
                ,{Users.EMPTY.username, Users.EMPTY.password}
        };
    }

    @Test(dataProvider = "Non-Passing")
    public void nonPassingTests(String usernme, String password){
        homePage.navigateToPage();
        homePage.makeAppointment();
        loginPage.login(usernme, password);
        verify.url(LoginPage.url);
        Verify.elementText(loginPage.getLoginErrorMessage(), loginPage.expectedLoginErrorMessage);
    }*/
}