package com.creditbureau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin(origins = "http://localhost:8080") // <-- Place it right above @RestController
@SpringBootApplication
public class CreditBureauProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditBureauProjectApplication.class, args);
	}

}
