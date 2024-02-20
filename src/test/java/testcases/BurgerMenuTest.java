package testcases;

import factory.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.VerifyInDriver;

public class BurgerMenuTest extends BaseTest {

    private BurgerMenu burgerMenu;
    private VerifyInDriver verify;
    private LoginPage loginPage;

    @BeforeMethod
    private void injectDriver() {
        burgerMenu = new BurgerMenu(driver);
        loginPage = new LoginPage(driver);
        verify = new VerifyInDriver(driver);
    }

    @Test(dataProvider = "loggout-data")
    public void notLoggedBurgerTest(String url) {
        navigateTo(url);
        burgerMenu.openBurgerMenu();
        verify.elementIsPresent(burgerMenu.homeMenu);
        verify.elementIsPresent(burgerMenu.loginMenu);

        verify.elementIsNotPresent(burgerMenu.historyMenu);
        verify.elementIsNotPresent(burgerMenu.logoutMenu);
        verify.elementIsNotPresent(burgerMenu.profileMenu);
    }

    @Test(dataProvider = "logged-data")
    public void loggedBurgerTest(String url){
        loginPage.navigateToPage();
        loginPage.login();
        navigateTo(url);
        burgerMenu.openBurgerMenu();

        verify.elementIsPresent(burgerMenu.homeMenu);
        verify.elementIsPresent(burgerMenu.historyMenu);
        verify.elementIsPresent(burgerMenu.logoutMenu);
        verify.elementIsPresent(burgerMenu.profileMenu);

        verify.elementIsNotPresent(burgerMenu.loginMenu);
    }

    @DataProvider(name = "loggout-data")
    public Object[][] loggoutDataProvider(){
        return new Object[][] {
                {HomePage.url}
                ,{LoginPage.url}
        };
    }

    @DataProvider(name = "logged-data")
    public Object[][] loggedDataProvider(){
        return new Object[][]{
                {HomePage.url}
                ,{HistoryPage.url}
                ,{ProfilePage.url}
                ,{AppointmentPage.url}
        };
    }
}