package com.mrBook.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrBook.entity.ActorLogin;
import com.mrBook.security.JWTUtils;

@RestController
public class ActorController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/login")
	public Map<String, String> login (@RequestBody ActorLogin actorLogin) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(
						actorLogin.getUsername(), actorLogin.getPassword()));
		
		String token = JWTUtils.generarToken(authentication);
		
		Map<String, String> res = null;
		res.put("token", token);
		
		return res;
	}
}
