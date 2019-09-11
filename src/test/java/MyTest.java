import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyTest {

static WebDriver driver;
        @Before
    public void setUp(){
            System.setProperty("webdriver.chrome.driver", TestProperties.getInstance().getProperty("path.chrome"));
            driver = new ChromeDriver();
            driver.get(TestProperties.getInstance().getProperty("url"));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            BasePage.driver = driver;
        }

       @Test
    public void ipoteka(){
           MainPage mainPage = new MainPage();
           mainPage.search();
           CreditPage creditPage = new CreditPage(driver);
           creditPage.writeForm("5180000", "3058000","30");
           creditPage.press();
           creditPage.check("2 122 000 \u20BD", "18 466 \u20BD", "30 776 \u20BD", "11 %");




       }

}
