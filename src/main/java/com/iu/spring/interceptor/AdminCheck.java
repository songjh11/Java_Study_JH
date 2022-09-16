package com.iu.spring.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.spring.bankmembers.BankMembersDTO;
import com.iu.spring.role.RoleDTO;

public class AdminCheck extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//1. roleName print
		HttpSession session = request.getSession();
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		
		boolean check = false;
		
		for(RoleDTO roleDTO: bankMembersDTO.getRoleDTOs()) {
			System.out.println(roleDTO.getRoleNum());
			System.out.println(roleDTO.getRoleName());
			if(roleDTO.getRoleName().equals("admin")) {
				check = true;
				break;
			}
		}
		//admin이 아닐떄
		if(!check) {
			request.setAttribute("message", "권한이 없습니다");
			request.setAttribute("url", "../../../../../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");//JSP의 경로 넣기
			view.forward(request, response);
		}
		return check;
	}
	
	

}
