package com.iu.spring.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.spring.board.impl.BoardDTO;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<BoardDTO> getList() throws Exception {
		return noticeDAO.getList();
	}

	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getDetail(boardDTO);
	}

	public int setAdd(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setAdd(boardDTO);
	}


	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}


	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}

}
