package My.arms.domain.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.User;

public class MyAccountUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	private User user;
	
	public MyAccountUserDetails(User user) {
		this.user = user;
	}//To return with user information, constructor with user should be added.

		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			Set<Role> userRoles = user.getRoles();
			for( Role role : userRoles ) {
				authorities.add(new SimpleGrantedAuthority(role.getRoleName())); 
			}
			return authorities;
		}

	
		// Get registered password
		@Override
		public String getPassword() {
			return user.getPassword();
		}
		
		@Override
		public String getUsername() {
			return user.getEmail();
		}


		// judge if account is within expiration date
		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		// judge if account is locked or not
		@Override
		public boolean isAccountNonLocked() {
			return true;
		}
		
		// judge credentials are within expiration date
		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}


		// judge if account is enabled or not
		@Override
		public boolean isEnabled() {
			return true;
		}



}
