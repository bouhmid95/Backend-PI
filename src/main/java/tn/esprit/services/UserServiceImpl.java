package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.entities.User;
import tn.esprit.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public int addUser(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
	userRepository.save(user);
	return user.getId();}

	@Override
	public User deleteUser(int idUser) {
		User user = userRepository.findById(idUser).orElse(null);
		userRepository.delete(user);
		return user;
	}

	@Override
	public int updateUser(User user) {
		User oldUser = userRepository.findById(user.getId()).orElse(null);
		oldUser.setFirstName(user.getFirstName());
		oldUser.setLastName(user.getLastName());
		oldUser.setEmail(user.getEmail());
		oldUser.setUsername(user.getUsername());
		oldUser.setPassword(user.getPassword());
		oldUser.setUserRole(user.getUserRole());
		userRepository.save(oldUser);
		return 0;
	}

	@Override
	public User findUser(int idUser) {
		// TODO Auto-generated method stub
		return userRepository.findById(idUser).orElse(null);
	}

}
