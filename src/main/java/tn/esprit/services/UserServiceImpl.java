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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int idUser) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User employe) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findUser(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
