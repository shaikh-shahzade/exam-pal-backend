package com.exampal.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestToken = request.getHeader("Authorization");
		String token , username=null;
		if(requestToken!=null && requestToken.startsWith("Bearer"))
		{
			token = requestToken.substring(7);
			try {
				username = jwtUtil.getUsernameFromToken(token);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			if(username!=null&&SecurityContextHolder.getContext().getAuthentication()==null)
			{
				UserDetails userDetails= userDetailsService.loadUserByUsername(username);
				if(this.jwtUtil.validateToken(token, userDetails))
				{
					UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(username, userDetails);
					upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(upat);
					
				}
				
			}
		}
		filterChain.doFilter(request, response);
	}

}
