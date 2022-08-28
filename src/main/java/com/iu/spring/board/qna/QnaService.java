package com.iu.spring.board.qna;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.spring.board.impl.BoardDTO;
import com.iu.spring.board.impl.BoardFileDTO;
import com.iu.spring.board.impl.BoardService;
import com.iu.spring.util.AddFiles;
import com.iu.spring.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = qnaDAO.getPageCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
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
	
	public int setReply (QnaDTO qnaDTO) throws Exception {
		BoardDTO boardDTO = qnaDAO.getDetail(qnaDTO);
		QnaDTO parents = (QnaDTO)boardDTO;
		qnaDTO.setRef(parents.getRef());
		qnaDTO.setStep(parents.getStep()+1);
		qnaDTO.setDepth(parents.getDepth()+1);
		
		qnaDAO.setStepUpdate(parents);
		int result = qnaDAO.setReplyAdd(qnaDTO);
		
		return result;
	}
	
	
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		System.out.println("insert 전: "+boardDTO.getNum());
		int result =  qnaDAO.setAdd(boardDTO);
		System.out.println("insert 후: "+boardDTO.getNum());
		
		for(MultipartFile mf: files) {
			if(mf.isEmpty()) {
				continue;
			} 
			String realPath = servletContext.getRealPath("resources/upload/QnA");
			System.out.println("realPath : "+realPath);
			
			File file = new File(realPath);
			
			System.out.println(file);

			if(!file.exists()) {
				file.mkdirs();
			}
		
			String fileName = UUID.randomUUID().toString();
			fileName = fileName+"_"+mf.getOriginalFilename();
			
			System.out.println(fileName);
			
			file = new File(file, fileName);
			System.out.println(file);
			
			mf.transferTo(file);
			
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(mf.getOriginalFilename());
			qnaDAO.setAddFiles(boardFileDTO);
			System.out.println("저장");
		}
		
		return result;
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
