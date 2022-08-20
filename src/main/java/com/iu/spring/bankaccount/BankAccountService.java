package com.iu.spring.bankaccount;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oracle.sql.DATE;

@Service
public class BankAccountService {
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	public int setAccount(BankAccountDTO accountDTO) throws Exception {
		int result = bankAccountDAO.setAccount(accountDTO);
		return result;
	}

}
