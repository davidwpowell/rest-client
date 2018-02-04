package com.prototype.restclient.service;

import com.prototype.restclient.model.Request;
import com.prototype.restclient.model.Response;

public interface ClientService {

    /**
     * Makes a rest call.
     *
     * @param request a request containing a URL
     * @return a response
     */
    Response process(Request request);
}
