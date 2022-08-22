package com.iu.spring.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.spring.bankbook.BankBookDTO;

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
		noticeService.updateHit(noticeDTO);
		System.out.println(noticeDTO.getHit());
		noticeDTO = noticeService.getDetail(noticeDTO);
		session.setAttribute("text", noticeDTO);
	}
		
		@RequestMapping (value="add.do", method=RequestMethod.GET)
		public void addText() throws Exception {
			System.out.println("addText");
			
		}

		@RequestMapping(value="add.do", method=RequestMethod.POST)
		public ModelAndView addText(NoticeDTO noticeDTO) throws Exception {
			System.out.println("addTextPost");
			int result = noticeService.addNotice(noticeDTO);
			ModelAndView modelAndView = new ModelAndView();
			if(result>0) {
			System.out.println("성공");
			modelAndView.setViewName("redirect:./list.do");
		} else {
			modelAndView.setViewName("redirect:./add.do");
		}
		return modelAndView;
		}
		
		@RequestMapping (value="update.do", method=RequestMethod.GET)
		public void updateText(NoticeDTO noticeDTO, Model model) throws Exception{
			System.out.println("updateNotice");
			noticeDTO = noticeService.getDetail(noticeDTO);
			System.out.println(noticeDTO.getNum());
			model.addAttribute("updateText",noticeDTO);	
			
		}
		
		@RequestMapping (value="update.do", method=RequestMethod.POST)
		public ModelAndView updateText(NoticeDTO noticeDTO) throws Exception{
			System.out.println("update POST");
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("redirect:./update.do");
			int result = noticeService.updateNotice(noticeDTO);
			if(result>0) {
				System.out.println("성공");
				modelAndView.setViewName("redirect:./detail.do?num="+noticeDTO.getNum());
			}
			return modelAndView;
		}
		
		@RequestMapping (value="delete.do", method=RequestMethod.GET)
		public ModelAndView delete(NoticeDTO noticeDTO) throws Exception {
			System.out.println("deleteGet");
			ModelAndView modelAndView = new ModelAndView(); 
			int result = noticeService.deleteNotice(noticeDTO);
			System.out.println(result);
			if(result>0) {
				System.out.println("성공");
				modelAndView.setViewName("redirect:./list.do");
						}
			return modelAndView;
			
		}
		
		}

