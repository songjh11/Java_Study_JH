package com.iu.spring.qna;

import java.util.List;


public interface QnADAO {
	
	public List<QnADTO> getList()throws Exception;
	
	public int setQnA(QnADTO qnaDTO) throws Exception;
	
	public int updateQnA(QnADTO qnaDTO) throws Exception;

	public int deleteQnA (QnADTO qnaDTO) throws Exception;
	
	public int updateHit (QnADTO qnaDTO) throws Exception;
	
	public QnADTO getDetail(QnADTO qnaDTO) throws Exception;
}
