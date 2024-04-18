package br.hackathan.com.hackathan.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import br.hackathan.com.hackathan.Util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthFilter extends OncePerRequestFilter {

    private final CustomUserDetailsService customUserDatails;

    public AuthFilter(CustomUserDetailsService customUserDatails) {
        this.customUserDatails = customUserDatails;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        String username = JwtUtil.getUsernameToken(authorization);
        System.out.println(request.getRequestURI());
        if(request.getRequestURI().contains("/auth")) {
            System.out.println("Login");
            filterChain.doFilter(request, response);
            return;
        }
        if (authorization == null) {
            System.out.println("Sem token");
            response.sendError(401);
            return;
        } else if(JwtUtil.isTokenExpirado(authorization)){
            System.out.println("Token expirado");
            response.sendError(419);
            return;
        } else {
            if(SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails user = customUserDatails.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);
}
    
}
