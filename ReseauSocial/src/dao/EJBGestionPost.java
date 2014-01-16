package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import org.bson.types.ObjectId;

import model.Post;
import model.PostJSP;
import model.User;
import model.UserJSP;
import model.UserJSPSansAmis;

@Stateless
public class EJBGestionPost {

	private UserDAO userDAO;
	private PostDAO postDAO;
	
	public List<Post> getPostsUnAmi(User user) {
		return postDAO.getPostsUnAmi(user.get_id());
	}
	
	public List<Post> getMyPosts(User user) {
		String authorId = user.get_id().toString();		
		return postDAO.findByAuthorId(authorId);
	}
	
	public List<Post> getPostsTouslesAmis(User user) {
		List<ObjectId> idAmis = user.get_myFriends();
		List<Post> retour = null;
		if (! idAmis.isEmpty()) {
			retour = postDAO.findByAuthorIdsDateDsc(idAmis);
		}
		return retour;
	}
	
	public void creerPost(User auteur, String body) {
		Post post = new Post();
		post.set_authorId(auteur.get_id());
		post.set_body(body);
		post.set_author(auteur.get_surname());
		post.set_date(new Date());
		postDAO.create(post);
	}
}
