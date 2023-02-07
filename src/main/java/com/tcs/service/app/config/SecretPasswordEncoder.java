package com.tcs.service.app.config;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tcs.service.app.exception.InternalErrorException;

@Component
public class SecretPasswordEncoder implements PasswordEncoder {

	@Value("${spring-security.jwt.password.encoder.secret}")
	private String secret;

	@Value("${spring-security.jwt.password.encoder.iteration}")
	private Integer iteration;

	@Value("${spring-security.jwt.password.encoder.key-length}")
	private Integer keylength;

	@Override
	public String encode(CharSequence rawPassword) {
		try {
			byte[] result = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512").generateSecret(
					new PBEKeySpec(rawPassword.toString().toCharArray(), secret.getBytes(), iteration, keylength))
					.getEncoded();
			return Base64.getEncoder().encodeToString(result);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
			throw new InternalErrorException(ex.getMessage());
		}
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {

		 return encode(rawPassword).equals(encodedPassword);
	}

}
