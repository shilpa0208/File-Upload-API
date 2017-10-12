package io.fileapi;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import io.fileapi.springboot.FileUploadApiApplication;
import io.fileapi.springboot.entity.File;
import io.fileapi.springboot.service.FileService;

@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:application.properties")
@ContextConfiguration(classes={FileUploadApiApplication.class})
@WebAppConfiguration
public class FileUploadApiApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private FileService fileService;

	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testFileUpload() throws Exception{
		
		MockMultipartFile multipartFile = 
				new MockMultipartFile("test", "dummy.txt", "text/plain", "dummy".getBytes());
		
		File file = fileService.uploadFile(multipartFile);
		Assert.assertNotNull(file);
	}

	@Test
	public void testGetAllFiles() throws Exception{

		MockMultipartFile multipartFile = 
				new MockMultipartFile("test", "dummy.txt", "text/plain", "dummy".getBytes());

		fileService.uploadFile(multipartFile);

		List<File> files = fileService.getFiles();
		Assert.assertTrue(files.size()>0);

		File file = fileService.getFileById(files.get(0).getId());
		Assert.assertNotNull(file);

	}

	@Test
	public void testGetFileById() throws Exception{

		MockMultipartFile multipartFile = 
				new MockMultipartFile("test", "dummy.txt", "text/plain", "dummy".getBytes());
		fileService.uploadFile(multipartFile);

		List<File> files = fileService.getFiles();
		File file = fileService.getFileById(files.get(0).getId());

		Assert.assertNotNull(file);
	}

}