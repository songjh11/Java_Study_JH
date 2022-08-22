package com.iu.spring.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeListDAO implements NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.spring.notice.NoticeListDAO.";
	
	//목록
	@Override
	public List<NoticeDTO> getList()throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	@Override
	//추가
	public int addNotice(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"addNotice", noticeDTO);
		
	}
	
	@Override
	//수정
	public int updateNotice(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"updateNotice", noticeDTO);
	}
	

	@Override
	//삭제
	public int deleteNotice (NoticeDTO noticeDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"deleteNotice", noticeDTO);
	}
	
	@Override
	//조회수증가
	public int updateHit (NoticeDTO noticeDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"updateHit", noticeDTO);
	}
	
	@Override
	//글 한개 조회
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", noticeDTO);
	}
	

}
