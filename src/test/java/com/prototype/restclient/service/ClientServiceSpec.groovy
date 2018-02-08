package com.prototype.restclient.service

import com.prototype.restclient.model.Request
import com.prototype.restclient.model.Response
import com.prototype.restclient.service.impl.ClientServiceImpl
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class ClientServiceSpec extends Specification {

    RestTemplate restTemplate = Mock(RestTemplate)
    ClientService clientService = new ClientServiceImpl(
            restTemplate
    )

    def "Test process"() {
        given:
        String url = "test_url"
        Request request = new Request(
                url: "test_url",
                httpMethod: HttpMethod.GET
        )
        String body = "test_body"
        ResponseEntity<String> responseEntity = new ResponseEntity(body, HttpStatus.OK);

        when:
        Response response = clientService.process(request)

        then:
        1 * restTemplate.exchange(url, HttpMethod.GET, _ as HttpEntity, String.class) >> responseEntity
        0 * _

        and:
        response.body == body
    }
}
