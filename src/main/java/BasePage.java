import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
  public static   WebDriver driver;

    public BasePage() {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
