package com.mycompany.mypizza.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	
	//파일을 업로드 하고 파일명을 리턴
		String fileUpload(MultipartFile file) throws Exception;
		
		//파일 삭제
		void fileDelete(String filename) throws Exception;
}
