package com.iu.spring.board.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.spring.board.impl.BoardDTO;
import com.iu.spring.board.impl.BoardService;
import com.iu.spring.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.getRowNum();
		Long totalCount = qnaDAO.getPageCount();
		pager.getNum(totalCount);
//		Long totalCount = qnaDAO.getPageCount();
//		
//		Long startRow=0L;
//		Long lastRow=0L;
//		Long perPage=10L;
//		lastRow=page*perPage;
//		startRow=(page-1)*perPage+1;
//		Map<String, Long> map = new HashMap<String, Long>();
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
			return qnaDAO.getList(pager);
	}
	
	/**
	글의 갯수가 총 80개
	1-10
	11-20
	21-30
	31-40
	**/
	
	/*
	 * JSP에 페이지 번호를 출력하려고 함 
	 * 1. 글의 총 갯수
	 * 2. 총 페이지 수 구하기
	 * */
	
	
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setAdd(boardDTO);
	}
	
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setUpdate(boardDTO);
	}
	
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setDelete(boardDTO);
	}
	
	@Override
	public int updateHit(BoardDTO boardDTO) throws Exception {
		return qnaDAO.updateHit(boardDTO);
	}


}
