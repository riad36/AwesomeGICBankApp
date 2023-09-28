package com.gicbank.app.service;


import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gicbank.app.model.AccountTransaction;

public class TransactionServiceTest {
	

	private TransactionService targetClass = null;
	
	@BeforeEach
	public void setUp() {
		targetClass = new TransactionService();
		AccountService.updateAccountBalance("S123", new BigDecimal("100"));
		TransactionService t1 = new TransactionService();
		t1.processTransaction(LocalDate.of(2023, 6, 1), "S123", "D", new BigDecimal("1000.00"));
		t1.processTransaction(LocalDate.of(2023, 6, 1), "S123", "W", new BigDecimal("300.00"));
	}
	
	@Test
	public void testConstructor() {
		assertNotNull(targetClass);
	}
	
	@Test
	public void testaddTransaction() {
		String tranId = targetClass.generateTransactionId(LocalDate.of(2023, 6, 1));
		targetClass.addTransaction( new AccountTransaction(
				tranId,
				LocalDate.of(2023, 6, 1),"S123","D",new BigDecimal("300.00")));
	}
	
	@Test
	public void testprocessTransaction() {
		targetClass.processTransaction(LocalDate.of(2023, 9, 28), "S123","D",new BigDecimal("120.50"));
		targetClass.processTransaction(LocalDate.of(2023, 9, 28), "S123","W",new BigDecimal("110.00"));
	}
	
	@Test
	public void testprintTransactionStatementByAccountNo() {
		targetClass.printTransactionStatementByAccountNo("S123");
	}
}
