package com.bulkupload.serviceImpl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bulkupload.entities.FileUploadEntity;
import com.bulkupload.exception.FileStorageException;
import com.bulkupload.repository.FileUploadRepository;
import com.bulkupload.serviceInterface.FileServiceInterface;
import com.bulkupload.utils.FileStorageProperties;

@Service
public class FileServiceImpl implements FileServiceInterface {

	@Autowired
	FileUploadRepository fileUploadRepository;

	private Path fileStorageLocation;

	public void FileUploadImpl(FileStorageProperties fileStorageProperties) throws Exception {

		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {

			throw new FileStorageException("Could not create directory where uploaded file store ", ex);
		}

	}

	@Override
	public FileUploadEntity storeFile(MultipartFile file, HttpServletRequest request) throws Exception {
		try {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			if (fileName.contains("..")) {
				throw new FileStorageException("Filename contains invalid path sequence" + fileName);
			}

			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			FileUploadEntity fileUploadEntity = new FileUploadEntity();
			fileUploadEntity.setEncoding(request.getCharacterEncoding());
			fileUploadEntity.setFilename(fileName);
			fileUploadEntity.setMimetype(file.getContentType());
			fileUploadEntity.setOriginalName(file.getOriginalFilename());
			fileUploadEntity.setSize(file.getSize());
			FileUploadEntity fileDetail = fileUploadRepository.save(fileUploadEntity);
			return fileDetail;
		} catch (Exception ex) {

			throw new FileStorageException("Could not store file");

		}

	}

}
