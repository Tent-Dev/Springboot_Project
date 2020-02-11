package My.arms.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import My.arms.domain.entity.User;

@Repository
public interface MyUserRepository extends JpaRepository<User, Integer> {
	
	User  findOneByEmail(String email);
}

