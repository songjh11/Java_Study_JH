package com.iu.spring.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.iu.spring.board.impl.BoardDTO;
import com.iu.spring.board.impl.BoardFileDTO;

public class AddFiles {

	@Autowired
	private ServletContext servletContext;
	
	public void addFiles(BoardDTO boardDTO, MultipartFile [] files, String search) throws Exception {
		
		for(MultipartFile mf: files) {
			if(mf.isEmpty()) {
				continue;
			} 
			String realPath = servletContext.getRealPath("resources/upload/"+search);
			System.out.println("realPath : "+realPath);
			
			File file = new File(realPath);
			
			System.out.println(file);

			if(!file.exists()) {
				file.mkdirs();
			}
	
			String fileName = UUID.randomUUID().toString();
			fileName = fileName+"_"+mf.getOriginalFilename();
			
			System.out.println(fileName);
			
			file = new File(file, fileName);
			System.out.println(file);
			
			mf.transferTo(file);
			
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(mf.getOriginalFilename());
//			noticeDAO.setAddFiles(boardFileDTO);
		}
		
	}
}
