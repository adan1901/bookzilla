package com.bookzilla.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by adinu on 12/4/16.
 */
public interface SecurityService {

    String findLoggedInUserName();

    UserDetails findLoggedInUser();

    Authentication getAuthenticationContext();

    void updateUserRole(Authentication authentication, GrantedAuthority authority);

}
