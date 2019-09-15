import org.junit.Test;
import pages.CreditPage;
import pages.MainPage;
import steps.BaseSteps;

public class SberTest extends BaseSteps {
    @Test
    public void ipoteka() {
        MainPage mainPage = new MainPage();
        mainPage.search();
        CreditPage creditPage = new CreditPage();
        creditPage.writeForm("5180000", "3058000", "30");
        creditPage.press();
        creditPage.check("2 122 000 \u20BD", "18 466 \u20BD", "30 776 \u20BD", "11 %");
    }
}
