package api.soccer.security;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import api.soccer.management.model.NguoiChoi;

public class UserDetail implements UserDetails {
	private Collection<? extends GrantedAuthority> authorities; 
	private String password;
	private String username;

	public UserDetail(NguoiChoi player) {
		this.username = player.getUsername();
		this.password = player.getPassword();
		this.authorities = translate(player);
	}
	private Collection<? extends GrantedAuthority> translate(NguoiChoi player) { 
		List<GrantedAuthority> authorities = new ArrayList<>(); 
			String name = player.getRole().toUpperCase(); 
			if (!name.startsWith("ROLE_")) { 
				name = "ROLE_" + name; 
			} 
			authorities.add(new SimpleGrantedAuthority(name)); 
		return authorities; 
	} 

	@Override
	public String toString() {
		return "UserDetail [authorities=" + authorities + ", password=" + password + ", username=" + username + "]";
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

}
