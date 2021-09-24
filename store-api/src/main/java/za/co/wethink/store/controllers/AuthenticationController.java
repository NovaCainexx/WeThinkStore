package za.co.wethink.store.controllers;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.wethink.store.models.LoginRequest;
import za.co.wethink.store.models.LoginResponse;
import za.co.wethink.store.models.Manager;
import za.co.wethink.store.models.Role;
import za.co.wethink.store.models.UserEntity;
import za.co.wethink.store.security.jwt.JwtUtils;
import za.co.wethink.store.service.UserRepositoryImpl;

/**
 * 
 * @author ebe
 *
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	private AuthenticationProvider authenticationProvider;

	@Autowired
	private UserRepositoryImpl userRepository;
	
	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("/logon")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		LOGGER.info("*** login request ***");
		
		Authentication authentication = authenticationProvider.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		LOGGER.info(MessageFormat.format("jwt {0}",jwt));
		
		UserEntity user = new UserEntity(loginRequest.getUsername(),jwt,transform(authentication.getAuthorities()));
		
		Manager userDetails = Manager.build(user);
		
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		LOGGER.info("*** completed logon ***");
		return ResponseEntity.ok(
				new LoginResponse(jwt, userDetails.getUsername(), roles));
	}
	
	private List<Role> transform(Collection<? extends GrantedAuthority> collection){
		return collection.
				stream().
				map(
						item -> new Role(item.getAuthority()))
				.collect(Collectors.toList());
	}
	
}
