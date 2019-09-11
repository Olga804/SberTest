import org.junit.Assert;
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
import ru.yandex.qatools.allure.annotations.Step;

import java.sql.Driver;
import java.util.function.Function;

public class CreditPage  {

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



   WebDriver driver;

    public CreditPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Заполнеие формы: Полная цена - , Первоначальный взнос - , Срок кредита - ")
    public void writeForm(String fullPrice, String  pay, String period) {

        driver.switchTo().frame("iFrameResizer0");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(estateCost));
        driver.findElement(estateCost).clear();
        driver.findElement(estateCost).sendKeys(fullPrice);
        waitingChenge(initialFee);
        driver.findElement(initialFee).clear();
        driver.findElement(initialFee).sendKeys(pay);
        driver.findElement(creditTerm).clear();
        driver.findElement(creditTerm).sendKeys(period);

    }
    @Step("Выбрать: Нет зарплатной карты; есть возможность подтвердить доход; молодая семья")
        public void press(){

    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(creditTerm) );

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(paidToCard)).build().perform();

        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(paidToCard)));
        if(driver.findElement(By.xpath("//input[@data-test-id='paidToCard']")).isSelected()){
           driver.findElement(paidToCard).click();

        }

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(canConfirmIncome)));
       if(!driver.findElement(By.xpath("//input[@data-test-id='canConfirmIncome']")).isSelected()){
            driver.findElement(canConfirmIncome).click();
        }

        if(!driver.findElement(By.xpath("//input[@data-test-id='youngFamilyDiscount']")).isSelected()){
            driver.findElement(youngFamilyDiscount).click();
        }
        driver.switchTo().defaultContent();

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
    @Step("Проверить: Кредит = , Ежемесячный платёж = , Минимальная зп = , Процентная ставка =  ")
    public void check(String sum, String mounth, String min, String pc){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//h2[contains(text(),'Рассчитайте ипотеку')]")) );
        driver.switchTo().frame("iFrameResizer0");
        Assert.assertEquals("Сумма кредита", driver.findElement(amountOfCredit).getAttribute("textContent"), sum);
        Assert.assertEquals("Ежемесячный платеж", driver.findElement(monthlyPayment).getAttribute("textContent"), mounth);
        Assert.assertEquals("Минимальная ЗП", driver.findElement(requiredIncome).getAttribute("textContent"), min);
        Assert.assertEquals("Процентная ставка", driver.findElement(rate).getAttribute("textContent"), pc);
    }

}
