package com.iu.spring.bankbook;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class BankBookCommentDAO {

		@Autowired
		private SqlSession sqlSession;
		
		private final String NAMESPACE = "com.iu.spring.bankbook.BankBookCommentDAO.";
		
		public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception {
			return sqlSession.insert(NAMESPACE+"setCommentAdd", bankBookCommentDTO);
		}
		
		
}
