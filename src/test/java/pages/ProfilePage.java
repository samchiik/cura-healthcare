package pages;

import factory.Globals;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private final WebDriver driver;
    public static String url = Globals.BASE_URL + "profile.php#profile";

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }
}