package dk.surfstation.iscrape.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "dk.surfstation.iscrape")
public class RestApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}
}
