package com.aqualen.camelkafkajdbc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class SupermanProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody().toString();
        ObjectMapper objectMapper = new ObjectMapper();
        Superhero superhero = objectMapper.readValue(body, Superhero.class);
        exchange.getIn().setBody(superhero);
    }

}
