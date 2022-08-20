package com.iu.spring.bankbook;

import java.util.List;

public interface BookDAO {

	
	public int setBook(BankBookDTO bankBookDTO) throws Exception;
	
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception;
	
	
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception;

	
	public List<BankBookDTO> getList() throws Exception;
	
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception;
	
	
	public int deleteBook(BankBookDTO bankBookDTO) throws Exception;
	
}
