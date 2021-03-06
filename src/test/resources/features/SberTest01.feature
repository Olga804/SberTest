#language: ru
Функционал: Cucumber

  @all
  Сценарий: Выбор параметров и проверка рассчитанных значений
    * Навести на ипотека, дождаться появления выпадающего меню, нажать ипотека на готовое жилье
    * Заполнить формы; Стоимость недвижимости = "5180000", Первоначальный взнос = "3058000", Срок кредита = "30"
    * Нажать: нет зарплатной карты сбербанка, дождаться появления есть возможность подтвердить доход, нажать молодая семья
    * Проверить: поле сумма кредита = "2 122 000 ₽", ежемесячный платеж = "18 937 ₽", необходимый доход = "31 561 ₽", процентная ставка = "11 %"