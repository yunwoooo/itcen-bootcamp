package com.example.springlab.domain;

import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
@Getter
@AllArgsConstructor
public class FileVO1 {
	private MultipartFile uploadFile;	
}
