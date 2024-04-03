package com.descomplica.FrameBlog.services;

import com.descomplica.FrameBlog.request.AuthRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthenticationService extends UserDetailsService{

    String getToken(AuthRequest auth);

    String validateJwtToken(String token);
}
