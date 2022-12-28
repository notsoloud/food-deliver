package com.food.delivery.app.ws.ui.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.food.delivery.app.ws.model.response.UserResponse;
import com.food.delivery.app.ws.service.UserService;
import com.food.delivery.app.ws.shared.dto.UserDto;

@RestController
public class AuthenticationController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/users/{email}", method = RequestMethod.GET)
	public UserResponse getUserByEmail(@PathVariable String email) {
		
		UserResponse returnValue = new UserResponse();
		
		UserDto user = userService.getUser(email);
		BeanUtils.copyProperties(user, returnValue);
		
		return returnValue;
	}
}
