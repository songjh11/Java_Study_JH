package com.iu.spring.bankmembers;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.spring.bankmembers.BankMembersDTO;


@Repository
public class BankMembersDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.spring.bankmembers.BankMembersDAO.";
	
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
	return sqlSession.selectOne(NAMESPACE+"getLogin", bankMembersDTO);
	}
	
	public int setJoin(BankMembersDTO bankMembersDTO ) throws Exception {
	return sqlSession.insert(NAMESPACE+"setJoin", bankMembersDTO);
	}
	

	public List<BankMembersDTO> getSearchById(String search) throws Exception {
			return sqlSession.selectList(NAMESPACE+"getSearchById", search);
	}

}
	
	

