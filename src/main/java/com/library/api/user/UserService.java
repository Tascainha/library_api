package com.library.api.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.api.user.dtos.AuthenticateUserDTO;
import com.library.api.user.dtos.CreateUserDTO;

@Service
public class UserService {

		@Autowired
		private UserRepository userRepository;

		@Autowired
		private PasswordEncoder passwordEncoder;

		@Autowired
		private AuthenticationManager authenticationManager;

		public List<User> getAllUsers() {
				return userRepository.findAll();
		}

		public User createUser(CreateUserDTO dto) {
				User user = new User()
					.setEmail(dto.email())
					.setName(dto.name())
					.setPassword(passwordEncoder.encode(dto.password()));

				return userRepository.save(user);
		}

		public User authenticateUser(AuthenticateUserDTO dto) {
			authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.email(), dto.password())
			);
			return userRepository.findByEmail(dto.email()).orElseThrow();
		}

		public User getUserById(Long id) {
				return userRepository.findById(id).orElse(null);
		}

		public void deleteUser(Long id) {
				userRepository.deleteById(id);
		}
}
