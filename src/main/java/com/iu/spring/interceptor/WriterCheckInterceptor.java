package com.iu.spring.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.spring.bankmembers.BankMembersDTO;
import com.iu.spring.board.impl.BoardDTO;

public class WriterCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			System.out.println("인터셉터 실행");
			String method= request.getMethod();
			if(method.equals("POST")) {
				return;
			}
			//로그인한 사용자의 ID와 DTO의 작성자가 일치하는가?
			HttpSession session = request.getSession();
			BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
			Map<String, Object> map = modelAndView.getModel();
			BoardDTO boardDTO = (BoardDTO)map.get("boardDTO");
			
			if(!bankMembersDTO.getUserName().equals(boardDTO.getWriter())){
				modelAndView.addObject("message", "작성자만 수정이 가능합니다");
				modelAndView.addObject("url", "./list.do");
				modelAndView.addObject("result", 1);
				modelAndView.setViewName("common/result");
			}
			
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
	
}
