package com.iu.spring.bankmembers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		System.out.println("로그인 실행");
	}
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String login(HttpSession session, BankMembersDTO bankMembersDTO, Model model) throws Exception {
		bankMembersDTO = bankMemberService.getLogin(bankMembersDTO);
		session.setAttribute("member", bankMembersDTO);
		if(bankMembersDTO!=null) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
			return "redirect:./login.do";
		}
		return "redirect:../";
	}
	
	@RequestMapping(value = "join.do", method = RequestMethod.GET)
	public void join() {
		System.out.println("회원가입 실행");
		System.out.println("GET");
//		return "redirect:./join.do";
	}

	@RequestMapping(value="join.do", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("회원가입 실행");
		System.out.println("POST");
		int result = bankMemberService.setJoin(bankMembersDTO);
			if(result==1) {
				System.out.println("성공");
				} else {
				System.out.println("실패");
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
