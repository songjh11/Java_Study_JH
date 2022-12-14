package com.iu.spring.board.notice;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.iu.spring.board.impl.BoardDAO;
import com.iu.spring.board.impl.BoardDTO;
import com.iu.spring.board.impl.BoardFileDTO;
import com.iu.spring.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {
	

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.spring.board.notice.NoticeDAO."; 
	
	@Override
	public BoardFileDTO getFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getFileDetail", boardFileDTO);
	}

	@Override
	public int setAddFiles(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAddFiles", boardFileDTO);
	}
	
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

	@Override
	public int setFileDelete(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setFileDelete", boardFileDTO);
	}
	
	
}
