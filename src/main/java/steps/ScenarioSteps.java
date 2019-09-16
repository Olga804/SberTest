package steps;

import io.cucumber.java.ru.Когда;

import io.cucumber.java.ru.Тогда;


public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    @Когда("^Навести на ипотека, дождаться появления выпадающего меню, нажать ипотека на готовое жилье$")
    public void search(){
        mainSteps.search();
    }

    CreditSteps creditSteps = new CreditSteps();

    @Когда("^Заполнить формы; Стоимость недвижимости = \"(.+)\", Первоначальный взнос = \"(.+)\", Срок кредита = \"(.+)\"$")
    public void writeForm(String fullPrice, String  pay, String period){
        creditSteps.writeForm(fullPrice,pay,period);
    }

    @Когда("^Нажать: нет зарплатной карты сбербанка, дождаться появления есть возможность подтвердить доход, нажать молодая семья$")
    public void press(){
        creditSteps.press();
    }

    @Тогда("^Проверить: поле сумма кредита = \"(.+)\", ежемесячный платеж = \"(.+)\", необходимый доход = \"(.+)\", процентная ставка = \"(.+)\"$")
    public void check(String sum, String month, String min, String pc){
        creditSteps.check(sum, month, min, pc);
    }
}
