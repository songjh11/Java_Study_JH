package com.iu.spring.bankaccount;

import java.sql.Date;

import com.iu.spring.bankbook.BankBookDTO;

public class BankAccountDTO {

	private int accountNum;
    private String userName;
    private Long bookNum;
    private Date accountDate;
    private BankBookDTO bankBookDTO;
    
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
    
    
}
