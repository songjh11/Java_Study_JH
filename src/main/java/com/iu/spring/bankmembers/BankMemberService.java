package com.iu.spring.bankmembers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.spring.bankaccount.BankAccountDTO;
import com.iu.spring.bankaccount.BankAccountService;

@Service
public class BankMemberService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	@Autowired
	private BankAccountService bankAccountService;

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	public int setJoin(BankMembersDTO bankMembersDTO ) throws Exception {
		return bankMembersDAO.setJoin(bankMembersDTO);
		}
		

		public List<BankMembersDTO> getSearchById(String search) throws Exception {
				return bankMembersDAO.getSearchById(search);
		}

		
//		public Map<String, Object> getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
//			Map<String, Object> map = new HashMap<String, Object>();
//			bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
//			List<BankAccountDTO> ar = bankAccountService.getList(bankMembersDTO); 
//			map.put("list", ar);
//			map.put("dto", bankMembersDTO);
//			return map;
//		}
	
		public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception{
			return bankMembersDAO.getMyPage(bankMembersDTO);
		}
		
	
	
	
}
