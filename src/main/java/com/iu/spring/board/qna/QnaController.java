package com.iu.spring.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.spring.board.impl.BoardDTO;
import com.iu.spring.util.Pager;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "QnA";
	}
		
		@PostMapping("reply")
		public String setReply(QnaDTO qnaDTO) throws Exception{
			System.out.println(qnaDTO.getNum());
			int result = qnaService.setReply(qnaDTO);
			return "redirect:./list.do";
		}
		
		
		@GetMapping("reply")		
		public ModelAndView setReply(QnaDTO qnaDTO, ModelAndView view) throws Exception{
			view.setViewName("board/reply");
			view.addObject("boardDTO", qnaDTO);
			return view;
		}
	
		@RequestMapping (value="list.do", method=RequestMethod.GET)
		public ModelAndView getList(Pager pager) throws Exception {
			ModelAndView view = new ModelAndView();
			List<BoardDTO> ar = qnaService.getList(pager);
			view.addObject("list", ar);
			view.addObject("pager", pager);
			view.setViewName("board/list");
			return view; 
			}
		
		@RequestMapping(value="detail.do", method = RequestMethod.GET)
		public ModelAndView getDetail(BoardDTO boardDTO) throws Exception {
			ModelAndView view = new ModelAndView();
			qnaService.updateHit(boardDTO);
			boardDTO = qnaService.getDetail(boardDTO);
			view.addObject("boardDTO", boardDTO);
			view.setViewName("board/detail");
			return view;
		}
		
		@RequestMapping(value="add.do", method=RequestMethod.GET)
		public String setAdd() throws Exception {
			return "board/add";
		}
		
		@RequestMapping(value="add.do", method=RequestMethod.POST)
		public ModelAndView setAdd(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
			ModelAndView view = new ModelAndView();
			int result = qnaService.setAdd(boardDTO, files);
			view.setViewName("redirect:./list.do");
			return view;
		}
		
		@RequestMapping(value="update.do", method=RequestMethod.GET)
		public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView view) throws Exception {
			boardDTO = qnaService.getDetail(boardDTO);
			view.addObject("boardDTO", boardDTO);
			view.setViewName("board/update");
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
