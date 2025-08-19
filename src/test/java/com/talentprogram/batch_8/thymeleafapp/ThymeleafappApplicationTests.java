package com.talentprogram.batch_8.thymeleafapp;

import com.talentprogram.batch_8.thymeleafapp.model.Account;
import com.talentprogram.batch_8.thymeleafapp.model.Transaction;
import com.talentprogram.batch_8.thymeleafapp.model.enumType.TransactionCategory;
import com.talentprogram.batch_8.thymeleafapp.model.enumType.TransactionType;
import com.talentprogram.batch_8.thymeleafapp.service.AccountService;
import com.talentprogram.batch_8.thymeleafapp.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThymeleafappApplicationTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(ThymeleafappApplicationTests.class);

	@Autowired
	AccountService accountService;

	@Autowired
	TransactionService transactionService;

	@Test
	void contextLoads() {
	}

	//@Test
	public void saveAccounts() {
		Account account1 = new Account();
		account1.setAccountId("09455011542");
		account1.setAddress("Yangon");
		account1.setUserName("myothiha");
		account1.setPassword("123456");
		account1.setNrcNumber("12/LAMANA(N)156865");
		account1.setEmail("myothiha@gmail.com");
		account1.setBalance(0);

		Account account2 = new Account();
		account2.setAccountId("09452029342");
		account2.setAddress("Sanchaung");
		account2.setUserName("agwyoo");
		account2.setPassword("512949");
		account2.setNrcNumber("12/SAKHANA(N)594209");
		account2.setEmail("agwyoo@gmail.com");
		account2.setBalance(50000);

		Account account3 = new Account();
		account3.setAccountId("09923423034");
		account3.setAddress("Sanchaung");
		account3.setUserName("aungthuhein");
		account3.setPassword("592103");
		account3.setNrcNumber("12/SAKHANA(N)141923");
		account3.setEmail("aungthuhein@gmail.com");
		account3.setBalance(100000);

		LOGGER.info("{} is saved now .{} ",account1.getUserName(), accountService.saveAccount(account1));
		LOGGER.info("{} is saved now .{} ",account2.getUserName(), accountService.saveAccount(account2));
		LOGGER.info("{} is saved now .{} ",account3.getUserName(), accountService.saveAccount(account3));
	}

	//@Test
	public void testAddInitialBalance(){
		String accountId = "09455011542";
		double initialBalance = 300000;

		boolean isAdd = accountService.addInitialBalance(accountId, initialBalance);
		if(isAdd){
			LOGGER.info("Your account's initial balance is added now.");
		}
		else {
			LOGGER.info("Please check your input!");
		}

	}

	//@Test
	void testAddTransaction(){
		Transaction transaction=new Transaction();

		transaction.setTransactionId(System.currentTimeMillis());
		transaction.setTransactionCategory(TransactionCategory.TIP);
		transaction.setTransactionType(TransactionType.INCOME);
		transaction.setAmount(15000);
		transaction.setAccountId("09455011542");

		transactionService.saveNewTransaction(transaction);

		Account updatedAccount = accountService.updateBalance(transaction.getAccountId(),transaction.getAmount(),transaction.getTransactionType());

		LOGGER.info(updatedAccount.toString());

	}

	//@Test
	void testGetAllExpenses(){
		String accountId= "09455011542";

		LOGGER.info("Your all expense is : {}",
				transactionService.getAllExpenseByTransactionCategory(accountId,TransactionCategory.SNACK));
	}

	//@Test
	void testGetAllIncome(){
		String accountId = "09455011542";

		LOGGER.info("Your all income is : {}",
				transactionService.getAllIncomeByTransactionCategory(accountId,TransactionCategory.TIP));
	}

	//@Test
	void testGetAllTransaction(){
		String accountId = "09455011542";

		LOGGER.info("Your all transactions are : {}",
				transactionService.getAllTransaction(accountId));
	}

	@Test
	void testGetTransactionByMonth(){
		String accountId = "09455011542";
		int month = 8;
		int year = 2025;

		LOGGER.info("Monthly transaction summary : {}",
				transactionService.getTransactionByMonth(accountId,month,year));
	}

}
