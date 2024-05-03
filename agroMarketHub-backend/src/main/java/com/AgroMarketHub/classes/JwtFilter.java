package com.AgroMarketHub.classes;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.AgroMarketHub.serviceImpl.JwtServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@Component
@WebFilter
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtServiceImpl jwtServiceImpl;


	
	public JwtFilter(JwtServiceImpl jwtServiceImpl) {
		super();
		this.jwtServiceImpl = jwtServiceImpl;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (isAuthenticationRequestLogin(request)) {
			filterChain.doFilter(request, response);
			return;
		}

		if (isAuthenticationRequestReg(request)) {
			filterChain.doFilter(request, response);
			return;
		}

		String token = extractTokenFromRequest(request);

		if (token != null && jwtServiceImpl.validateToken(token)) {
			// Token is valid, continue with the filter chain
			filterChain.doFilter(request, response);
		} else {
			// Invalid token, send an unauthorized response
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token. Access denied.");
		}
	}

	private String extractTokenFromRequest(HttpServletRequest request) {
		String authorizationHeader = request.getHeader("Authorization");

		if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
			return authorizationHeader.substring(7); // Extracting the token after "Bearer "
		}
		return null;
	}

	private boolean isAuthenticationRequestLogin(HttpServletRequest request) {
		return request.getRequestURI().startsWith("/api/auth");
	}

	private boolean isAuthenticationRequestReg(HttpServletRequest request) {
		return request.getRequestURI().startsWith("/api/register");
	}

}
