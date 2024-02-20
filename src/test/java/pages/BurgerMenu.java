package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BurgerMenu {
    private final WebDriver driver;
    public static String url;

    public BurgerMenu(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getToggleBurgerMenu(){ return driver.findElement(By.id("menu-toggle")); }
    private WebElement getSidebar(){ return driver.findElement(By.id("sidebar-wrapper")); }
    public By homeMenu = By.xpath("//*[text()='Home']");
    public By loginMenu = By.xpath("//*[text()='Login']");
    public By historyMenu = By.xpath("//*[text()='History']");
    public By profileMenu = By.xpath("//*[text()='Profile']");
    public By logoutMenu = By.xpath("//*[text()='Logout']");

    public void openBurgerMenu(){
        if (!getSidebar().isDisplayed()) getToggleBurgerMenu().click();
    }

    public void closeBurgerMenu(){
        if (getSidebar().isDisplayed()) getToggleBurgerMenu().click();
    }
}