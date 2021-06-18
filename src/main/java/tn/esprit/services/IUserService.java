package tn.esprit.services;

import tn.esprit.entities.User;

public interface IUserService {

	public int addUser(User user);

	public User deleteUser(int idUser);

	public int updateUser(User user);

	public User findUser(int idUser);

}
