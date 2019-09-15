package steps;



import io.qameta.allure.Step;
import pages.MainPage;


public class MainSteps {
    MainPage mainPage = new MainPage();

    @Step("Навести на ипотека, дождаться появления выпадающего меню, нажать ипотека на готовое жилье")
    public void search(){
        mainPage.search();
    }
}
