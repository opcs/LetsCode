/**
 * Copyright (c) 2017 GT Nexus. All Rights Reserved.
 */
package com.code.ws;

import javax.xml.ws.Endpoint;

/**
 * Java SE includes a small server implementation that can be used to publish the webservice
 * use http://localhost:9090/service/echo to see wsdl xml
 */
public class PublishWebService {

    public static void main(String[] args) {
        Endpoint endpoint = Endpoint.publish("http://localhost:9090/service/echo", new EchoService());
        System.out.println("Webservice published via endpoint " + endpoint);
    }

}
