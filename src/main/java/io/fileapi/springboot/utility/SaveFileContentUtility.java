package io.fileapi.springboot.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

import io.fileapi.springboot.entity.File;

public class SaveFileContentUtility {
	
	public static void saveFileData(MultipartFile file, File f) throws IOException {
		//Convert the file data into byte to save to a file on the local file system
		byte[] data = file.getBytes();
		Path path = Paths.get(f.getFilePath());
		Files.write(path, data);
				
	}

}
