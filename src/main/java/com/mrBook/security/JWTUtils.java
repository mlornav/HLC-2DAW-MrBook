package com.mrBook.security;

import java.util.Date;

import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtils {
	private static final String CLAVE_SECURITY = "puerta";
	private static final long DURACCION_TOKEN = 86400; //Duraccion de 1 dia
	
	public static String generarToken(Authentication authentication) {
		Date fechaActual = new Date();
		Date fechaExpediccion = new Date(fechaActual.getTime() + DURACCION_TOKEN);
		
		String username = authentication.getName();
		
		String token = Jwts.builder()
						.setSubject(username)
						.setIssuedAt(fechaActual)
						.setExpiration(fechaExpediccion)
						.signWith(SignatureAlgorithm.HS384, CLAVE_SECURITY)
						.compact();
		
		return token;
	}

}
