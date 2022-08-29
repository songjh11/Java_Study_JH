package com.iu.spring.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.iu.spring.board.impl.BoardDTO;
import com.iu.spring.board.impl.BoardFileDTO;

//FileManager 객체를 생성하려면 @을 주거나 xml에 bean객체를 줘야 사용 가능

@Component
public class FileManager {

	//@Autowired//->주입을 하는거지 객체를 만드는게 아님
	//private ServletContext servletContext;
	
//	@ 사용하기
//	매개변수로 받기
	
	
	//save MultipartFile [] files, 
	public String saveFiles(String path, ServletContext servletContext, MultipartFile files) throws Exception {
		
		//1. 실제 경로
		String realPath = servletContext.getRealPath(path);
		System.out.println("realPath : "+realPath);
		
		//2.폴더 체크
		File file = new File(realPath);

			if(!file.exists()) {
				file.mkdirs();
			}
	
			String fileName = UUID.randomUUID().toString();
			fileName = fileName+"_"+files.getOriginalFilename();
			
			file = new File(file, fileName);
			
			files.transferTo(file);
			
			System.out.println("저장");
			
		return fileName;
	}
}
