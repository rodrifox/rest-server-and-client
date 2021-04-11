package ar.edu.utn.frsf.dswba.restservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class RestservicesApplication {

    private static final Logger log = LoggerFactory.getLogger(RestservicesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestservicesApplication.class, args);
	}

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception
    {
        return args -> {
            Package packages = restTemplate.getForObject(
                    "http://enigma.ml.com/inventory/train", Package.class);
            log.info(packages.toString());
        };
    }
}
