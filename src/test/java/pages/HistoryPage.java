package pages;

import factory.Globals;
import org.openqa.selenium.WebDriver;

public class HistoryPage {
    private final WebDriver driver;
    public static String url = Globals.BASE_URL + "history.php#history";

    public HistoryPage(WebDriver driver) {
        this.driver = driver;
    }
}