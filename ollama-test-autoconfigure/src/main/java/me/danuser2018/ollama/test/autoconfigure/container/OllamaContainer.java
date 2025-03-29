package me.danuser2018.ollama.test.autoconfigure.container;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

public class OllamaContainer extends GenericContainer<OllamaContainer> {

    private static final String OLLAMA_IMAGE = "ollama/ollama";
    private static final int OLLAMA_PORT = 11434;

    public OllamaContainer() {
        super(DockerImageName.parse(OLLAMA_IMAGE));
        this.withExposedPorts(OLLAMA_PORT).waitingFor(Wait.forHttp("/api/tags").forPort(OLLAMA_PORT));
    }

    public String getBaseUrl() {
        return "http://" + getHost() + ":" + getMappedPort(OLLAMA_PORT);
    }
}
