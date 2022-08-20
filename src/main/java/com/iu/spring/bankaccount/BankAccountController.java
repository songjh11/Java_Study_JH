package com.iu.spring.bankaccount;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value="/bankAccount/*")
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccountService;
	
	
	
	@RequestMapping(value="add.do", method=RequestMethod.GET)
	public void setAc() {
		System.out.println("setGet");
		
	}
	
	@RequestMapping(value="add.do", method=RequestMethod.POST)
	public void setA (BankAccountDTO accountDTO) throws Exception {
		int result = bankAccountService.setAccount(accountDTO);
		
	}
	
}
