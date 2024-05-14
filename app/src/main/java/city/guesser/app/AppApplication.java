package city.guesser.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//////////// ROUTES IN MAINVIEW

///////////////////// THIS IS THE MAIN

///// GO TO http://localhost:8080/main

@SpringBootApplication
// @ComponentScan("app") // scope where files are looked for
@EnableAutoConfiguration
public class AppApplication {

	public static void main(String[] args) {

		SpringApplication.run(AppApplication.class, args);

	}

}
