package com.iu.spring.qna;

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
@RequestMapping (value="/qna/*")
public class QnAController {
	
	@Autowired
	private QnAService qnAService;
	
	@RequestMapping (value="list.do", method=RequestMethod.GET)
	public void getNoticeList(HttpSession session) throws Exception {
		System.out.println("GetList");
		List<QnADTO> ar = qnAService.getList();
		session.setAttribute("qList", ar);
		
	}
	
	@RequestMapping (value="detail.do", method=RequestMethod.GET)
	public void getQna(QnADTO qnaDTO, HttpSession session) throws Exception {
		qnAService.updateHit(qnaDTO);
		qnaDTO = qnAService.getDetail(qnaDTO);
		session.setAttribute("qText", qnaDTO);
	}
		
		@RequestMapping (value="set.do", method=RequestMethod.GET)
		public void addQna() throws Exception {
			System.out.println("add");
			
		}

		@RequestMapping(value="set.do", method=RequestMethod.POST)
		public ModelAndView addQna(QnADTO qnaDTO) throws Exception {
			System.out.println("addQNAPost");
			int result = qnAService.setQnA(qnaDTO);
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
		public void updateText(QnADTO qnaDTO, Model model) throws Exception{
			System.out.println("update");
			qnaDTO = qnAService.getDetail(qnaDTO);
			model.addAttribute("updateQ", qnaDTO);	
			
		}
		
		@RequestMapping (value="update.do", method=RequestMethod.POST)
		public ModelAndView updateText(QnADTO qnaDTO) throws Exception{
			System.out.println("update POST");
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("redirect:./update.do");
			int result = qnAService.updateQnA(qnaDTO);
			if(result>0) {
				System.out.println("성공");
				modelAndView.setViewName("redirect:./detail.do?num="+qnaDTO.getNum());
			}
			return modelAndView;
		}
		
		@RequestMapping (value="delete.do", method=RequestMethod.GET)
		public ModelAndView delete(QnADTO qnaDTO) throws Exception {
			System.out.println("deleteGet");
			ModelAndView modelAndView = new ModelAndView(); 
			int result = qnAService.deleteQnA(qnaDTO);
			System.out.println(result);
			if(result>0) {
				System.out.println("성공");
				modelAndView.setViewName("redirect:./list.do");
						}
			return modelAndView;
			
		}
		
		}

