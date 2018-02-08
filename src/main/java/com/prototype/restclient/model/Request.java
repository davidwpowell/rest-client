package com.prototype.restclient.model;

import org.springframework.http.HttpMethod;

public class Request {

    private String url;
    private HttpMethod httpMethod;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

}
