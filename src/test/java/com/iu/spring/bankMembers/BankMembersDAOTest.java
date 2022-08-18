package com.iu.spring.bankMembers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.iu.spring.MyAbstractTest;
import com.iu.spring.bankmembers.BankMemberService;
import com.iu.spring.bankmembers.BankMembersDAO;
import com.iu.spring.bankmembers.BankMembersDTO;

public class BankMembersDAOTest extends MyAbstractTest {

	@Autowired
	private BankMemberService bankMemberService;
	private BankMembersDTO bankMembersDTO;
		
	@Test
	public void getLoginTest() throws Exception {
		bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("1234");
		bankMembersDTO.setPassword("1");
		bankMembersDTO = bankMemberService.getLogin(bankMembersDTO);
		assertNull(bankMembersDTO);
	}

	

}
