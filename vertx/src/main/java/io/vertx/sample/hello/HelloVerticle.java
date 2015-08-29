package io.vertx.sample.hello;

import io.vertx.core.AbstractVerticle;

public class HelloVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        vertx.createHttpServer().requestHandler(request -> {
            request.response().end("<html><body>Hello from Docker host" + request.localAddress().host() + "</body></html>");
        }).listen(80);
    }
}

