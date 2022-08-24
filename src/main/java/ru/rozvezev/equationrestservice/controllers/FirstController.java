package ru.rozvezev.equationrestservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.ws.soap.client.SoapFaultClientException;
import ru.rozvezev.equationrestservice.client.ServiceClient;
import ru.rozvezev.equationrestservice.generatedclasses.CalculateResponse;
import ru.rozvezev.equationrestservice.generatedclasses.Solution;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("api")
public class FirstController {

    private final ServiceClient serviceClient;

    @Autowired
    public FirstController(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }


    @GetMapping("/calc")
    public ResponseEntity<Solution> getSolution(@RequestParam double a, @RequestParam double b, @RequestParam double c){
        CalculateResponse response = serviceClient.getSolution(a, b, c);
        return new ResponseEntity<>(response.getSolution(), HttpStatus.OK);
    }

    @ExceptionHandler({SoapFaultClientException.class, MissingServletRequestParameterException.class})
    protected ResponseEntity<Map<String, String>> exceptionHandler(Exception e){
        Map<String, String> errorResponse = new LinkedHashMap<>();
        errorResponse.put("error details", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
