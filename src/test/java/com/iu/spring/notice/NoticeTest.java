package com.iu.spring.notice;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.spring.MyAbstractTest;
import com.iu.spring.bankmembers.BankMembersDAO;


public class NoticeTest extends MyAbstractTest {
	//@Autowired
	private NoticeListDAO noticeListDAO;
	//@Autowired
	private BankMembersDAO bankMembersDAO;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void test() {
		assertNotNull(sqlSession);
		
	}
	
	

}
