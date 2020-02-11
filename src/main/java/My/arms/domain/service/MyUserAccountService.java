package My.arms.domain.service;

import org.springframework.security.core.userdetails.User;

public interface MyUserAccountService {

	User findOneByEmail(String username);
}

