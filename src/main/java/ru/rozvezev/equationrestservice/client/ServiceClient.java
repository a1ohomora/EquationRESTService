package ru.rozvezev.equationrestservice.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import ru.rozvezev.equationrestservice.generatedclasses.CalculateRequest;
import ru.rozvezev.equationrestservice.generatedclasses.CalculateResponse;

public class ServiceClient extends WebServiceGatewaySupport {

    public CalculateResponse getSolution(double a, double b, double c) {
        CalculateRequest request = new CalculateRequest();
        request.setA(a);
        request.setB(b);
        request.setC(c);

        CalculateResponse response = (CalculateResponse) this.getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/calculate", request,
                        new SoapActionCallback("http://rozvezev.ru/ns/calculateRequest"));

        return response;
    }
}
