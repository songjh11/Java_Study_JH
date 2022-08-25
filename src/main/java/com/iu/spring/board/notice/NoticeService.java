package com.iu.spring.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.spring.board.impl.BoardDTO;
import com.iu.spring.board.impl.BoardService;
import com.iu.spring.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = noticeDAO.getPageCount();
		pager.getNum(totalCount);
		pager.getRowNum();
//		System.out.println("Service page: "+page);
//		//page         startRow            lastRow
//		//1              1                    10
//		//2              11                   20
//		//3              21                   30
//		//1              1                    15
//		//2              16                   30
//		//3              31                   45
//		Long startRow=0L;
//		Long lastRow=0L;
//		Long perPage=10L;
//		lastRow=page*perPage;
//		startRow=(page-1)*perPage+1;
//		Map<String, Long> map = new HashMap<String, Long>();
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
//		System.out.println("startRow: "+startRow+"\t"+"lastRow: "+lastRow);
//		
//		Long totalCount = noticeDAO.getPageCount();
//		Long totalPage = totalCount/perPage;
//		if(totalCount%perPage!=0) {
//			totalPage++;
//		}
//		System.out.println(totalPage);
		
		/*
		 * 3. totalBlock 갯수 구하기
		 * Block :  
		 * perBlock : 한 페이지에 출력할 정보
		 * 
		 * 4.page로 현재 Block 번호 찾기
		 * page              perBlock
		 * 1                    1     
		 * 2                    1
		 * 3                    1
		 * 4                    1        
		 * 5                    1
		 * 6					2
		 * ...                  
		 * 11                   3
		 * */
		
//		Long perBlock = 5L;
//		Long totalBlock = totalPage/perBlock;
//		
//		if(totalPage%perBlock != 0) {
//			totalBlock++;
//		}
//		
//		Long curBlock = page/perBlock;
//		if(page%perBlock!=0) {
//			curBlock++;
//		}
		
		/*5. curBlock으로 시작번호, 끝 번호 알아오기
		 * curBlock      startNum       lastNum
		 * 1             1                5
		 * 2             6                10
		 * 3             11               13
		 *   
		 * */
		
//		Long startNum = (curBlock-1)*perBlock+1;
//		Long lastNum = curBlock*perBlock;		
//		
		return noticeDAO.getList(pager);
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
