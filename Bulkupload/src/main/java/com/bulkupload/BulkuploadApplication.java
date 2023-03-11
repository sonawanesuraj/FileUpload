package com.bulkupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class BulkuploadApplication {

	@GetMapping("/message")
	public String getMessage() {
		return "Docker Run Successfully.......";
	}

	public static void main(String[] args) {
		SpringApplication.run(BulkuploadApplication.class, args);
	}

}
