package com.iu.spring.board.impl;

import java.sql.Date;
import java.util.List;

public class BoardDTO {
	
	private Long num; 
	private String title;
	private String contents;
	private String writer;
	private Date regDate;
	private Long hit;
	private List<BoardFileDTO> boardFileDTO;
	
	
	public List<BoardFileDTO> getBoardFileDTO() {
		return boardFileDTO;
	}
	public void setBoardFileDTO(List<BoardFileDTO> boardFileDTO) {
		this.boardFileDTO = boardFileDTO;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		if(this.contents.equals("(null)")) {
			this.contents = "내용 없음";
		}
		return contents;
	}
	public void setContents(String contents) {
		this.contents= contents;
		
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	
	
	
	

}
