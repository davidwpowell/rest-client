package com.prototype.restclient.service.impl;

import com.prototype.restclient.model.Request;
import com.prototype.restclient.model.Response;
import com.prototype.restclient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientServiceImpl implements ClientService {

    private final RestTemplate restTemplate;

    @Autowired
    public ClientServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Response process(final Request request) {
        String url = request.getUrl();
        HttpMethod httpMethod = request.getHttpMethod();
        HttpEntity<String> entity = initEntity(request);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, httpMethod, entity, String.class);
        String responseBody = responseEntity.getBody();
        Response response = new Response();
        HttpHeaders httpHeaders = responseEntity.getHeaders();
        if (httpHeaders != null) {
            response.setResponseHeader(httpHeaders.toString());
        }
        response.setResponseBody(responseBody);
        return response;
    }

    private HttpEntity<String> initEntity(final Request request) {
        String body = request.getRequestBody();
        HttpHeaders httpHeaders = initHeaders();
        return new HttpEntity<>(body, httpHeaders);
    }

    private HttpHeaders initHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
