package com.aqualen.camelkafkajpa;

import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaToFileRoutBuilder extends RouteBuilder {

    private final SupermanProcessor supermanProcessor;

    @Override
    public void configure() {
        from("kafka:main?brokers=localhost:9092" +
                "&autoOffsetReset=earliest")
                .routeId("kafka-to-postgres")
                .tracing()
                .process(supermanProcessor)
                .to("jpa:com.aqualen.camelkafkajdbc.Superhero")
                .log("Inserted new superhero ${body}");
    }
}
