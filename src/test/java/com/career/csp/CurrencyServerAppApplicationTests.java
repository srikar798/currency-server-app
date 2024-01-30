package com.career.csp;

import com.career.csp.service.CurrencyNotFoundException;
import com.career.csp.service.CurrencyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CurrencyServerAppApplicationTests {

	@Autowired
	private CurrencyService currencyService;
	@Test
	void currencyCountTest() {
		int expected = 168;
		int actual = currencyService.getAllCurrencies().size();
		Assertions.assertEquals(expected,actual);
	}

	@Test
	void getCurrencyWithValidCode() {
		String code = "INR";
		String expected = "Indian Rupee";
		String actual = currencyService.getCurrency(code).name();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void getCurrencyWithInValidCode(){
		String code = "INR1";
		Assertions.assertThrows(CurrencyNotFoundException.class,()->currencyService.getCurrency(code));
		//test cases
	}

}

