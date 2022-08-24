package com.iu.spring.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.spring.board.impl.BoardDTO;
import com.iu.spring.board.impl.BoardService;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<BoardDTO> getList(Long page) throws Exception {
		System.out.println("Service page: "+page);
		//page         startRow            lastRow
		//1              1                    10
		//2              11                   20
		//3              21                   30
		//1              1                    15
		//2              16                   30
		//3              31                   45
		Long startRow=0L;
		Long lastRow=0L;
		Long perPage=10L;
		lastRow=page*perPage;
		startRow=(page-1)*perPage+1;
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);
		System.out.println("startRow: "+startRow+"\t"+"lastRow: "+lastRow);
		
		return noticeDAO.getList(map);
	}
	
	@Override
	public Long getPageCount() throws Exception {
		return noticeDAO.getPageCount();
		
	}
	
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}
	
	@Override
	public int updateHit(BoardDTO boardDTO) throws Exception {
		return noticeDAO.updateHit(boardDTO);
	}

	
}
