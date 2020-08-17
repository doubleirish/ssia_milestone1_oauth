package com.manning.ssia.oauth.web;


import com.manning.ssia.oauth.jpa.Client;
import com.manning.ssia.oauth.jpa.ClientRepository;
import com.manning.ssia.oauth.jpa.Grant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j

@RequestMapping(path = "/authorization", produces = "application/json")
@CrossOrigin(origins = "*")
public class AuthorizationController {



    @GetMapping( produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<Map<String, Object>> displayRequestHeaders(HttpServletRequest request)
    {
        Map<String, Object> returnValue = new HashMap<>();

        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements())
        {
            String headerName = headerNames.nextElement();
            returnValue.put(headerName, request.getHeader(headerName));
        }

        Enumeration<String> paramNames = request.getParameterNames();
        while(paramNames.hasMoreElements())
        {
            String param = paramNames.nextElement();
            returnValue.put("param-"+param, request.getParameterValues(param));
        }

        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }



}

