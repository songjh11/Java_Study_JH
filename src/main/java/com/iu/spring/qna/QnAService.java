package com.iu.spring.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnAService {

	@Autowired
	private QnAListDAO qnAListDAO;
	
	//목록
	public List<QnADTO> getList()throws Exception{
		return qnAListDAO.getList();
	}
	

	//추가
	public int setQnA(QnADTO qnaDTO) throws Exception{
		return qnAListDAO.setQnA(qnaDTO);
		
		
	}
	

	//수정
	public int updateQnA(QnADTO qnaDTO) throws Exception{
		return qnAListDAO.updateQnA(qnaDTO);
	}
	


	//삭제
	public int deleteQnA (QnADTO qnaDTO) throws Exception{
		return qnAListDAO.deleteQnA(qnaDTO);
	}
	

	//조회수증가
	public int updateHit (QnADTO qnaDTO) throws Exception{
		return qnAListDAO.updateHit(qnaDTO);
	}
	

	//글 한개 조회
	public QnADTO getDetail(QnADTO qnaDTO) throws Exception{
		return qnAListDAO.getDetail(qnaDTO);
	}
	

}
