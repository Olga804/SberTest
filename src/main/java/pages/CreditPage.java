package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class CreditPage extends BasePage{
    By estateCost = By.xpath("//input[@id='estateCost']");
    By initialFee = By.xpath("//input[@id='initialFee']");
    By creditTerm = By.xpath("//input[@id='creditTerm']");
    By paidToCard = By.xpath("//input[@data-test-id='paidToCard']/..");//input[@data-test-id='paidToCard']/..
    By canConfirmIncome = By.xpath("//input[@data-test-id='canConfirmIncome']/..");
    By youngFamilyDiscount = By.xpath("//input[@data-test-id='youngFamilyDiscount']/..");
    By amountOfCredit = By.xpath("//span[@data-test-id = 'amountOfCredit']");
    By monthlyPayment = By.xpath("//span[@data-test-id = 'monthlyPayment']");
    By requiredIncome = By.xpath("//span[@data-test-id = 'requiredIncome']");
    By rate = By.xpath("//span[@data-test-id = 'rate']");

    //WebDriver driver;

   // public CreditPage(WebDriver driver) {
     //   this.driver = driver;
    //    PageFactory.initElements(driver, this);
   // }


    public void writeForm(String fullPrice, String  pay, String period) {

        driver.switchTo().frame("iFrameResizer0");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(estateCost));
        driver.findElement(estateCost).clear();
        String oldValue = driver.findElement(initialFee).getAttribute("value");
        driver.findElement(estateCost).sendKeys(fullPrice);
        waitingChenge(oldValue,initialFee,"value");
        driver.findElement(initialFee).clear();
        driver.findElement(initialFee).sendKeys(pay);
        driver.findElement(creditTerm).clear();
        driver.findElement(creditTerm).sendKeys(period);

    }

    public void press(){

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(creditTerm) );

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(paidToCard)).build().perform();

        Wait<WebDriver> wait = new WebDriverWait(driver, 15, 3000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(paidToCard)));
            driver.findElement(paidToCard).click();


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(canConfirmIncome)));
            driver.findElement(canConfirmIncome).click();


        if(!driver.findElement(By.xpath("//input[@data-test-id='youngFamilyDiscount']")).isSelected()){
            String oldValue = driver.findElement(requiredIncome).getAttribute("textContent");
            driver.findElement(youngFamilyDiscount).click();
            waitingChenge(oldValue,requiredIncome,"textContent");
        }
        driver.switchTo().defaultContent();

    }


    public void waitingChenge(String oldValue,By what, String atribut){
        Function<? super WebDriver, Object> valueChanged = new ExpectedCondition<Object>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return !webDriver.findElement(what).getAttribute(atribut).equals(oldValue);
            }
        };
        //действие для изменения значения
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(valueChanged);
    }

    public void check(String sum, String month, String min, String pc){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//h2[contains(text(),'Рассчитайте ипотеку')]")) );
        driver.switchTo().frame("iFrameResizer0");
        Assert.assertEquals("Сумма кредита", driver.findElement(amountOfCredit).getAttribute("textContent"), sum);
        Assert.assertEquals("Ежемесячный платеж", driver.findElement(monthlyPayment).getAttribute("textContent"), month);
        Assert.assertEquals("Минимальная ЗП", driver.findElement(requiredIncome).getAttribute("textContent"), min);
        Assert.assertEquals("Процентная ставка", driver.findElement(rate).getAttribute("textContent"), pc);
    }
}
