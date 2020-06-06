package ar.edu.utn.frsf.dswba.restservices.foo.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s! Nice to meet you!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        // RestTemplate rest = new RestTemplate();
        // Usuario usr = rest.getForObject("https://evening-sea-87432.herokuapp.com", Usuario.class);

        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
