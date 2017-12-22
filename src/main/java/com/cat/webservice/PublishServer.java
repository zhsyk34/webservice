package com.cat.webservice;

import javax.xml.ws.Endpoint;

public class PublishServer {

    public static final String host = "http://127.0.0.1:9999/ws/";

    public static void main(String[] args) {
        Endpoint.publish(host + "hello", new HelloWorldImpl());
    }

}