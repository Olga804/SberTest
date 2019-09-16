package steps;



import io.qameta.allure.Step;
import pages.CreditPage;

public class CreditSteps {
//    CreditPage creditPage = new CreditPage();
//    ScenarioSteps scenarioSteps = new ScenarioSteps();

    @Step("Заполнить формы; Стоимость недвижимости = {fullPrice}, Первоначальный взнос = {pay}, Срок кредита = {period}")
    public void writeForm(String fullPrice, String  pay, String period){
        new CreditPage().writeForm(fullPrice,pay,period);
    }

    @Step("Нажать: нет зарплатной карты сбербанка, дождаться появления есть возможность подтвердить доход, нажать молодая семья")
    public void press(){
        new CreditPage().press();
    }

    @Step("Проверить: поле сумма кредита = {sum}, ежемесячный платеж = {month}, необходимый доход = {min}, процентная ставка = {pc}")
    public void check(String sum, String month, String min, String pc){
        new CreditPage().check(sum, month, min, pc);
    }
}
