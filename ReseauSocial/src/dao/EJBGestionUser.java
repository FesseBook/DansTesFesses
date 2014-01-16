package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.bson.types.ObjectId;

import model.Post;
import model.User;

//@Stateless
public class EJBGestionUser {
	
	private UserDAO userDAO;
	private PostDAO postDAO;
	
//	public void creerUser(String name, String email, String password) {
//		User user = new User();
//		user.set_name(name);
//		user.set_email(email);
//		user.set_password(password);
//		userDAO.create(user);
//	}
//	
//	public User getUserByEmail(String email) {
//		return userDAO.findByEmail(email);
//	}
//	
//	public User getUserById(String id) {
//		return userDAO.findById(id);
//	}
//	
//	public boolean emailPasswordValid(String email, String password) {
//		return userDAO.emailPasswordValid(email, password);
//	}
//	
//	public List<User> recherche(String champRecherche) {
//		List<User> retour = null;
//		if (champRecherche.isEmpty()) {
//			retour = userDAO.findUsers();
//		} else {
//			retour.add(userDAO.findByLogin(champRecherche));
//		}
//		return retour;
//	}
//	
//	public List<User> getMyFriends(User user) {
//		int userId = Integer.valueOf(user.get_id().toString());
//		return userDAO.findByFriends(userId);
//	}
//	
//	public boolean areFriends(User userCourant, User userCourantFriend) {
//		return userDAO.areFriends(userCourant.get_id(), userCourantFriend.get_id()); // fonction qui est dans UserDAO_impl mais pas encore dans UserDAO
//	}

}
