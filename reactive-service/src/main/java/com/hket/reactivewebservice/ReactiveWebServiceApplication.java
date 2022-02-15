package com.hket.reactivewebservice;


import com.hket.reactivewebservice.functional.GreetingClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info =
@Info(title = "Reactive API", version = "1.0", description = "Documentation Reactive API v1.0")
)
public class ReactiveWebServiceApplication {
    public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(ReactiveWebServiceApplication.class, args);
		//GreetingClient greetingClient = context.getBean(GreetingClient.class);
		// We need to block for the content here or the JVM might exit before the message is logged
		//System.out.println(">> message = " + greetingClient.getMessage().block());
    }

}
