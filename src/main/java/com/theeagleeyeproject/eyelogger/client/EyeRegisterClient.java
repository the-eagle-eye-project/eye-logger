package com.theeagleeyeproject.eyelogger.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class EyeRegisterClient {

    private final WebClient.Builder webClientBuilder;

    public EyeMetaClientResponse getMetadata(String integrationId) {
        String baseUrl = "http://localhost:8081/eye/meta-register";

        String apiUrl = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("integration_id", integrationId)
                .toUriString();

        // TODO: Add an object mapper to the client to accept the fields with snake case.

        return webClientBuilder.build()
                .get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(EyeMetaClientResponse.class)
                .block();
    }
}
