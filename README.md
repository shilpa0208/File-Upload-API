# File-Upload-API

Simple RESTful web standalone application developed using Spring Boot.

## Technologies Used:
 * Spring Boot
 * Spring MVC
 * Spring Data JPA
 * RESTful Web Services
 * HSQL 
 * Maven
 
## Description:
File Upload API is a RESTful API in Spring Boot that is used to upload a file with a few meta data fields such as the file name, file type, file size, file path and upload date and time details. The file is saved in an in-memory database - HSQL and the content of the file is saved at the value specified in the application.properties file called upload_directory. Also, the size limit of the file can be changed at the application.properties file.

This API exposes the end points using the following URI's:

  * File API
  
  |Request Method   |         URI                 |         Description|
  |-----------------|-----------------------------|-------------------------------------------------|
  |    GET         |        /files               |        Gets all the files|
  |    GET         |        /files/{id}          |        Gets a particular file with the given id|
  |    POST        |        /files               |        Creates a new file|
     
## Steps to run:
 - Clone or download the project.
 - Change the file upload path(upload_directory) in the application.properties file under Resources.
 - Changed the file size according to your usage in the application.properties file under Resources.
 - Download Postman chrome plugin or any other REST client testing plugins to test the File Upload API.
 - Run the Spring Boot application in any IDE.
 - Select the file attribute in the body when doing a POST to select the file to upload. Set the key value as "uploadFile".
 - POST request will create a new file which was attached on the local system at the specified path. 
 - GET request on files will get all the files that were uploaded.

