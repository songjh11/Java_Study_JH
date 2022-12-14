package com.iu.spring.board.impl;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.iu.spring.util.Pager;

public interface BoardService {
	
	//글 목록
	public List<BoardDTO> getList(Pager pager) throws Exception;
			
	//글 조회
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	//글쓰기
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files, ServletContext servletContext) throws Exception;
	
	//글 수정
	public int setUpdate(BoardDTO boardDTO, MultipartFile [] files, ServletContext servletContext) throws Exception;
	
	//글 삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	//조회수 증가
	public int updateHit(BoardDTO boardDTO) throws Exception;
	
	//파일 삭제
	public int setFileDelete(BoardFileDTO boardFileDTO, ServletContext context) throws Exception;

	
}
