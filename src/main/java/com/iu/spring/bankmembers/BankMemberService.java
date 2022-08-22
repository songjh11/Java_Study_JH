package com.iu.spring.bankmembers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankMemberService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	public int setJoin(BankMembersDTO bankMembersDTO ) throws Exception {
		return bankMembersDAO.setJoin(bankMembersDTO);
		}
		

		public List<BankMembersDTO> getSearchById(String search) throws Exception {
				return bankMembersDAO.getSearchById(search);
		}

		
		public Map<String, Object> getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
			Map<String, Object> map = new HashMap<String, Object>();
			List<BankMembersDTO> ar = bankMembersDAO.getMyPage(bankMembersDTO);
			map.put("list", ar);
			map.put("dto", bankMembersDTO);
			return map;
		}
	
	
	
	
}
