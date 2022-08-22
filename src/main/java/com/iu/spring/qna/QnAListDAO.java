package com.iu.spring.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QnAListDAO implements QnADAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.spring.qna.QnAListDAO.";
	
	//목록
	@Override
	public List<QnADTO> getList()throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	@Override
	//추가
	public int setQnA(QnADTO qnaDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setQnA", qnaDTO);
		
	}
	
	@Override
	//수정
	public int updateQnA(QnADTO qnaDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"updateQnA", qnaDTO);
	}
	

	@Override
	//삭제
	public int deleteQnA (QnADTO qnaDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"deleteQnA", qnaDTO);
	}
	
	@Override
	//조회수증가
	public int updateHit (QnADTO qnaDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"updateHit", qnaDTO);
	}
	
	@Override
	//글 한개 조회
	public QnADTO getDetail(QnADTO qnaDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", qnaDTO);
	}
	

}
