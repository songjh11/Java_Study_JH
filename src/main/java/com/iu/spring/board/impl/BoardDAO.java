package com.iu.spring.board.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.iu.spring.util.Pager;


public interface BoardDAO {
		
	//글 목록
		public List<BoardDTO> getList(Pager pager) throws Exception; 
	
	//글 상세보기
		public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
		
	//글 쓰기
		public int setAdd(BoardDTO boardDTO) throws Exception;
	
	//글 수정
		public int setUpdate(BoardDTO boardDTO) throws Exception;
		
	//글 삭제
		public int setDelete(BoardDTO boardDTO) throws Exception;
	
	//조회수 증가
		public int updateHit(BoardDTO boardDTO) throws Exception;
		
	//페이지 수 만들기
		public Long getPageCount(Pager pager) throws Exception;
	
	//파일 추가하기	
		public int setAddFiles(BoardFileDTO boardFileDTO) throws Exception;
	
	//파일 삭제하기
		public int setFileDelete(BoardFileDTO boardFileDTO) throws Exception;
		
	//
		public BoardFileDTO getFileDetail(BoardFileDTO boardFileDTO) throws Exception;
}