package ru.rozvezev.equationrestservice.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import ru.rozvezev.equationrestservice.client.ServiceClient;

@Configuration
public class CalculateConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("ru.rozvezev.equationrestservice.generatedclasses");
        return marshaller;
    }

    @Bean
    public ServiceClient serviceClient(Jaxb2Marshaller marshaller) {
        ServiceClient client = new ServiceClient();
        client.setDefaultUri("http://localhost:8080/calculate");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
