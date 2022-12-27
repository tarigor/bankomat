# Банкомат

#### Описание:

Необходимо написать консольное приложение, которое будет симулировать работу банкомата.

Пользователь должен ввести валидный номер карты, соответствующий шаблону, и правильный ПИН-код, чтобы получить доступ к счету. После успешной авторизации пользователь может:
проверить баланс карты;

снять средства со счета, не больше чем сумма на текущем счете или не превышая лимит средств в банкомате;

пополнить баланс (сумма пополнения не должна превышать 1 000 000).

#### Требования:

хранение данных должно быть в текстовом файле с разделителем пробел (« »);

номер карты должен быть вида : «ХХХХ-ХХХХ-ХХХХ-ХХХХ»;

программа должна сохранять свое состояние после завершения (файл с данными должен обновляться);

все сообщения об успешных действиях и ошибках должны выводиться на консоль.

#### Требования к коду:

приложение должно быть реализовано на языке Java версии 7+;

код должен соответствовать принципам сильного сцепления и 4 принципам ООП;

количество классов в программе - не меньше 4;

код должен соответствовать Java code style (именование переменных, структура класса и др.);

приложение должно содержать качественную обработку ошибок;

для работы со списками данных необходимо использовать коллекции.

#### Дополнительно* (задание повышенной сложности):

реализовать консольное меню для приложения (ввод с консоли);

создать .bat файл для запуска приложения;

ПИН-код может быть неправильно введен 3 раза, после этого карта должна быть заблокирована;

блокировка карты снимается автоматически по истечении суток.

###№ How to run from bash console

to execute app.sh file located in root of the project

./ app.sh

#### Technologies:

- Java 11;
- Log4j
