package com.code.ws;

import javax.jws.WebService;

@WebService()
public interface IEchoService {

    /**
     * Method will echo back the received input
     * 
     * @param message
     * @return {@link String}
     */
    public String echo(String message);
}
