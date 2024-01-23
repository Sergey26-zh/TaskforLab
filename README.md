## Использованные технологии
- [Spring Boot](https://spring.io/projects/spring-boot) - Фреймворк для создания веб-приложений на языке Java.
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - Проект для упрощения работы с базами данных в приложениях Spring.
- [Spring Web](https://spring.io/guides/gs/spring-boot/) - Модуль для создания веб-приложений с использованием Spring.
- [Springdoc OpenAPI](https://springdoc.org/) - Библиотека для автоматической генерации OpenAPI документации для API.
- [JUnit 5](https://junit.org/junit5/) - Фреймворк для юнит-тестирования.
- [Mockito](https://site.mockito.org/) - Библиотека для создания mock-объектов в тестах.
- [Lombok](https://projectlombok.org/) - Библиотека для упрощения написания кода в Java с использованием аннотаций.
- [H2 Database](https://www.h2database.com/html/main.html) - Встраиваемая база данных
- [MapStruct](https://mapstruct.org/) - Фреймворк для генерации кода для преобразования объектов.

## Запуск Проекта
 1. Сначала нужно склонировать этот репозиторий

```shell
git clone https://github.com/Sergey26-zh/TaskforLab.git
```

## Как запустить локально?

Собрать gradle проект

```shell
# Нужно запустить из корневой директории, где лежит build.gradle.kts
gradle build
```

# Код

RESTful приложения для объединения пересекающихся интерваллов массива с двумя endpoint'ами

* Обычная трёхслойная
  архитектура – [Controller](src/main/java/com/example/taskforlab/controller), [Service](src/main/java/com/example/taskforlab/service), [Repository](src/main/java/com/example/taskforlab/repository)
* Слой Repository реализован и на jdbcTemplate, и на JPA (Hibernate)
* Написан [GlobalExceptionHandler](src/main/java/faang/school/servicetemplate/controller/GlobalExceptionHandler.java)

# Тесты

Написаны только для двух REST endpoint'ов
* MockMvc
* AssertJ
* JUnit5

## API Documentation

Документация к API доступна с использованием Swagger. Вы можете использовать Swagger UI для визуализации и тестирования API.

- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- Swagger JSON: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

Для просмотра API Documentation запустите ваше приложение и перейдите по указанным выше ссылкам.
    
