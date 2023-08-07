package com.theeagleeyeproject.eyelogger.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Log4j2
@RequiredArgsConstructor
public class EyeRegisterClient {

    private final WebClient.Builder webClientBuilder;

    @Value("${eye.registry.host}")
    private String eyeRegistryHost;

    public EyeMetaClientResponse getMetadata(String integrationId) {

        String apiUrl = UriComponentsBuilder.fromHttpUrl(eyeRegistryHost)
                .queryParam("integration_id", integrationId)
                .toUriString();

        log.info("URL Used to connect to Eye Registry: {}", apiUrl);

        return webClientBuilder.build()
                .get()
                .uri(apiUrl)
                .accept(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .retrieve()
                .bodyToMono(EyeMetaClientResponse.class)
                .block();
    }
}
