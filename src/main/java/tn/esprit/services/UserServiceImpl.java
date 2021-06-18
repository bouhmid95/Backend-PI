package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.User;
import tn.esprit.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public int addUser(User user) {
		userRepository.save(user);
		return 0;// user.getId();
	}

	@Override
	public User deleteUser(int idUser) {
		User user = userRepository.findById(idUser).orElse(null);
		userRepository.delete(user);
		return user;
	}

	@Override
	public int updateUser(User user) {
		// User oldUser=userRepository.findById(user.getId()).orElse(null);
		// oldUser
		return 0;
	}

	@Override
	public User findUser(int idUser) {
		// TODO Auto-generated method stub
		return userRepository.findById(idUser).orElse(null);
	}

}
