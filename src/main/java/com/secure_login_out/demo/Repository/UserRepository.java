package com.secure_login_out.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.secure_login_out.demo.Model.User;
public interface UserRepository extends JpaRepository<User,Integer> {
	public boolean existsByEmail(String email);	
	public User findByEmail(String email);
}
