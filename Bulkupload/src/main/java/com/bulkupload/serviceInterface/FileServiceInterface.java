package com.bulkupload.serviceInterface;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.bulkupload.entities.FileUploadEntity;

public interface FileServiceInterface {

	FileUploadEntity storeFile(MultipartFile file, HttpServletRequest request) throws Exception;

}
