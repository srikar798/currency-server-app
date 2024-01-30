package com.career.csp;

import com.career.csp.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CurrencyServerAppApplication implements CommandLineRunner {

	private final CurrencyService currencyService;
	public static void main(String[] args) {
		SpringApplication.run(CurrencyServerAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// currency server app is started and running
	}
}
