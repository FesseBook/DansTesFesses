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
	
	public List<PostJSP> getPostsTouslesAmis(User user) {
		ArrayList<ObjectId> amisIds = user.get_myFriends();
		List<Post> posts = postDAO.getPostsUsers(amisIds);
		List<PostJSP> retour = new ArrayList<PostJSP>();
		for (Post p : posts) {
			UserJSPSansAmis auteur = new UserJSPSansAmis();
			auteur.setId(p.get_author());
			User user = userDAO.findOneById(p.get_author()); // userDAO ˆ changer
			auteur.setNom(user.get_name());
			auteur.setPrenom(user.get_surname());
			PostJSP pJSP = new PostJSP();
			pJSP.setAuteur(auteur);
			
		}
		return null;
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
