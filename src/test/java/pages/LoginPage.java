package pages;

import factory.Globals;
import factory.data.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;
    public static String url = Globals.BASE_URL + "profile.php#login";
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void login(String username, String password){
        if (username != null) getUsernameField().sendKeys(username);
        if (password != null) getPasswordField().sendKeys(password);
        getLoginButton().click();
    }

    public void login(){
        getUsernameField().sendKeys(Users.JOHN_DOE.username);
        getPasswordField().sendKeys(Users.JOHN_DOE.password);
        getLoginButton().click();
    }

    public void navigateToPage(){ driver.navigate().to(url);}

    private WebElement getUsernameField(){ return driver.findElement(By.id("txt-username")); }
    private WebElement getPasswordField(){ return driver.findElement(By.id("txt-password")); }
    private WebElement getLoginButton(){ return driver.findElement(By.id("btn-login")); }

    public WebElement getLoginErrorMessage(){ return driver.findElement(By.xpath("//*[@class='lead text-danger']")); }
    public String expectedLoginErrorMessage = "Login failed! Please ensure the username and password are valid.";
}