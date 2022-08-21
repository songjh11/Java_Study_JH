package com.iu.spring.bankaccount;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BankAccountService {
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	public int setAccount(BankAccountDTO accountDTO) throws Exception {
		int result = bankAccountDAO.setAccount(accountDTO);
		return result;
	}

}
