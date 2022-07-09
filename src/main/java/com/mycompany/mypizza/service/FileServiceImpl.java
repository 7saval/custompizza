package com.mycompany.mypizza.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileServiceImpl implements FileService {
	
	//자동주입(DI),이름,타입
	//root-context.xml의 정의된 bean주입
//	@Autowired
//	private String savedir;
	
	//application.properties의 환경설정값
	@Value("${file.savedir}")
	private String savedir;
	
	
	@Override
	public String fileUpload(MultipartFile file) throws Exception {

		String originFileName =file.getOriginalFilename();
		if (originFileName.equals("")) return "";
		String filename = System.currentTimeMillis() + "_"+ originFileName;
		
		//저장할 디렉토리 생성 
		if (!(new File(savedir).isDirectory())) { //경로가 없을경우 
			Files.createDirectory(Paths.get(savedir)); //경로명 path생성후 디렉토리 생성
		}
		
		//파일을 전송
		file.transferTo(new File(savedir, filename));
		
		return filename;
	}


	@Override
	public void fileDelete(String filename) throws Exception {
		// TODO Auto-generated method stub
		String savedirToday = savedir + "/20220519" ; 
//		File file = new File(savedirToday + "/" + filename);
//		if (file.isFile()) {
//			file.delete();
//		}
		
	}

	


}
