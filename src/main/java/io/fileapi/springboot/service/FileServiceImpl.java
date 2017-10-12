package io.fileapi.springboot.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.fileapi.springboot.entity.File;
import io.fileapi.springboot.repository.FileRepository;
import io.fileapi.springboot.utility.FileMetaDataUtility;
import io.fileapi.springboot.utility.SaveFileContentUtility;

@Service
@Transactional
public class FileServiceImpl implements FileService{
	
	@Autowired
	FileRepository fileRepository;
	
	@Autowired
	FileMetaDataUtility fileMetaDataUtility;
	

	@Override
	public File getFileById(int id) {
		return fileRepository.findOne(id);
	}

	@Override
	public List<File> getFiles() {
		return (List<File>) fileRepository.findAll();
	}

	@Override
	public File uploadFile(MultipartFile file) throws IOException{
		File newFile = fileMetaDataUtility.getFileMetaData(file);
		fileRepository.save(newFile);
		SaveFileContentUtility.saveFileData(file, newFile);
		return newFile;
		
	}

}
