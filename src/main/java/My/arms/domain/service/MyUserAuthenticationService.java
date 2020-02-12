package My.arms.domain.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import My.arms.domain.entity.Role;
import My.arms.domain.entity.User;
import My.arms.domain.repository.MyUserRepository;

@Service
public class MyUserAuthenticationService implements MyUserAccountService, UserDetailsService {

	// allows user information to be populated from Database
	// and then create UserDetails based on the user information.

	@Autowired
	private MyUserRepository userRepository;
	
	@Override
	public User findOneByEmail(String username) {
		return userRepository.findOneByEmail(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findOneByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		Set<GrantedAuthority> authorities = new HashSet<>();
		for (Role role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

}
