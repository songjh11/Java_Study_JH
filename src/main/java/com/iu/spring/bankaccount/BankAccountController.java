package com.iu.spring.bankaccount;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.spring.bankbook.BankBookDTO;
import com.iu.spring.bankmembers.BankMembersDTO;



@Controller
@RequestMapping(value="/bankAccount/*")
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccountService;
	
	
	
	@RequestMapping(value="add.do", method=RequestMethod.GET)
	public void setAc(BankAccountDTO accountDTO, HttpSession session) {
		System.out.println("setGet");
		BankBookDTO bankBookDTO = (BankBookDTO)session.getAttribute("one");
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member"); 
		accountDTO.setUserName(bankMembersDTO.getUserName());
		accountDTO.setBookNum(bankBookDTO.getBookNum());
		session.setAttribute("account", accountDTO);		
	}
	
	@RequestMapping(value="add.do", method=RequestMethod.POST)
	public ModelAndView setA (BankAccountDTO accountDTO) throws Exception {
		System.out.println("setPost");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./add.do");
		int result = bankAccountService.setAccount(accountDTO);
		if(result>0) {
			mv.setViewName("redirect:../");
			return mv;
		}
		return mv;
	}
	
}
