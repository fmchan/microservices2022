package com.hket.reactivewebservice.filter;

import java.time.Duration;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;

import reactor.core.publisher.Mono;

@Component
public class WebFluxFilter implements org.springframework.web.server.WebFilter {

    @Override
    public Mono filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        System.out.println("delay");
        return Mono
          .delay(Duration.ofMillis(200))
          .then(
            webFilterChain.filter(serverWebExchange)
          );
    }
}
