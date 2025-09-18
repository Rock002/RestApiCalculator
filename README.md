## RestApiCalculator - Калькулятор

Приложение для простых вычислений с аутентификацией пользователей, созданное на Spring Boot.

### Особенности

- Регистрация и аутентификация пользователей
- базовые вычислительные операции
- Защита данных с помощью Spring Security
- Хранение задач в PostgreSQL

### Технологический стек

- Язык: Java 24
- Фреймворк: Spring Boot 3.5.3
- База данных: PostgreSQL
- Безопасность: Spring Security, BCrypt
- Шаблонизация: Freemarker
- Сборка: Maven
- Другие технологии: Hibernate, JPA

### Функциональные возможности
#### Любой пользователь
- Регистрация пользователя
- Вход в систему
#### Аутентифицированный пользователь
- Выполнение простых вычислительных операций
- Просмотр истории операций
- Просмотр информации о своем профиле

### Запуск проекта

#### Предварительные требования

#### 1. Установите:
    - Java 24
    - PostgreSQL
    - Maven

#### 2. Создайте базу данных в PostgreSQL:
    CREATE DATABASE calculator;

#### 3.	Настройте подключение к БД в application.properties:
    spring.application.name=RestApiCalculator
    spring.datasource.url=jdbc:postgresql://localhost:5432/calculator
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

### Сборка и запуск
#### 1.	Клонируйте репозиторий:
      git clone https://github.com/Rock002/RestApiCalculator.git
      cd RestApiCalculator
#### 2.	Соберите проект с помощью Maven:
      mvn clean package
#### 3.	Запустите приложение:
      java -jar target/RestApiCalculator-0.0.1-SNAPSHOT.jar
#### 4.	Приложение будет доступно по адресу (если он свободен):
      http://localhost:8080

### Использование
#### 1.	Регистрация
      Перейдите по ссылке http://localhost:8080/registration и заполните форму:
      Имя пользователя
      Пароль
#### 2.	Вход в систему
      Используйте свои учетные данные для входа:
      http://localhost:8080/login
#### 3.	Работа приложения
      o	Главная страница: Форма для ввода данных
      o	Результат: Отображение результата после нажатия кнопки
      o	Профиль: Просмотр данных о профиле по кнопке
      o	История операций: Просмотр истории операций пользователя по кнопке
