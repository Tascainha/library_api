package com.library.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.library.api.shared.services.JwtService;
import com.library.api.user.dtos.AuthenticateUserDTO;
import com.library.api.user.dtos.CreateUserDTO;
import com.library.api.user.responses.LoginResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtService jwtService;

	@PostMapping("/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody CreateUserDTO user) {
		return userService.createUser(user);
	}

	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public LoginResponse login(@RequestBody AuthenticateUserDTO user) {
		User authenticatedUser = userService.authenticateUser(user);
		String token = jwtService.generateToken(authenticatedUser);

		return new LoginResponse(token);
	}
}
