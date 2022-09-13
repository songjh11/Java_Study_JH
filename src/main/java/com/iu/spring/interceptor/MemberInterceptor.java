package com.iu.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.spring.bankmembers.BankMembersDTO;

public class MemberInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");
		if(obj != null) {
			System.out.println("로그인 성공");
			return true;
		} else {
			System.out.println("로그인 실패");
			response.sendRedirect("../../../../../../members/login.do");
			return false;
		}
	}

	
	
}
