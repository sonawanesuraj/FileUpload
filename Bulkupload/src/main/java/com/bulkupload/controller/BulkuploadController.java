package com.bulkupload.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bulkupload.entities.FileUploadEntity;
import com.bulkupload.repository.UserRepository;
import com.bulkupload.serviceInterface.FileServiceInterface;
import com.bulkupload.utils.ErrorResponseDto;
import com.bulkupload.utils.SuccessResponseDto;

@RestController
@RequestMapping("/users")
public class BulkuploadController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FileServiceInterface userServiceInterface;

	@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest reuest)
			throws IOException {

		FileUploadEntity fileUploadEntity = new FileUploadEntity();
		try {

			fileUploadEntity = this.userServiceInterface.storeFile(file, reuest);
		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorResponseDto("invalid file type", "invalid"), HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<>(new SuccessResponseDto("File upload Successfully", "File upload "), HttpStatus.OK);

	}
}
