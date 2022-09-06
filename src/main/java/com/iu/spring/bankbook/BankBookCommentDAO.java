package com.iu.spring.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.spring.util.CommentPager;

@Repository
public class BankBookCommentDAO {

		@Autowired
		private SqlSession sqlSession;
		
		private final String NAMESPACE = "com.iu.spring.bankbook.BankBookCommentDAO.";
		
		public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception {
			return sqlSession.insert(NAMESPACE+"setCommentAdd", bankBookCommentDTO);
		}
		
		public List<BankBookCommentDTO> getCommentList(CommentPager pager) {
			return sqlSession.selectList(NAMESPACE+"getCommentList", pager);
		}
		
		
}
