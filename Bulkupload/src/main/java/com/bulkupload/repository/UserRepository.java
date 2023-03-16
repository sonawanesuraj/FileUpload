package com.bulkupload.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bulkupload.dto.IUserListDto;
import com.bulkupload.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	List<IUserListDto> findById(Long id, Class<IUserListDto> class1);

}
