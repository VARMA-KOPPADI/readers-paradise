package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.FileService;
import com.example.demo.model.ResponseMessage;

@RestController
public class FileController 
{

	@Autowired
	private FileService fileService;
	@PostMapping("/uploadfile")
	public ResponseEntity<ResponseMessage> uploadfile(@RequestParam MultipartFile file) throws IOException
	{
		System.out.println(file +"iiiiiiiiiioio");
		String uploadSingleFile = fileService.uploadSingleFile(file);
		
		return ResponseEntity.ok(new ResponseMessage(uploadSingleFile, file.getOriginalFilename()));
	}
	
}
