package io.fileapi.springboot.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import io.fileapi.springboot.entity.File;

public interface FileService {
	
	public File getFileById(int id);
	
	public List<File> getFiles(); 
	
	public File uploadFile(MultipartFile file) throws IOException;
	

}
