package com.iu.spring.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.spring.board.impl.BoardDTO;

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
	public ModelAndView getList(@RequestParam(defaultValue = "1") Long page) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println("Page: "+page);
		
		List<BoardDTO> ar = noticeService.getList(page);
		modelAndView.addObject("list", ar);
		modelAndView.addObject("board", "Notice");
		modelAndView.setViewName("board/list");
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
	public String setAdd() throws Exception {
		return "board/add";
	}
	
	@RequestMapping(value="add.do", method=RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		int result = noticeService.setAdd(boardDTO);
		modelAndView.setViewName("redirect:./list.do");
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
}
