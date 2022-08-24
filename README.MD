1. Разархивировать архив в папку с IDE / скачать два проекта из репозиториев (EquationSOAPService и EquationRESTService)
2. Открыть проект EquationSOAPService. В нём два модуля: EquationSOAPService и EquationRESTService.
3. Запускаем плагины для генерации классов по XSD-файлу (jaxb2:xjc либо jaxb2:generate с помощью Maven).
4. Запускаем сначала один, затем второй модуль, запуская класс SoapServiceApplication и EquationRestServiceApplication.
   EquationSOAPService запускается на 8080 порту, EquationRESTService на 8081 порту (при необходимости порты можно поменять
   в файле src/main/resources/application.properties с помощью строчки server.port=ХХХХ (ХХХХ - номер порта).
   Теперь по http://localhost:8081/api/calc?a=1&b=2&c=3 получаем ответ в JSON формате на уравнение с помощью SOAP сервиса.
   По http://localhost:8080/calculate/specification.wsdl можно получить WSDL файл.

5. Так же можно запустить jar-файлы в папке с проектом EquationSOAPService\out\artifacts.