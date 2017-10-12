package io.fileapi.springboot.utility;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import io.fileapi.springboot.entity.File;

@Component
public class FileMetaDataUtility {
	
	private String uploadDirectory;
	
	public FileMetaDataUtility(@Value("${upload_directory}") String uploadDirectory) {
		this.uploadDirectory = uploadDirectory;
	}
	
	public File getFileMetaData(MultipartFile f) {
		
		File newFile = new File();
		
		newFile.setFileName(f.getOriginalFilename());
		newFile.setFilePath(uploadDirectory + f.getOriginalFilename());
		newFile.setFileType(f.getContentType());
		newFile.setFileSize((int)f.getSize());
		newFile.setUploadTime(LocalDateTime.now());
		
		return newFile;
	}

}
