package My.arms.domain.service;

import My.arms.domain.entity.User;

public interface MyUserAccountService {

	User findOneByEmail(String username);
}

