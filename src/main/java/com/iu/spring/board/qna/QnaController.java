package com.iu.spring.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.spring.board.impl.BoardDTO;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
		@RequestMapping (value="list.do", method=RequestMethod.GET)
		public ModelAndView getList() throws Exception {
			ModelAndView view = new ModelAndView();
			List<BoardDTO> ar = qnaService.getList();
			view.addObject("list", ar);
			view.setViewName("qna/list");
			return view; 
			}
		
		@RequestMapping(value="detail.do", method = RequestMethod.GET)
		public ModelAndView getDetail(BoardDTO boardDTO) throws Exception {
			ModelAndView view = new ModelAndView();
			qnaService.updateHit(boardDTO);
			boardDTO = qnaService.getDetail(boardDTO);
			view.addObject("qnaDTO", boardDTO);
			view.setViewName("qna/detail");
			return view;
		}
		
		@RequestMapping(value="add.do", method=RequestMethod.GET)
		public String setAdd() throws Exception {
			return "qna/add";
		}
		
		@RequestMapping(value="add.do", method=RequestMethod.POST)
		public ModelAndView setAdd(BoardDTO boardDTO) throws Exception {
			ModelAndView view = new ModelAndView();
			int result = qnaService.setAdd(boardDTO);
			view.setViewName("redirect:./list.do");
			return view;
		}
		
		@RequestMapping(value="update.do", method=RequestMethod.GET)
		public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView view) throws Exception {
			view.addObject("qnaDTO", boardDTO);
			view.setViewName("qna/update");
			return view;
							}
		
		@RequestMapping(value="update.do", method=RequestMethod.POST)
		public String setUpdate(BoardDTO boardDTO) throws Exception {
			int result = qnaService.setUpdate(boardDTO);
			return "redirect:./detail.do?num="+boardDTO.getNum();
		}

		@RequestMapping(value="delete.do", method=RequestMethod.GET)
		public ModelAndView setDelete(BoardDTO boardDTO) throws Exception {
			ModelAndView view = new ModelAndView();
			int result = qnaService.setDelete(boardDTO);
			view.setViewName("redirect:./list.do");
			return view;
		}

}
