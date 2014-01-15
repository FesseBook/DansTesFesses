package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.bson.types.ObjectId;

import model.Post;
import model.User;

@Stateless
public class EJBGestionUser {
	
	private UserDAO_impl userDAO;
	private PostDAO_impl postDAO;
	
	public void creerUser(String name, String email, String password) {
		User user = new User();
		user.set_name(name);
		user.set_email(email);
		user.set_password(password);
		userDAO.create(user);
	}
	
<<<<<<< HEAD
	public User getUserByLogin(String login) {
		return userDAO.findOneByLogin(login);
	}
	
	public User getUserByEmail(String email) {
		return userDAO.findByEmail(email);
	}
	
	public boolean identifiantsValides(String login, String password) {
		return userDAO.identifiantsValides(login, password);
	}
	
	public List<Post> getPostsTouslesAmis(User user) {
		ArrayList<ObjectId> amisIds = user.get_myFriends();
		return postDAO.getPostsUsers(amisIds);
	}
	
	public User findById(int id) {
		return userDAO.findOneById(id);
	}
	
	public List<User> recherche(String champRecherche) {
		List<User> retour = null;
		if (champRecherche.isEmpty()) {
			retour = userDAO.findUsers();
		} else {
			retour = new ArrayList<User>();
			retour.add(userDAO.findOneByLogin(champRecherche));
		}
		return retour;
	}

=======
//	public User getUserByLogin(String login) {
//		return userDAO.findOneByLogin(login);
//	}
//	
//	public boolean identifiantsValides(String login, String password) {
//		return userDAO.identifiantsValides(login, password);
//	}
//	
//	public List<Post> getPostsAmis(User user) {
//		ArrayList<ObjectId> amisIds = user.get_myFriends();
//		return postDAO.getPostsUsers(amisIds);
//	}
//	
//	public User findById(int id) {
//		return userDAO.findOneById(id);
//	}
>>>>>>> 0855835561b6072b4a9b1c8ad83756d6bf2550e8
}
