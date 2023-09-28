package com.gicbank.app.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gicbank.app.model.AccountTransaction;

public class InterestRateServiceTest {

	InterestRateService targetClass = null;

	@BeforeEach
	public void setUp() {
		targetClass = new InterestRateService();
		targetClass.addOrUpdateInterestRule(LocalDate.of(2023, 6, 1), "RULE01", new BigDecimal("2.0"));
	}

	@Test
	public void testprintCalculatedInterestAmountForStatement() {
		TransactionService tranServices = new TransactionService();
		List<AccountTransaction> accTransactionList = new ArrayList<>();
		accTransactionList.add(new AccountTransaction(tranServices.generateTransactionId(LocalDate.of(2023, 6, 1)),
				LocalDate.of(2023, 6, 1), "S123", "D", new BigDecimal("300.00")));

		InterestRateService.printCalculatedInterestAmountForStatement("S123", accTransactionList,
				LocalDate.of(2023, 06, 01), LocalDate.of(2023, 06, 30), new BigDecimal("300.00"));
	}

}
