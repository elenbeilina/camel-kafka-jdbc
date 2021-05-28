package com.aqualen.camelkafkajdbc;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KafkaToFileRoutBuilder extends RouteBuilder {

    @Value("${data.folder.path}")
    private String dataFolderPath;

    @Override
    public void configure() {
        from("kafka:main?brokers=localhost:9092")
        .routeId("kafka-to-folder2")
                .tracing()
                .log("${body}")
                .transform(body().append("\n"))
                .to(dataFolderPath + "/?fileName=test-data-out.txt&fileExist=Append");
    }
}
