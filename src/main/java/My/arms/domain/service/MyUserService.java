package My.arms.domain.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import My.arms.domain.entity.User;
import My.arms.domain.repository.MyUserRepository;

public class MyUserService {
	@Autowired
	MyUserRepository userRepository;
	
	public Page<User> getAllUsers(Pageable pageable){
		return userRepository.findAll(pageable);
	}
}
