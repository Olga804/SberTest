import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPage extends BasePage {

    @FindBy(xpath = "//button[contains(@aria-label,'Ипотека')]")
    private WebElement searchTextField;


    @FindBy(xpath = "//a[contains(text(),'Ипотека на готовое')]")
    WebElement searchButton;

    @Step("Стартовая траницы. Наведение на Ипотека, дождаться появления выпадающего меню, нажать на Ипотека на готовое жилье.")
    public void search(){
        Actions actions = new Actions(driver);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(searchTextField));
        actions.moveToElement(searchTextField).build().perform();
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();

    }
}
