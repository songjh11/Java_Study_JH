package com.iu.spring.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping (value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping (value="list.do", method=RequestMethod.GET)
	public void getNoticeList(HttpSession session) throws Exception {
		System.out.println("NoticeGetList");
		List<NoticeDTO> ar = noticeService.getList();
		session.setAttribute("noticeList", ar);
		
	}

}
