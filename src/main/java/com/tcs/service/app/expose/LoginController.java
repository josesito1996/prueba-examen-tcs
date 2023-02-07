package com.tcs.service.app.expose;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.service.app.business.UserService;
import com.tcs.service.app.config.JWTUtil;
import com.tcs.service.app.config.SecretPasswordEncoder;
import com.tcs.service.app.exception.NotAuthorizedException;
import com.tcs.service.app.expose.request.AuthRequest;
import com.tcs.service.app.expose.response.AuthResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/api-auth")
public class LoginController {

	private JWTUtil jwtUtil;

	private SecretPasswordEncoder secretPasswordEncoder;

	private UserService userService;

	@GetMapping("/test")
	public String getToken(@RequestParam String token) {
		return jwtUtil.getUsernameFromToken(token);
	}
	
	@PostMapping("/login")
	public Mono<ResponseEntity<AuthResponse>> login(@Valid @RequestBody AuthRequest authRequest) {
		return userService.findByUsername(authRequest.getUserName())
				.filter(
				userDetail -> secretPasswordEncoder.encode(authRequest.getPassword())
					.equals(userDetail.getPassword()))
				.map(userDetail -> {
					return ResponseEntity
							.ok(new AuthResponse(jwtUtil.generateToken(userDetail)));
				})
				.switchIfEmpty(Mono.error(new NotAuthorizedException("Usuario Incorrecto !!!")));
	}

}
