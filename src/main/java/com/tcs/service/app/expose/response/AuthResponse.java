package com.tcs.service.app.expose.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse implements Serializable {

	private static final long serialVersionUID = 9166074054324247552L;
	
	private String token;

}
