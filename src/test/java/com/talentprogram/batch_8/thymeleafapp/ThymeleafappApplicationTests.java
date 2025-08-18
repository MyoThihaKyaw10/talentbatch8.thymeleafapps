package com.talentprogram.batch_8.thymeleafapp;

import com.talentprogram.batch_8.thymeleafapp.model.Account;
import com.talentprogram.batch_8.thymeleafapp.service.AccountService;
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

	@Test
	void contextLoads() {
	}


	@Test
	public void saveAccounts() {
		Account account1 = new Account();
		account1.setAccountId("09455011542");
		account1.setAddress("Yangon");
		account1.setUserName("myothiha");
		account1.setPassword("123456");
		account1.setNrcNumber("12/LAMANA(N)156865");
		account1.setEmail("myothiha@gmail.com");

		Account account2 = new Account();
		account2.setAccountId("09452029342");
		account2.setAddress("Sanchaung");
		account2.setUserName("agwyoo");
		account2.setPassword("512949");
		account2.setNrcNumber("12/SAKHANA(N)594209");
		account2.setEmail("agwyoo@gmail.com");

		Account account3 = new Account();
		account3.setAccountId("09923423034");
		account3.setAddress("Sanchaung");
		account3.setUserName("aungthuhein");
		account3.setPassword("592103");
		account3.setNrcNumber("12/SAKHANA(N)141923");
		account3.setEmail("aungthuhein@gmail.com");

		LOGGER.info("{} is saved now .{} ",account1.getUserName(), accountService.saveAccount(account1));
		LOGGER.info("{} is saved now .{} ",account2.getUserName(), accountService.saveAccount(account2));
		LOGGER.info("{} is saved now .{} ",account3.getUserName(), accountService.saveAccount(account3));
	}

}
