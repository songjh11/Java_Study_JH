package com.iu.spring.board.qna;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.spring.board.impl.BoardDAO;
import com.iu.spring.board.impl.BoardDTO;
import com.iu.spring.util.Pager;

@Repository
public class QnaDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.spring.board.qna.QnaDAO.";
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {			
	return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	
	@Override
	public Long getPageCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getPageCount", pager);
	}
	
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getDetail", boardDTO);
	}
	
	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAdd", boardDTO);
	}
	
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}
	
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}
	
	@Override
	public int updateHit(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"updateHit", boardDTO);
	}

	public int setReplyAdd(QnaDTO qnaDTO) {
		return sqlSession.insert(NAMESPACE+"setReplyAdd", qnaDTO);
	}
	
	public int setStepUpdate(QnaDTO qnaDTO) {
		return sqlSession.update(NAMESPACE+"setStepUpdate", qnaDTO);
	}
}
