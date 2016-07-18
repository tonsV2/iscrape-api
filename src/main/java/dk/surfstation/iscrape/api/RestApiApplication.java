package dk.surfstation.iscrape.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;


@SpringBootApplication(scanBasePackages = "dk.surfstation.iscrape")
@EntityScan(basePackages = "dk.surfstation.iscrape.business.domain")
public class RestApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}
}
