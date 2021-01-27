package com.spring.component;

import java.util.Date;

import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {

	@Value("${app.jwtSecret}")
	private String jwtSecret;
	
	@Value("${app.jwtExpirationInMs}")
	private int jwtExpirationInMs;

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(JwtTokenProvider.class);
	
	public String generateToken(org.springframework.security.core.Authentication authentication) {
		User usuario = (User)authentication.getPrincipal();
		
		Date agora = new Date();
		
		Date dataDeExpiracao = new Date(agora.getTime() + jwtExpirationInMs);
		
		return Jwts.builder()
				.setSubject(usuario.getName())
				.setIssuedAt(agora)
				.setExpiration(dataDeExpiracao)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}
	
	public String getUserIdFromJWT(String token) {
		return Jwts.parser()
				.setSigningKey(jwtSecret)
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser()
				.setSigningKey(jwtSecret)
				.parseClaimsJws(token);
			return true;
		} catch (MalformedJwtException ex) {
			logger.error("Token Inválido");
		} catch (ExpiredJwtException ex) {
			logger.error("Token Expirado");
		} catch (UnsupportedJwtException ex) {
			logger.error("Token não Suportado");
		} catch (IllegalArgumentException ex) {
			logger.error("Token vazio");
		}
		return false;
	}
}
