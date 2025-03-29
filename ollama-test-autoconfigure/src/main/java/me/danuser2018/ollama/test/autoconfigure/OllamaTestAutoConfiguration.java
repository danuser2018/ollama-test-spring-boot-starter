package me.danuser2018.ollama.test.autoconfigure;

import me.danuser2018.ollama.test.autoconfigure.container.OllamaContainer;
import me.danuser2018.ollama.test.autoconfigure.properties.OllamaProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(OllamaProperties.class)
@ConditionalOnProperty(name = "ollama.test.enabled", havingValue = "true")
public class OllamaTestAutoConfiguration {
    @Bean
    @SuppressWarnings("resource")
    public OllamaContainer ollamaContainer() {
        return new OllamaContainer().withReuse(true);
    }
}
