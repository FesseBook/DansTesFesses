package dao;

import java.util.List;

import javax.ejb.Stateless;

import org.bson.types.ObjectId;

import model.Post;
import model.User;

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
}
