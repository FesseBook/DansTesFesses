package controler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;

import controler.dao.PostDAO;
import controler.dao.UserDAO;
import controler.dao.dao_impl.PostDAO_impl;
import controler.dao.dao_impl.UserDAO_impl;
import model.Comment;
import model.Group;
import model.Post;
import model.User;

//@Stateless
public class EJBPrincipal implements  EJBPrincipal_itf{
	
	private UserDAO userDAO;
	private PostDAO postDAO;
	
	public EJBPrincipal(Datastore datastore){
		userDAO = new UserDAO_impl(datastore);
		postDAO = new PostDAO_impl(datastore);
	}
	
	
	
	/*********************************************************/
	/*														 */
	/*														 */	
	/*							USER						 */
	/*														 */
	/*														 */
	/*														 */
	/*********************************************************/
	
	public void createUser(String name, String surname, String email, String password){
		User user = new User();
		user.set_name(name);
		user.set_surname(surname);
		user.set_email(email);
		user.set_password(password);
		userDAO.create(user);
	}
	
	public void createUser(User user){
		userDAO.create(user);
	}
	/**********************************************/
	public List<User> USERfindUserByIds( List<ObjectId> ids){
		return userDAO.findByIds(ids);
	}
	
//	public List<User> USERfindUserByIds( List<String> ids){
//		List<ObjectId> ids1 = new ArrayList <ObjectId>();
//		for(String id : ids){
//			ids1.add(new ObjectId(id));
//		}
//		return userDAO.findByIds(ids1);
//	}
	
	/**********************************************/
	
	public User USERfindById( ObjectId id){
		return userDAO.findById(id);
	}
	public User USERfindById( String id){
		return userDAO.findById(id);
	}
	
	/**********************************************/
	
	public User USERfindByEmail(String email){
		return userDAO.findById(email);
	}
	
	
	
	/**********************************************/
	public boolean USERareFiends(ObjectId objId, ObjectId friendId){	
		return userDAO.areFiends(objId, friendId);
	}
	
	public boolean USERareFiends(String objId, ObjectId friendId){
		ObjectId objId1 = new ObjectId( objId);
		return userDAO.areFiends(objId1, friendId);
	}
	
	/**********************************************/
	public boolean USERemailPasswordValid(String email, String password){
		return userDAO.emailPasswordValid(email, password);
	}
	/**********************************************/
	public void USERupdateSNELP(ObjectId userId, String surname, String name,
			String email, String login, String password){
		userDAO.updateSNELP(userId, surname, name, email, login, password);
	}
	
	public void USERupdateSNELP(String userId, String surname, String name,
			String email, String login, String password){
		ObjectId userId1 = new ObjectId(userId);
		userDAO.updateSNELP(userId1, surname, name, email, login, password);
	}
	
	
	/**********************************************/
	public void USERupdateWholeUser(String _id, User user){
		userDAO.updateWholeUser(_id, user);
	}
	
	public void USERupdateWholeUser(ObjectId _id, User user){
		userDAO.updateWholeUser(_id, user);
	}
	/**********************************************/
	public void USERaddFriend(ObjectId whoAccepted, ObjectId whoAsked){
		userDAO.addFriend(whoAccepted, whoAsked);
	}
	
	public void USERaddFriend(String whoAccepted, ObjectId whoAsked){
		ObjectId whoAccepted1 = new ObjectId(whoAccepted);
		userDAO.addFriend(whoAccepted1, whoAsked);
	}
	
	/**********************************************/
	public void USERdeleteFriend(ObjectId user1, ObjectId user2){
		userDAO.deleteFriend(user1, user2);
	}
	
	public void USERdeleteFriend(String user1, String user2){
		ObjectId user11 = new ObjectId(user1);
		ObjectId user21 = new ObjectId(user2);
		userDAO.deleteFriend(user11, user21);
	}
	/**********************************************/
	public void USERrefuseFriend(ObjectId whoRefused, ObjectId whoAsked){
		userDAO.refuseFriend(whoRefused, whoAsked);
	}
	
	public void USERrefuseFriend(String whoRefused, String whoAsked){
		ObjectId whoRefused1 = new ObjectId(whoRefused);
		ObjectId whoAsked1 = new ObjectId(whoAsked);
		userDAO.refuseFriend(whoRefused1, whoAsked1);
	}
	
	/**********************************************/
	public void USERaddPostInvolvedIn(ObjectId userId, ObjectId postId){
		userDAO.addPostInvolvedIn(userId, postId);
	}
	
	public void USERaddPostInvolvedIn(String userId, String postId){
		ObjectId userId1 = new ObjectId(userId);
		ObjectId postId1 = new ObjectId(postId);
		userDAO.addPostInvolvedIn(userId1, postId1);
	}
	
	/**********************************************/
	public void USERdeletePostInvolvedIn(ObjectId userId, ObjectId postId){
		userDAO.deletePostInvolvedIn(userId, postId);
	}
	
	public void USERdeletePostInvolvedIn(String userId, String postId){
		ObjectId userId1 = new ObjectId(userId);
		ObjectId postId1 = new ObjectId(postId);
		userDAO.deletePostInvolvedIn(userId1, postId1);
	}
	
	/**********************************************/
	public void USERaddGroupToUser(ObjectId userId, ObjectId groupId){
		userDAO.addGroupToUser(userId, groupId);
	}
	
	public void USERaddGroupToUser(String userId, String groupId){
		ObjectId userId1 = new ObjectId(userId);
		ObjectId groupId1 = new ObjectId(groupId);
		userDAO.addGroupToUser(userId1, groupId1);
	}
	
	
	/**********************************************/
	public void USERdeleteGroupFromUser(ObjectId userId, ObjectId groupId){
		userDAO.deleteGroupFromUser(userId, groupId);
	}
	
	public void USERdeleteGroupFromUser(String userId, String groupId){
		ObjectId userId1 = new ObjectId(userId);
		ObjectId groupId1 = new ObjectId(groupId);
		
		userDAO.deleteGroupFromUser(userId1, groupId1);
	}
	
	/**********************************************/
	public void USERaddPictureToUser(ObjectId userId, ObjectId pictureId){
		userDAO.addPictureToUser(userId, pictureId);
	}
	
	public void USERaddPictureToUser(String userId, String pictureId){
		
		ObjectId userId1 = new ObjectId(userId);
		ObjectId pictureId1 = new ObjectId(pictureId);
		userDAO.addPictureToUser(userId1, pictureId1);
	}
	
	/**********************************************/
	
	public void USERdeletePictureFromUser(ObjectId userId, ObjectId pictureId){
		
		userDAO.deletePictureFromUser(userId, pictureId);
	}
	
public void USERdeletePictureFromUser(String userId, String pictureId){
	ObjectId userId1 = new ObjectId(userId);
	ObjectId pictureId1 = new ObjectId(pictureId);
		
		userDAO.deletePictureFromUser(userId1, pictureId1);
	}
	
	/**********************************************/
	public void USERdelete(String id){
		userDAO.delete(id);
	}
	public void USERdelete(ObjectId id){
		userDAO.delete(id);
	}
	
	
	
	/*********************************************************/
	/*														 */
	/*														 */	
	/*					POST & COMMENT						 */
	/*														 */
	/*														 */
	/*														 */
	/*********************************************************/
	
	
public void POSTcreatePost( String authorId, String author, String body, String postedOnType, String postedOnId){
	Post post = new Post();
	post.set_authorId(new ObjectId(authorId));
	post.set_author(author);
	post.set_body(body);
	post.set_date(new Date());
	post.set_postedOnId(new ObjectId(postedOnId));
	post.set_postedOnType(postedOnType);
	postDAO.create(post);
	
}



public List<Post> POSTfindPostedOnDateDsc(String wallEntityType, ObjectId id){
	return postDAO.findPostedOnDateDsc(wallEntityType, id);
}

public List<Post> POSTfindPostedOnDateDscWithLimit(String wallEntityType, ObjectId id, int limit){
	return postDAO.findPostedOnDateDscWithLimit(wallEntityType, id, limit);
}


public List<Post> POSTfindByAuthorIdsDateDscWithLimit(List<ObjectId> _authorIds, int limit){
	return postDAO.findByAuthorIdsDateDscWithLimit(_authorIds, limit);
}


public void POSTupdateWholePost(String _id, Post post){
	postDAO.updateWholePost(_id, post);
}

	public void POSTupdateWholePost(ObjectId _id, Post post) {
		postDAO.updateWholePost(_id, post);
	}

public void POSTaddComment(ObjectId postId, Comment comment){
	postDAO.addComment(postId, comment);
}

public void POSTdeleteComment ( ObjectId postId, Comment comment){
	postDAO.deleteComment(postId, comment);
}


public void POSTdelete(String id) {
	postDAO.delete(id);
}
public void POSTdelete(ObjectId id){
	postDAO.delete(id);
}
public void POSTdelete(Post post){
	postDAO.delete(post);
}



@Override
public void createPicture() {
	// TODO Auto-generated method stub
	
}



@Override
public void createGroup() {
	// TODO Auto-generated method stub
	
}



@Override
public void createEvent() {
	// TODO Auto-generated method stub
	
}



}
