package io.fileapi.springboot.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.fileapi.springboot.entity.File;
import io.fileapi.springboot.exception.InvalidInputException;
import io.fileapi.springboot.service.FileService;

@RestController
public class FileController {
	
	@Autowired
	FileService fileService;
	
	//Get file by Id
	@RequestMapping(value="/files/{id}", method = RequestMethod.GET) 
	public File getFileById(@PathVariable("id") final int id, HttpServletResponse response) throws InvalidInputException{
		File temp = fileService.getFileById(id);
		if(temp==null) {
			throw new InvalidInputException(id);
		}
		return temp;
	}
	
	//Get all files
	@RequestMapping(value="/files", method=RequestMethod.GET)
	public List<File> getAllFiles(HttpServletResponse response) {
		List<File> files = fileService.getFiles();
		if(files == null || files.size() == 0){
			response.setStatus(HttpStatus.NO_CONTENT.value());
		}else{
			response.setStatus(HttpStatus.OK.value());
		}
		return files;
	}
	
	//Create a file
	@RequestMapping(value="/files", method=RequestMethod.POST)
	public int uploadFile(@RequestParam(value="uploadFile", required = false) MultipartFile file, HttpServletResponse response) throws IOException {
		File createdfile = fileService.uploadFile(file);
		response.setStatus(HttpStatus.CREATED.value());
		return createdfile.getId();
	}
	

}
