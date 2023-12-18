package br.edu.infnet.BookstoreApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.transaction.Transactional;

@SpringBootApplication
@EnableFeignClients
public class BookstoreAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreAppApplication.class, args);
	}

}
