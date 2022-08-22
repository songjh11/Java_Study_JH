package com.iu.spring.bankaccount;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.spring.bankmembers.BankMembersDTO;


@Service
public class BankAccountService {
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	public int setAccount(BankAccountDTO accountDTO) throws Exception {
		int result = bankAccountDAO.setAccount(accountDTO);
		return result;
	}
	
	public List<BankAccountDTO> getList(BankMembersDTO bankMembersDTO) throws Exception{
		return bankAccountDAO.getListByUserName(bankMembersDTO);
	}

}
