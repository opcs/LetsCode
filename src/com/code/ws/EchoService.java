
package com.code.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * The implementation class for the same is:
 * This is the class that we have exposed as a webservice. The WebService annotation indicates the interface is to be
 * used as the SEI (Endpoint for the service) and also specifies the target namespace for all xml entities associated
 * with this webservice.
 */
@WebService(endpointInterface = "com.gtn.ws.IEchoService", targetNamespace = "http://www.sample.com/service")
public class EchoService implements IEchoService {

    @WebMethod
    @Override
    public String echo(String message) {
        System.out.println("received input " + message);
        return message;
    }
}
