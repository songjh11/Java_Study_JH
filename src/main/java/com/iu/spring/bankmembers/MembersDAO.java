package com.iu.spring.bankmembers;

import java.util.List;

public interface MembersDAO {
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception;
	
	public int setJoin(BankMembersDTO bankMembersDTO ) throws Exception;

	

	public List<BankMembersDTO> getSearchById(String search) throws Exception;
	
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception;
	
	public int setAddFile (BankMembersFileDTO bankMembersFileDTO) throws Exception;


}
