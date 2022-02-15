package com.hket.reactivewebservice.functional;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> mono(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Flux.just("Spring").log(),String.class);

    }

    public Mono<ServerResponse> flux(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Flux.just(1,2,3,4).delayElements(Duration.ofSeconds(1)).log(), Integer.class);
    }
    
    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse
            .ok().contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(new Greeting("Hello, Spring!")));
    }


    
}
