package com.iu.spring.bankmembers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.spring.bankaccount.BankAccountDTO;
import com.iu.spring.bankaccount.BankAccountService;
import com.iu.spring.bankmembers.BankMembersDTO;

@Controller
@RequestMapping (value="/members/*")
public class BankMemberController {
	
	@Autowired
	private BankMemberService bankMemberService;
//	@Autowired
//	private BankAccountService bankAccountService;
	
	@RequestMapping(value="ok.do", method=RequestMethod.GET)
	public void getOk(){
		System.out.println("okget");
	}
	
	@RequestMapping(value="ok.do", method=RequestMethod.POST)
	public ModelAndView getOkp() {
		System.out.println("okp");
		ModelAndView view = new ModelAndView(); 
		view.setViewName("redirect:./join.do");
		return view;
	}
	
	@RequestMapping (value="myPage.do", method=RequestMethod.GET)
	public ModelAndView myPage(HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
//		Map<String, Object> map = new HashMap<String, Object>();
//		map = bankMemberService.getMyPage(bankMembersDTO);
//		
//		mv.addObject("dto", map);
		
		bankMembersDTO = bankMemberService.getMyPage(bankMembersDTO);
		//List<BankAccountDTO> ar = bankAccountService.getList(bankMembersDTO);
		
		//mv.addObject("list", ar);
		mv.addObject("dto", bankMembersDTO);
		mv.setViewName("members/myPage");
		
		return mv;
	}

	@RequestMapping (value="logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		System.out.println("logout");
		session.invalidate();
		return "redirect:../";
	}
	
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public void login() {
		System.out.println("????????? ??????");
	}
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public ModelAndView login(HttpSession session, BankMembersDTO bankMembersDTO, Model model) throws Exception {
		ModelAndView view = new ModelAndView();
		bankMembersDTO = bankMemberService.getLogin(bankMembersDTO);
		session.setAttribute("member", bankMembersDTO);
		int result=0;
		String message = "????????? ??????";
		String url = "./login.do";
		if(bankMembersDTO!=null) {
			result = 1;
			message="????????? ??????";
			url = "../";
		}
		view.addObject("result", result);
		view.addObject("message", message);
		view.addObject("url", url);
		view.setViewName("common/result");
		
		return view;
	}
	
	@RequestMapping(value = "join.do", method = RequestMethod.GET)
	public void join() {
		System.out.println("???????????? ??????");
		System.out.println("GET");
//		return "redirect:./join.do";
	}

	@RequestMapping(value="join.do", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO, MultipartFile photo, HttpSession session) throws Exception {
		System.out.println("???????????? ??????");
		System.out.println("POST");
		System.out.println(photo.getOriginalFilename());

		int result = bankMemberService.setJoin(bankMembersDTO, photo, session.getServletContext());
			if(result==1) {
				System.out.println("??????");
				} else {
				System.out.println("??????");
					}
				return "redirect:./login.do";
	}
	
	
	@RequestMapping(value="search.do", method= RequestMethod.GET)
	public void getSearchById() {
		System.out.println("Search");
		}
	
	@RequestMapping(value="search.do", method= RequestMethod.POST)
	public ModelAndView getSearchById(String search, Model model) throws Exception {
		System.out.println("post");
		List<BankMembersDTO> ar = bankMemberService.getSearchById(search);
		model.addAttribute("list", ar);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/members/list");
		return mv;
	}

}
