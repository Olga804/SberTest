package steps;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Attachment;
import javafx.application.Application;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.TestProperties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }


   @Before
    public static void setUp()throws Exception{
        System.setProperty("webdriver.chrome.driver", TestProperties.getInstance().getProperty("path.chrome"));
        driver = new ChromeDriver();
        driver.get(TestProperties.getInstance().getProperty("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public static void tearDown() throws Exception{
        driver.quit();

    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }



}
