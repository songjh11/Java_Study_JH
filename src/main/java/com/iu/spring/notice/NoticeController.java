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
	
	@RequestMapping (value="detail.do", method=RequestMethod.GET)
	public void getText(NoticeDTO noticeDTO, HttpSession session) throws Exception {
		System.out.println("NoticeText");
		noticeDTO = noticeService.getDetail(noticeDTO);
		session.setAttribute("text", noticeDTO);
	}
		
		@RequestMapping (value="add.do", method=RequestMethod.GET)
		public void addText() throws Exception {
			NoticeDTO noticeDTO = new NoticeDTO();
			int result = noticeService.addNotice();
		}
//		int result = noticeService.addNotice(noticeDTO); 
//		if(result>0) {
//			String url = "redirect:./list.do";
//		}
}
