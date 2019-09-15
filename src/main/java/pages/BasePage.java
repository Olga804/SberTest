package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class BasePage {
    WebDriver driver = BaseSteps.getDriver();

    public BasePage(){
        PageFactory.initElements(driver, this);
    }

   /* public boolean psElementPresent(){

    }

    */

    public void fillField(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }
     public void click(WebElement element){
         ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)", element);
         Wait<WebDriver>wait = new WebDriverWait(driver, 15);
         wait.until(ExpectedConditions.elementToBeClickable(element));
         element.click();
     }
}
