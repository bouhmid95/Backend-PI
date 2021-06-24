package tn.esprit.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("select c from User c where c.username=:username")
	public User getUserByUsername(@Param("username") String username);

	@Query("select c from User c where c.username=:username and c.password=:password")
	public User getUserAutentificate(@Param("username") String username, @Param("password") String password);

}
