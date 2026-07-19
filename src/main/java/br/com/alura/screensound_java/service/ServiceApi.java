
package br.com.alura.screensound_java.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceApi {

    private final RestTemplate restTemplate = new RestTemplate();

    public String consultarModelo(String input) {
        String apiUrl = "https://api-inference.huggingface.co/models/google/gemma-2b";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + System.getenv("HUGGING_FACE_TOKEN"));
        headers.set("Content-Type", "application/json");

        String body = "{ \"inputs\": \"" + input + "\" }";

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response =
                restTemplate.postForEntity(apiUrl, request, String.class);

        return response.getBody();
    }
}
