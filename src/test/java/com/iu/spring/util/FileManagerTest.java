package com.iu.spring.util;

import static org.junit.Assert.*;

import javax.servlet.ServletContext;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.spring.MyAbstractTest;


public class FileManagerTest extends MyAbstractTest {

	//@Autowired
	private FileManager fileManager;
	
	@Autowired
	private ServletContext servletContext;
	
	@Test
	public void saveFilesTest() throws Exception {
		
//		fileManager.saveFiles("resources/upload/test");
		System.out.println("끝");
		
		
	}
	
}
