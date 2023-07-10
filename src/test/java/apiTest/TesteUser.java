// Nome do Pacote
package apiTest;

// Bibliotecas

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

// Classe
public class TesteUser {
    // Atributos
    static String ct = "application/json"; // Content type
    static String uriUser = "https://petstore.swagger.io/v2/user/";

    // Funções e Métodos
    // Funções de Apoio
    public static String lerArquivoJson(String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));
    }

    // Funções de Testes

    // Post
    @Test
    public void testarIncluirUser() throws IOException {
        // Carregar os dados do nosso Json
        String jsonBody = lerArquivoJson("src/test/resources/json/user1.json");
        String userId ="1374145344";

        // Realizar o teste
        given()                                               // Dado que
                .contentType(ct)                              // O tipo do conteúdo
                .log().all()                                  // Mostre tudo na ida
                .body(jsonBody)                               // Corpo da requisição
        .when()                                               // Quando
                .post(uriUser)                                // Endpoint / Onde
        .then()                                               // Então
                .log().all()                                  // Mostre tudo na volta
                .statusCode(200)                              // Comunicação ida e volta funcionou
                .body("code", is(200))                        // Tag code é 200
                .body("type", is("unknown"))                  // Tag type é unknown
                .body("message", is(userId))                  // Message é o userId 1374145344
        ;
    }

    // Get
    @Test
    public void testarConsultarUser(){
        String username = "brunobozo";

        // Resultados Esperados
        int userId = 1374145344;
        String email = "bruno@teste.com";
        String password = "123456";
        String phone = "11999998888";

        given()
                .contentType(ct)
                .log().all()
        .when()
                .get(uriUser + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(userId))
                .body("email", is(email))
                .body("password", is(password))
                .body("phone", is(phone))
        ;

    }

    // Put
    @Test
    public void testarAtualizarUser() throws IOException {
        String jsonBody = lerArquivoJson("src/test/resources/json/user2.json");
        String userId = "1374145344";
        String username = "brunobozo";

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)
        .when()
                .put(uriUser + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(userId))
        ;

    }

    // Delete
    @Test
    public void testarDeletarUser() throws IOException {
        String username = "brunobozo";

        given()
                .contentType(ct)
                .log().all()
        .when()
                .delete(uriUser + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(username))
        ;

    }

}