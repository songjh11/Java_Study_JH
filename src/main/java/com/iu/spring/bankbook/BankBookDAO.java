package com.iu.spring.bankbook;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookDAO implements BookDAO {
	//수정
	//등록
	//판매여부 변경
	//리스트조회
	//항목조회
	//삭제
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.spring.bankbook.BankBookDAO.";
	
	@Override
	public int setBook(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setBook", bankBookDTO);
	}
	
	@Override	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", bankBookDTO);
	}
	
	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setChangeSale", bankBookDTO);
	}
	
	@Override
	public List<BankBookDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getDetail", bankBookDTO);
	}
	
	@Override
	public int deleteBook(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"deleteBook", bankBookDTO);
	}
	
}
