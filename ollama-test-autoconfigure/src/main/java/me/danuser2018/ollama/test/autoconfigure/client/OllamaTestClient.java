package me.danuser2018.ollama.test.autoconfigure.client;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import me.danuser2018.ollama.test.autoconfigure.container.OllamaContainer;

@RequiredArgsConstructor
public class OllamaTestClient {
    @NonNull
    private final OllamaContainer ollamaContainer;

    public String generateTestCases(@NonNull final String apiSpec) {

        String promp = """
               Genera 2 tests cases para esta API en formato JSON:
               API Spec: %s
               Ejemplo de formato de respuesta JSON :
               {
                   "tests": [
                       {
                           "name": "Test 1 - Crear usuario",
                           "method": "POST",
                           "path": "/api/users",
                           "body": { "name" : "Pepe", "email": "test@example.com" },
                           "expectedResponseStatus: 201
                       }
                   ]
               }
               """.formatted(apiSpec);



    }

}
