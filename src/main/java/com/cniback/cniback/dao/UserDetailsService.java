package com.cniback.cniback.dao;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {
	UserDetails loadUserByUsername(String username);
}
