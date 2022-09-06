package com.iu.spring.bankBook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.spring.MyAbstractTest;
import com.iu.spring.bankbook.BankBookCommentDAO;
import com.iu.spring.bankbook.BankBookCommentDTO;
import com.iu.spring.bankbook.BankBookDAO;
import com.iu.spring.util.CommentPager;

public class BankBookTest extends MyAbstractTest {

	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO; 

	
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
	
	@Test
	public void getCommentListTest() throws Exception {
		 CommentPager commentPager = new CommentPager();
	      commentPager.setBookNum(1662427941805L);
	      commentPager.setPage(1L);
	      commentPager.getRowNum();
	      List<BankBookCommentDTO> ar = bankBookCommentDAO.getCommentList(commentPager);
	      assertEquals(5, ar.size());
	}
}
