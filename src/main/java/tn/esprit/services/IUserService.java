package tn.esprit.services;

import tn.esprit.entities.User;

public interface IUserService {

	public int addUser(User user);

	public int deleteUser(int idUser);

	public int updateUser(User employe);

	public User findUser(int idUser);

}
