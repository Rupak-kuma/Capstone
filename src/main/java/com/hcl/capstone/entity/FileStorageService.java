package com.hcl.capstone.entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.multipart.MultipartFile;

public class FileStorageService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	private final Path root = Paths.get("src/main/resources/static");
	public void save(MultipartFile file) {
		try {
		Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
		String url="http://localhost:8083/"+file.getOriginalFilename();
		addFile(url);
		
	}
		catch(IOException e) {
			throw new RuntimeException("Could not store the file "+e.getMessage());
		}

	}
	
public Boolean addFile(String url) {
  String sql = "insert into image values(?,?,?)";
  jdbcTemplate.update(sql,url);
  return true;
}
}
/*public FileDB store(MultipartFile file) throws IOException {
  String fileName = StringUtils.cleanPath(file.getOriginalFilename());
  FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());

  return fileDBRepository.save(FileDB);
}*/

//public FileDB getFile(String id) {
  //return fileDBRepository.findById(id).get();
//}

//public Stream<FileDB> getAllFiles() {
  //return fileDBRepository.findAll().stream();
//}