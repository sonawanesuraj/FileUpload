package com.bulkupload.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bulkupload.dto.IUserListDto;
import com.bulkupload.dto.UserDto;
import com.bulkupload.serviceInterface.UserServiceInterface;
import com.bulkupload.utils.ErrorResponseDto;
import com.bulkupload.utils.SuccessResponseDto;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceInterface userServiceInterface;

	@PostMapping()
	public ResponseEntity<?> addUser(@RequestBody UserDto userdto) {
		try {
			userdto = this.userServiceInterface.addUser(userdto);
			return new ResponseEntity<>(new SuccessResponseDto("User Added SuccessFully", "user Added", userdto),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponseDto("User Not Found", "Not found"), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> geUserById(@PathVariable Long id) {
		try {

			List<IUserListDto> userList = this.userServiceInterface.getUserById(id);
			return new ResponseEntity<>(new SuccessResponseDto("User fetch successfully", "Success", userList),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponseDto("user id not found", "not found"), HttpStatus.BAD_REQUEST);

		}
	}
}
