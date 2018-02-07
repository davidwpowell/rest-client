package com.prototype.restclient.service

import com.prototype.restclient.model.Request
import com.prototype.restclient.model.Response
import com.prototype.restclient.service.impl.ClientServiceImpl
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
                url: "test_url"
        )
        String body = "test_body"

        when:
        Response response = clientService.process(request)

        then:
        1 * restTemplate.getForObject(url, String.class) >> body
        0 * _

        and:
        response.body == body
    }
}
