package com.iu.spring.bankaccount;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankAccountDAO implements AccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.spring.bankaccount.BankAccountDAO.";
	
	public int setAccount(BankAccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAccount", accountDTO);
	}

}
