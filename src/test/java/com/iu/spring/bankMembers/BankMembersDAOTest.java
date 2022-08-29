package com.iu.spring.bankMembers;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

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
	
	@Test
	public void setJoinTest() throws Exception {
		bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("56");
		bankMembersDTO.setPassword("s");
		bankMembersDTO.setName("s");
		bankMembersDTO.setEmail("s");
		bankMembersDTO.setPhone("s");


	}
		
		@Test
		public void getSearchById() throws Exception {
			List<BankMembersDTO> ar = bankMemberService.getSearchById("a");
			assertEquals(0, ar.size());
		}
		
//		@Test
//		public void getListTest() throws Exception{
//			BankMembersDTO bankMembersDTO = new BankMembersDTO();
//			bankMembersDTO.setUserName("1234");
//			Map<String, Object> map = bankMemberService.getMyPage(bankMembersDTO);
//			assertNotEquals(0, map);
//		}

	

}
