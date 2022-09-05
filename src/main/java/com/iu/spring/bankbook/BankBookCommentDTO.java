package com.iu.spring.bankbook;

import com.iu.spring.board.impl.CommentDTO;

public class BankBookCommentDTO extends CommentDTO {

	private Long bookNum;

	public Long getBookNum() {
		return bookNum;
	}

	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	
}
