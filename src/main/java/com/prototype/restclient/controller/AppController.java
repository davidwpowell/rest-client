package com.prototype.restclient.controller;

import com.prototype.restclient.constants.AppConstants;
import com.prototype.restclient.model.Request;
import com.prototype.restclient.model.Response;
import com.prototype.restclient.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    private final ClientService clientService;

    @Autowired
    public AppController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public String formDisplay(Model model) {
        model.addAttribute("restMethods", AppConstants.httpMethodMap());
        model.addAttribute("request", new Request());
        return "input";
    }

    @PostMapping("/")
    public String formSubmit(Model model, @ModelAttribute Request request) {
        Response response = clientService.process(request);
        model.addAttribute("response", response);
        return "output";
    }
}
