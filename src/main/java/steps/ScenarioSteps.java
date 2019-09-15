package steps;

import io.cucumber.java.ru.Когда;

import io.cucumber.java.ru.Тогда;

import pages.CreditPage;
import pages.MainPage;

public class ScenarioSteps {

    MainPage mainPage = new MainPage();
    @Когда("^Навести на ипотека, дождаться появления выпадающего меню, нажать ипотека на готовое жилье")
    public void search(){
        mainPage.search();
    }

    CreditPage creditPage = new CreditPage();

    @Когда("^Заполнить формы; Стоимость недвижимости = \"(.+)\"$, Первоначальный взнос = \"(.+)\"$, Срок кредита = \"(.+)\"$")
    public void writeForm(String fullPrice, String  pay, String period){
        creditPage.writeForm(fullPrice,pay,period);
    }

    @Когда("^Нажать: нет зарплатной карты сбербанка, дождаться появления есть возможность подтвердить доход, нажать молодая семья")
    public void press(){
        creditPage.press();
    }

    @Тогда("^Проверить: поле сумма кредита = \"(.+)\"$, ежемесячный платеж = \"(.+)\"$, необходимый доход = \"(.+)\"$, процентная ставка = \"(.+)\"$")
    public void chek(String sum, String month, String min, String pc){
        creditPage.check(sum, month, min, pc);
    }
}
