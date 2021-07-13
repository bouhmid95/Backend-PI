package tn.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("select c from User c where c.username=:username")
	public User getUserByUsername(@Param("username") String username);

	@Query("select c from User c where c.userRole=:userRole")
	public List<User> getUserByRole(@Param("userRole") String userRole);

	@Query("select c from User c where c.username=:username and c.password=:password")
	public User getUserAutentificate(@Param("username") String username, @Param("password") String password);

	@Query("select c from User c where c.blocked=:isBlocked")
	public List<User> getLockedUsers(@Param("isBlocked") Boolean isBlocked);
	
	@Query("select c from User c where c.firstName=:firstName or c.lastName=:lastName")
	public User getUserByFirstNameOrLastname(@Param("firstName") String firstName,@Param("lastName") String lastName);
	
	
	@Query("select c.blocked,count(1) from User c group by c.blocked ")
	public List getLockUnlockUser();
}
