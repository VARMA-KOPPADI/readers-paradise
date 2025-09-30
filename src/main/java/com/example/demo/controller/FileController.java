package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.FileService;
import com.example.demo.model.ResponseMessage;

@RestController
public class FileController 
{

	@Autowired
	private FileService fileService;
	
	public ResponseEntity<ResponseMessage> uploadfile(@RequestBody MultipartFile file) throws IOException
	{
		String uploadSingleFile = fileService.uploadSingleFile(file);
		
		return ResponseEntity.ok(new ResponseMessage(uploadSingleFile, file.getOriginalFilename()));
	}
	
	
}
