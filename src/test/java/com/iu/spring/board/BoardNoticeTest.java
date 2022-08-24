package com.iu.spring.board;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.spring.MyAbstractTest;
import com.iu.spring.board.impl.BoardDTO;
import com.iu.spring.board.notice.NoticeDAO;

public class BoardNoticeTest extends MyAbstractTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	public void getList(Map) throws Exception{
//		List<BoardDTO> ar = noticeDAO.getList(map);
//		assertEquals(0, ar.size());
//	}
//	
//	
//	@Test
//	public void getDetail() throws Exception {
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(1L);
//		boardDTO = noticeDAO.getDetail(boardDTO);
//		assertNull(boardDTO);
//		}
//	
//	@Test
//	public void setAdd() throws Exception {
//		for(int i=0; i<100; i++) {
//			
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setTitle("Test"+i);
//		boardDTO.setContents("ContentsContentsContentsContents"+i);
//		boardDTO.setWriter("Tester"+i);
//		int result = noticeDAO.setAdd(boardDTO);
//		
//		if(i%10==0) {
//			Thread.sleep(500);
//		}
//		
//		}
//		System.out.println("Finish!");
//		assertEquals(1, result);}
	

//
//	@Test
//	public void setUpdate() throws Exception {
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(16L);
//		boardDTO.setTitle("test");
//		boardDTO.setContents("sdafqgw");
//		boardDTO.setWriter("wggrwqoipw");
//		int result = noticeDAO.setUpdate(boardDTO);
//		assertEquals(1, result);
//	}
//
//	@Test
//	public void setDelete() throws Exception {
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(1L);
//		int result = noticeDAO.setDelete(boardDTO);
//		assertEquals(1, result);
//	}
}

