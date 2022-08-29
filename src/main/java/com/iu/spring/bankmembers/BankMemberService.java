package com.iu.spring.bankmembers;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	
	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo, ServletContext servletContext) throws Exception {
		
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		
		//1. HDD에 파일을 저장
		//파일 저장 시에 경로는 Tomcat 기준이 아니라 OS의 기준으로 설정
		
		//	1) 파일 저장 위치
		//		/resources/upload/member
		
		//	2) 저장할 폴더의 실제 경로 변환(OS기준)
		String realPath = servletContext.getRealPath("resources/upload/member");
		System.out.println("RealPath: "+realPath);
		
		//	3) 저장할 폴더의 정보를 가지는 자바 객체 생성
		File file = new File(realPath);
		
		//*File정보가 없을때 구분
		if(!photo.isEmpty()) {
			
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//	4) 중복되지 않는 파일명 생성
		//     -- 시간 또는 자바 api 이용
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+photo.getOriginalFilename();
		System.out.println(fileName);
		
		//시간 이용
		Calendar cal = Calendar.getInstance();
		Long time = cal.getTimeInMillis();
		fileName = time.toString();
		
		fileName = fileName+"_"+photo.getOriginalFilename();
		System.out.println(fileName);
		
		//	5) HDD에 파일 저장
		//사전 준비- 어느 폴더에 어떤 이름으로 저장할 File 객체 생성
		file = new File(file, fileName);
		
		//		- MultipartFile클래스의 transferTo 메서드 이용
		photo.transferTo(file);
		
		//      - FileCopyUtils 클래스의 copy 메서드 이용
		
		//2. 저장된 파일정보를 DB에 저장
		BankMembersFileDTO bankMembersFileDTO = new BankMembersFileDTO();
		bankMembersFileDTO.setFileName(fileName);
		bankMembersFileDTO.setOriName(photo.getOriginalFilename());
		bankMembersFileDTO.setUserName(bankMembersDTO.getUserName());
		bankMembersDAO.setAddFile(bankMembersFileDTO);
				
		}//isEmpty 끝
		return result;
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
