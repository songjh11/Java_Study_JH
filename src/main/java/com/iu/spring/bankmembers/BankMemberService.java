package com.iu.spring.bankmembers;

import java.util.List;

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

	
	
	
	
}
