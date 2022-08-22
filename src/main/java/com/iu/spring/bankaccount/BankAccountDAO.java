package com.iu.spring.bankaccount;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.spring.bankmembers.BankMembersDTO;

@Repository
public class BankAccountDAO implements AccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.spring.bankaccount.BankAccountDAO.";
	
	public int setAccount(BankAccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAccount", accountDTO);
	}
	
	public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getListByUserName", bankMembersDTO);
	}

}
