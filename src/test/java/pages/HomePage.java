package pages;

import factory.Globals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    public static String url = Globals.BASE_URL;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void makeAppointment(){
        driver.findElement(By.id("btn-make-appointment")).click();
    }

    public void navigateToPage(){ driver.navigate().to(url);}
}