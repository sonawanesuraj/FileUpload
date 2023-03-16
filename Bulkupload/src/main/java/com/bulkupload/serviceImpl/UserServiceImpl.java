package com.bulkupload.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bulkupload.dto.IUserListDto;
import com.bulkupload.dto.UserDto;
import com.bulkupload.entities.UserEntity;
import com.bulkupload.repository.UserRepository;
import com.bulkupload.serviceInterface.UserServiceInterface;

@Service
public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto addUser(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(userDto.getName());
		userEntity.setEmail(userDto.getEmail());
		userEntity.setGender(userDto.getGender());
		userRepository.save(userEntity);
		return userDto;
	}

	@Override
	public List<IUserListDto> getUserById(Long id) {
		List<IUserListDto> iUserListDto;
		return iUserListDto = this.userRepository.findById(id, IUserListDto.class);
	}

}
