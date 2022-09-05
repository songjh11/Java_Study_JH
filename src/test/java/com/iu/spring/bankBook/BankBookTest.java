package com.iu.spring.bankBook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.spring.MyAbstractTest;
import com.iu.spring.bankbook.BankBookCommentDTO;
import com.iu.spring.bankbook.BankBookDAO;

public class BankBookTest extends MyAbstractTest {

	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void setCommentAdd() throws Exception {
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setNum(23L);
		bankBookCommentDTO.setBookNum(2L);
		bankBookCommentDTO.setContents("0987654321");
		bankBookCommentDTO.setWriter("0987");
		
		int result = bankBookDAO.setCommentAdd(bankBookCommentDTO); 
		
		assertNotEquals(0, result);
	}
	
}
