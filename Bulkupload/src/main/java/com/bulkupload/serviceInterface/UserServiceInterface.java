package com.bulkupload.serviceInterface;

import java.util.List;

import com.bulkupload.dto.IUserListDto;
import com.bulkupload.dto.UserDto;

public interface UserServiceInterface {

	public UserDto addUser(UserDto userDto);

	List<IUserListDto> getUserById(Long id);

}
