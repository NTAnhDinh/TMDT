package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByName(String name);

	User findByPassword(String password);
	@Query("select u from User u where id_role <>3 ")
	List<User> findByIdRole();

	@Modifying
	@Query("update User u set u.password =:password where u.id_user =:userId")
	void updatePassword(@Param("password") String password, @Param("userId") int userId);
}
