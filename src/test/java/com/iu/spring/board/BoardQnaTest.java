package com.iu.spring.board;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.spring.MyAbstractTest;
import com.iu.spring.board.impl.BoardDTO;
import com.iu.spring.board.qna.QnaDAO;
import com.iu.spring.board.qna.QnaDTO;

public class BoardQnaTest extends MyAbstractTest {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
public void setText() throws Exception {
	for(int i=0; i<100; i++) {
		
	QnaDTO qnaDTO = new QnaDTO();
	qnaDTO.setTitle("Qna글"+i);
	qnaDTO.setContents("내용"+i);
	qnaDTO.setWriter("Manager");
	int result = qnaDAO.setAdd(qnaDTO);
	
	if(i%10==0) {
		Thread.sleep(500);
	}
	
	}
	System.out.println("Finish!");
	
	}
	
//	@Test
//	public void getList() throws Exception{
//		List<BoardDTO> ar = qnaDAO.getList();
//		assertEquals(0, ar.size());
//	}
//		@Test
//		public void count() throws Exception{
//		long count = qnaDAO.getPageCount();
//		assertEquals(10, count);
//		}
	
//		@Test
//		public void getDetail() throws Exception{
//			BoardDTO boardDTO = new BoardDTO();
//			boardDTO.setNum(101L);
//			boardDTO = qnaDAO.getDetail(boardDTO);
//			assertNotNull(boardDTO);
//		}
//		
//		@Test
//		public void setAdd() throws Exception{
//			QnaDTO qnaDTO = new QnaDTO();
//			qnaDTO.setContents("테스트2");
//			qnaDTO.setTitle("제목2");
//			qnaDTO.setWriter("작성자2");
//			int result = qnaDAO.setAdd(qnaDTO);
//			assertEquals(1, result);
//		}
//	
//		@Test
//		public void setUpdate() throws Exception{
//			QnaDTO qnaDTO = new QnaDTO();
//			qnaDTO.setNum(61L);
//			qnaDTO.setContents("수정테스트");
//			qnaDTO.setTitle("제목수정");
//			qnaDTO.setWriter("Manager");
//			int result = qnaDAO.setUpdate(qnaDTO);
//			assertEquals(1, result);
//		}
//		
//		@Test
//		public void setDelete() throws Exception{
//			QnaDTO qnaDTO = new QnaDTO();
//			qnaDTO.setNum(62L);
//			int result = qnaDAO.setDelete(qnaDTO);
//			assertEquals(1, result);
//		}

}
