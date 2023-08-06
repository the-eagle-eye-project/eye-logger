package com.theeagleeyeproject.eyelogger.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

    private final ObjectMapper objectMapper;

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder()
                .codecs(conf -> {
                            conf.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(objectMapper, MediaType.APPLICATION_JSON));
                            conf.defaultCodecs().jackson2SmileEncoder(new Jackson2JsonEncoder(objectMapper, MediaType.APPLICATION_JSON));
                        }
                );
    }
}
