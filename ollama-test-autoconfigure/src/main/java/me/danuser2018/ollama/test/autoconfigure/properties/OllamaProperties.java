package me.danuser2018.ollama.test.autoconfigure.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "ollama.test")
public class OllamaProperties {
    private boolean enabled = false;
    private String model = "tinyllama";
}
