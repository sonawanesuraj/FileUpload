package com.bulkupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bulkupload.entities.FileUploadEntity;

public interface FileUploadRepository extends JpaRepository<FileUploadEntity, Long> {

}
