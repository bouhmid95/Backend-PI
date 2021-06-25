package tn.esprit.services;

import java.util.Date;
import java.util.Random;

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
		Random random = new Random();
		user.setConfirmCode(String.valueOf(random.nextInt(10000000)));
		user.setConfirmed(false);
		userRepository.save(user);
		return user.getId();
	}

	public User confirmUser(String username, String confirmCode) {
		User user = userRepository.getUserByUsername(username);
		if (user != null && confirmCode.equals(user.getConfirmCode())) {
			user.setConfirmed(true);
			userRepository.save(user);
			return user;
		} else
			return null;
	}


	public User autentificateUser(String username, String password) {
		User user = userRepository.getUserAutentificate(username, new BCryptPasswordEncoder().encode(password));
		if (user != null && user.getIsConfirmed() && !user.getIsBlocked())
			return user;
		User userWithWrongPass = userRepository.getUserByUsername(username);

		if (userWithWrongPass != null) {
			userWithWrongPass.setWrongPassword(userWithWrongPass.getWrongPassword() + 1);
			if (userWithWrongPass.getWrongPassword() >= 3) {
				userWithWrongPass.setBlocked(true);
				userWithWrongPass.setBlockedDate(new Date());
			}
			userRepository.save(userWithWrongPass);
			return null;
		} else
			return null;
	}

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
