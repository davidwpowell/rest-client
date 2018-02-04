package com.prototype.restclient.controller

import com.prototype.restclient.model.Request
import com.prototype.restclient.model.Response
import com.prototype.restclient.service.ClientService
import org.springframework.ui.ExtendedModelMap
import org.springframework.ui.Model
import spock.lang.Specification

class AppControllerSpec extends Specification {

    ClientService clientService = Mock(ClientService)
    AppController appController = new AppController(
            clientService: clientService
    )

    def "Test formDisplay"() {
        given:
        Model model = new ExtendedModelMap()

        when:
        String ret = appController.formDisplay(model)

        then:
        0 * _

        and:
        ret == "input"
        model.containsAttribute("request")
    }

    def "Test formSubmit"() {
        given:
        Model model = new ExtendedModelMap()
        Request request = new Request()
        Response response = new Response()

        when:
        String ret = appController.formSubmit(model, request)

        then:
        1 * clientService.process(request) >> response
        0 * _

        and:
        ret == "output"
        model.containsAttribute("response")
    }
}
