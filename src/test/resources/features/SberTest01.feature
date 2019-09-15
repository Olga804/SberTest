#language: ru
Функционал: Cucumber

  @all
  Сценарий: Выбор параметров и проверка рассчитанных значений
    Когда Навести на ипотека, дождаться появления выпадающего меню, нажать ипотека на готовое жилье
    И Заполнить формы; Стоимость недвижимости = "5180000", Первоначальный взнос = "3058000", Срок кредита = "30"
    И Нажать: нет зарплатной карты сбербанка, дождаться появления есть возможность подтвердить доход, нажать молодая семья
    Тогда Проверить: поле сумма кредита = "2 122 000 \u20BD", ежемесячный платеж = "18 466 \u20BD", необходимый доход = "30 776 \u20BD", процентная ставка = "11 %"