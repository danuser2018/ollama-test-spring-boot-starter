package me.danuser2018.ollama.test.autoconfigure.container;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Testcontainers
public class OllamaContainerSmokeTest {

    @Container
    private static final OllamaContainer ollamaContainer = new OllamaContainer();

    @Before
    public void beforeTest() {
        ollamaContainer.start();
    }

    @Test
    public void testOllamaConnection() throws Exception {
        String response = HttpClient.newHttpClient().send(
                HttpRequest.newBuilder()
                        .uri(URI.create(ollamaContainer.getBaseUrl() + "/api/tags"))
                        .GET()
                        .build(),
                HttpResponse.BodyHandlers.ofString()
        ).body();

        assertTrue(response.contains("models"));
    }
}
