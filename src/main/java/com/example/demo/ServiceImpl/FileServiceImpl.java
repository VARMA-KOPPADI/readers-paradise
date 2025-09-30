package com.example.demo.ServiceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Repo.FileRepo;
import com.example.demo.Service.FileService;
import com.example.demo.entity.FileEntity;

public class FileServiceImpl implements FileService {

	@Autowired
	private FileRepo filerepo;

	@Override
	public String uploadSingleFile(MultipartFile singlefile) throws IOException {
		@SuppressWarnings("static-access")
		FileEntity fileEntity = new FileEntity().builder().fileName(singlefile.getOriginalFilename())
				.filetype(singlefile.getContentType()).data(singlefile.getBytes()).build();
		FileEntity save = filerepo.save(fileEntity);
		return "file saved with the name ";
	}

}
