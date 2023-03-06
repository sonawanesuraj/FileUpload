package com.bulkupload.repository;

import java.io.File;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bulkupload.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	void save(File uploadedFile);

}
