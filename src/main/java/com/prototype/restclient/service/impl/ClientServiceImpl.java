package com.prototype.restclient.service.impl;

import com.prototype.restclient.model.Request;
import com.prototype.restclient.model.Response;
import com.prototype.restclient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Response process(final Request request) {
        String url = request.getUrl();
        String body = restTemplate.getForObject(url, String.class);
        Response response = new Response();
        response.setBody(body);
        return response;
    }
}
