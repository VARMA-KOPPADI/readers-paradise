package com.example.demo.Service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	public String uploadSingleFile(MultipartFile singlefile) throws IOException;
}
