package steps;



import io.qameta.allure.Step;
import pages.CreditPage;

public class CreditSteps {
    CreditPage creditPage = new CreditPage();

    @Step("Заполнить формы; Стоимость недвижимости = {fullPrice}, Первоначальный взнос = {pay}, Срок кредита = {period}")
    public void writeForm(String fullPrice, String  pay, String period){
        creditPage.writeForm(fullPrice,pay,period);
    }

    @Step("Нажать: нет зарплатной карты сбербанка, дождаться появления есть возможность подтвердить доход, нажать молодая семья")
    public void press(){
        creditPage.press();
    }

    @Step("Проверить: поле сумма кредита = {sum}, ежемесячный платеж = {month}, необходимый доход = {min}, процентная ставка = {pc}")
    public void chek(String sum, String month, String min, String pc){
        creditPage.check(sum, month, min, pc);
    }
}
