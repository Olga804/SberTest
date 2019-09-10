import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class CreditPage  {

    By estateCost = By.xpath("//input[@id='estateCost']");
    By initialFee = By.xpath("//input[@id='initialFee']");
    By creditTerm = By.xpath("//input[@id='creditTerm']");
    By paidToCard = By.xpath("//input[@data-test-id='paidToCard']");
    By canConfirmIncome = By.xpath("//input[@data-test-id='canConfirmIncome']");
    By youngFamilyDiscount = By.xpath("//input[@data-test-id='youngFamilyDiscount']");
    /*  By amountOfCredit = By.xpath("//div[@data-test-id = amountOfCredit]");
    By mounthlyPayment = By.xpath("//div[@data-test-id = mounthlyPayment]");
    By requiredIncome = By.xpath("//div[@data-test-id = requiredIncome]");
    By rate = By.xpath("//div[@data-test-id = rate]");

    */

   WebDriver driver;

    public CreditPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void writeForm(String fullPrice, String  pay, String period){
        driver.switchTo().frame("iFrameResizer0");
         ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(estateCost) );
        driver.findElement(estateCost).clear();
        driver.findElement(estateCost).sendKeys(fullPrice);
        waitingChenge(initialFee);
        driver.findElement(initialFee).clear();
        driver.findElement(initialFee).sendKeys(pay);
        driver.findElement(creditTerm).clear();
        driver.findElement(creditTerm).sendKeys(period);


        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(creditTerm) );

        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(paidToCard)));
        if(driver.findElement(paidToCard).isSelected()){
           driver.findElement(paidToCard).click();
        }
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(canConfirmIncome)));
        if(!driver.findElement(canConfirmIncome).isSelected()){
            driver.findElement(canConfirmIncome).click();
        }
        if(!driver.findElement(youngFamilyDiscount).isSelected()){
            driver.findElement(youngFamilyDiscount).click();
        }

    }


    public void waitingChenge(By by){
        String oldValue = driver.findElement(by).getAttribute("value");
        Function<? super WebDriver, Object> valueChanged = new ExpectedCondition<Object>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return !webDriver.findElement(by).getAttribute("value").equals(oldValue);
            }
        };
        //действие для изменения значения
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(valueChanged);
    }


}
