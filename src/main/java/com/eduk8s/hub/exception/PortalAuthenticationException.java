package com.eduk8s.hub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class PortalAuthenticationException extends RuntimeException {

    private static final long serialVersionUID = 8698116080440299474L;

    public PortalAuthenticationException(){
        super();
    }

    public PortalAuthenticationException(Throwable t){
        super(t);
    }

    public PortalAuthenticationException(String s){
        super(s);
    }

    public PortalAuthenticationException(String s, Throwable t){
        super(s,t);
    }

}