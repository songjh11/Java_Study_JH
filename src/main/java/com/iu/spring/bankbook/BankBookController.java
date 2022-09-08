package com.iu.spring.bankbook;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iu.spring.util.CommentPager;



@Controller
@RequestMapping (value="/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@PostMapping("commentDelete")
	@ResponseBody
	public int setDeleteComment(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		System.out.println("delete");
		int result = bankBookService.setDeleteComment(bankBookCommentDTO);
		return result;
	}
	
	@PostMapping("commentUpdate")
	@ResponseBody
	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		System.out.println("update");
		System.out.println(bankBookCommentDTO.getNum());
		System.out.println(bankBookCommentDTO.getContents());
		int result = bankBookService.setCommentUpdate(bankBookCommentDTO);
		return result;
	}
	
	@GetMapping("commentList")
	@ResponseBody
	public Map<String, Object> getCommentList(CommentPager commentPager) throws Exception {
		System.out.println("CommentList");
		System.out.println(commentPager.getBookNum());
		ModelAndView mv = new ModelAndView();
		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
		System.out.println(ar.size());		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", ar);
		map.put("pager", commentPager);
		
		return map;
	}
	
	
	@PostMapping ("commentAdd")
	@ResponseBody
	public String setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		int result = bankBookService.setCommentAdd(bankBookCommentDTO);
		modelAndView.addObject("result", result);
		modelAndView.setViewName("common/ajaxResult");
		String jsonResult = "{\"result\":\""+result+"\"}";
		return jsonResult;
	}
	
	@RequestMapping (value = "list.do", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		System.out.println("List");
		List<BankBookDTO> ar = bankBookService.getList();
		model.addAttribute("list", ar);
	}
	
	@RequestMapping (value = "detail.do", method = RequestMethod.GET)
	public ModelAndView getDetail(BankBookDTO bankBookDTO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("Detail");
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		session.setAttribute("one", bankBookDTO);
		mv.setViewName("bankbook/detail");
		return mv;
	}
	
	@RequestMapping (value = "add.do", method= RequestMethod.GET)
	public void addBook(Model model) {
		System.out.println("add GET");
		BankBookDTO bankBookDTO = new BankBookDTO();
		Calendar cal = Calendar.getInstance();
		bankBookDTO.setBookNum((Long)cal.getTimeInMillis());
		System.out.println(bankBookDTO.getBookNum());
		model.addAttribute("add", bankBookDTO);
	}
	
	@RequestMapping (value = "add.do", method = RequestMethod.POST)
	public ModelAndView addBook(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("add POST");
		int result = bankBookService.setBook(bankBookDTO);
		if(result==1) {
			System.out.println("계좌 추가 성공");
		}
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("redirect:./list.do");		
		return mv;
	}
	
	@RequestMapping (value="update.do", method= RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model) throws Exception {
		System.out.println("update GET");
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		System.out.println(bankBookDTO.getBookNum());
		model.addAttribute("update",bankBookDTO);	
	}
	
	@RequestMapping (value="update.do", method=RequestMethod.POST)
	public ModelAndView update(BankBookDTO bankBookDTO) throws Exception  {
		System.out.println("update POST");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:./update.do");
		int result = bankBookService.setUpdate(bankBookDTO);
		if(result>0) {
			System.out.println("성공");
			modelAndView.setViewName("redirect:./detail.do?bookNum="+bankBookDTO.getBookNum());
		}
		return modelAndView;
	}

	@RequestMapping (value="delete.do", method=RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("delete");
		ModelAndView modelAndView = new ModelAndView(); 
		int result = bankBookService.deleteBook(bankBookDTO);
		System.out.println(result);
		if(result>0) {
			System.out.println("성공");
			modelAndView.setViewName("redirect:./list.do");
					}
		return modelAndView;
		
	}

}
