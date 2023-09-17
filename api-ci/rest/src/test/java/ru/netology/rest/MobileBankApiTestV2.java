package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class MobileBankApiTestV2 {
    @Test
    void shouldReturnDemoAccounts() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
                // Выполняемые действия
                .when()
                .get("/demo/accounts")
                // Проверки
                .then()
                .statusCode(200)
                // .header("Content-Type", "application/json; charset=UTF-8")
                // специализированные проверки - лучше
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json; charset=UTF-8")
                .body("", hasSize(3))
                .body("[0].id", equalTo(1))
                .body("[0].currency", equalTo("RUB"))
                .body("[0].name", equalTo("Текущий счёт"))
                .body("[1].balance", greaterThan(0));


    }
}
