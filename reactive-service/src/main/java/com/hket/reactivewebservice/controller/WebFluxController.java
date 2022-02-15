package com.hket.reactivewebservice.controller;

import java.time.Duration;

import com.hket.reactivewebservice.functional.Greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/flux")
public class WebFluxController {
    private String url = "http://localhost:8040";

    private final WebClient client = WebClient.create();

    @GetMapping("/r1")
    public Mono<String> getResult() {
       return Mono.defer(() -> Mono.just("Result is ready111!"))
         .delaySubscription(Duration.ofMillis(2000)).log();
    }
    @GetMapping("/r2")
    public Mono<String> getResult2() {
       return Mono.just("Result is ready222!").log();
    }

    @GetMapping(value = "/hello/{times}")
    public Mono<String> hello(@PathVariable int times) {
        return Mono.delay(Duration.ofMillis(times)).thenReturn("Hello").log();
    }

    @GetMapping(value = "/r/{times}")
    public Mono<String> reactor(@PathVariable int times) {
        return Mono.just(times)
                .flatMap(t -> client.get()
                        .uri(url + "/flux/hello/" + times).retrieve().bodyToMono(String.class)).log();
    }

    @GetMapping
    public Flux<Integer> flux() {
        return Flux.just(1,2,3,4).delayElements(Duration.ofSeconds(1)).log();
    }
    
    @GetMapping(value = "/h")
    public Mono<Greeting> hello() {
        return Mono.just(new Greeting("Hello, Spring!")).log();
    }
}
