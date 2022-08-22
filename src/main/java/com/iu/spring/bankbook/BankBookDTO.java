package com.iu.spring.bankbook;

import java.util.List;

import com.iu.spring.bankaccount.BankAccountDTO;

public class BankBookDTO {

	private Long bookNum;
	private String bookName;
	private Double bookRate;
	private Integer bookSale;
	private List<BankAccountDTO> bankAccountDTO;
	
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Double getBookRate() {
		return bookRate;
	}
	public void setBookRate(Double bookRate) {
		this.bookRate = bookRate;
	}
	public Integer getBookSale() {
		return bookSale;
	}
	public void setBookSale(Integer bookSale) {
		this.bookSale = bookSale;
	}
	
}
