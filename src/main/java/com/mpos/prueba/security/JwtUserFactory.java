package com.mpos.prueba.security;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.mpos.prueba.enums.EStateProduct;
import com.mpos.prueba.models.Authority;
import com.mpos.prueba.models.User;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
    	boolean isEnabled = (user.isState() == EStateProduct.INACTIVE.getId() || user.isState() == EStateProduct.ELIMINATED.getId())? false:true;
        return new JwtUser(
                user.getId(),
                user.getFullName(),
                user.getUsername(),   
                user.getPassword(),
                user.getEmail(),
                user.getDateOfCreation(),
                user.getDateOfLastEntry(),
                user.getLastPasswordResetDate(),
                mapToGrantedAuthorities(user.getAuthorities()),
                isEnabled
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }
}
