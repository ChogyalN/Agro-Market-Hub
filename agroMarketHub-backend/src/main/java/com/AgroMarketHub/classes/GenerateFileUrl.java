package com.AgroMarketHub.classes;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class GenerateFileUrl {
	
	public String generateURL(MultipartFile file) {
		
		String fileName = file.getOriginalFilename();
		String randomUUID = UUID.randomUUID().toString();
		String uuid = randomUUID.replace("-", "");
		String filePathPrefix = "D:/file_upload";
		Calendar calendar = Calendar.getInstance();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM");
		String urlAppender = "/"+ calendar.get(Calendar.YEAR) + "/" + dateFormat.format(calendar.getTime()) + "/" + calendar.get(Calendar.DATE)+ "/";
		String filePath = filePathPrefix + urlAppender + uuid + "_"+ fileName;
		File fileloc = new File(urlAppender);
		if(!fileloc.exists()){
			new File(filePathPrefix + urlAppender).mkdirs();
		}
		
		return filePath;
	}

}
