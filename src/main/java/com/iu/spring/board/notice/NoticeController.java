package com.iu.spring.board.notice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.iu.spring.bankmembers.BankMembersDTO;
import com.iu.spring.board.impl.BoardDTO;
import com.iu.spring.util.Pager;

@Controller
@RequestMapping (value="/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "Notice";
	}
	
	//글 목록
	@RequestMapping(value="list.do", method=RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(pager.getPage());
//		System.out.println("Page: "+page);
//		
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		
		List<BoardDTO> ar = noticeService.getList(pager);
		modelAndView.addObject("list", ar);
		modelAndView.addObject("pager", pager);
		modelAndView.setViewName("board/list");
		
		if(ar.size() !=0) {
			throw new Exception();
		}
		
		return modelAndView;
	}
	
	//글 상세
	@RequestMapping (value="detail.do", method=RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception{
		noticeService.updateHit(boardDTO);
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/detail";
	}
		
	//글 작성
	@RequestMapping(value="add.do", method=RequestMethod.GET)
	public String setAdd(HttpSession httpSession) throws Exception {
		BankMembersDTO bankMembersDTO = (BankMembersDTO)httpSession.getAttribute("member");
		if(bankMembersDTO != null) {
			return "board/add";
		} else {
			return "redirect:../members/login.do";
		}
	}
	
	@RequestMapping(value="add.do", method=RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO, MultipartFile [] files, HttpSession session) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		int result = noticeService.setAdd(boardDTO, files, session.getServletContext());
		String message = "등록 실패";
		String url = "./board/add";
		if(result>0) {
			message="등록 완료";
			url="./list.do";
		}
		modelAndView.addObject("result", result);
		modelAndView.addObject("message", message);
		modelAndView.addObject("url", url);
		modelAndView.setViewName("common/result");
		return modelAndView;
	}
	
	//글 수정
	@RequestMapping (value="update.do", method=RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
		mv.addObject("board", "Notice");
		mv.setViewName("board/update");
		return mv;
			}
	
	@RequestMapping (value="update.do", method=RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception{
		int result = noticeService.setUpdate(boardDTO);
		return "redirect:./detail.do?num="+boardDTO.getNum();
			}
		
	//글 삭제
	@RequestMapping(value="delete.do")
	public String setDelete(BoardDTO boardDTO) throws Exception{
		int result = noticeService.setDelete(boardDTO);
		return "redirect:./list.do";
		
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView exceptionTest() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("errors/error_404");
		return modelAndView; 
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionTest2(Exception e) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("errors/error_404");
		return modelAndView; 
	}
}
