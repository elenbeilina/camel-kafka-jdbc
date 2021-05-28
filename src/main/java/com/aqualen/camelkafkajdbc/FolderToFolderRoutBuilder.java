package com.aqualen.camelkafkajdbc;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FolderToFolderRoutBuilder extends RouteBuilder {

    @Value("${folder1.path}")
    private String folder1Path;
    @Value("${folder2.path}")
    private String folder2Path;

    @Override
    public void configure() {
        from(folder1Path+ "?noop=true")
        .routeId("folders-1-to-2")
                .tracing()
                .log("${body}")
                .to(folder2Path);
    }
}
