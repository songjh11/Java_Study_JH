package com.iu.spring.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.spring.util.CommentPager;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	public int setDeleteComment(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return bankBookCommentDAO.setDeleteComment(bankBookCommentDTO);
	}
	
	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		return bankBookCommentDAO.setCommentUpdate(bankBookCommentDTO);
	}
	
	public List<BankBookCommentDTO> getCommentList(CommentPager pager) throws Exception {
		pager.getRowNum();
		Long totalCount = bankBookCommentDAO.getCommentListTotalCount(pager);
		pager.makePage(totalCount);
		return bankBookCommentDAO.getCommentList(pager);				
	}
	
	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
	}
	
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	
	public int setBook(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setBook(bankBookDTO);
	}
	

	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setChangeSale(bankBookDTO);
	}
	

	public List<BankBookDTO> getList() throws Exception {
		return bankBookDAO.getList();
	}
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	public int deleteBook(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.deleteBook(bankBookDTO);
	}
}
