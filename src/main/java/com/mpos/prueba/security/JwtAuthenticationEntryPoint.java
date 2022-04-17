package com.mpos.prueba.security;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -8970718410437077606L;
    
    private static final String BAD_CREDENTIALS = "Bad credentials";
    private static final String UNAUTHORIZED = "Full authentication is required to access this resource";

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        // This is invoked when user tries to access a secured REST resource without supplying any credentials
        // We should just send a 401 Unauthorized response because there is no 'login page' to redirect to
    	
    	if(BAD_CREDENTIALS.equals(authException.getMessage())) {
    		response.sendError(HttpServletResponse.SC_BAD_REQUEST, authException.getMessage());
    	} else if(UNAUTHORIZED.equals(authException.getMessage())) {
    		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    	}
        
    }
}