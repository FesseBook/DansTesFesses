package controler;

import java.util.Date;
import java.util.List;

import model.Comment;
import model.Post;
import model.User;

import org.bson.types.ObjectId;

public interface EJBPrincipal_itf {
	
	
	
	/*********************************************************/
	/*														 */
	/*														 */	
	/*							USER						 */
	/*														 */
	/*														 */
	/*														 */
	/*********************************************************/
	
	public void createUser(String name, String surname, String email, String password);
	
	public void createUser(User user);
	/**********************************************/
	public List<User> USERfindUserByIds( List<ObjectId> ids);
	
//	public List<User> USERfindUserByIds( List<String> ids){
//		List<ObjectId> ids1 = new ArrayList <ObjectId>();
//		for(String id : ids){
//			ids1.add(new ObjectId(id));
//		}
//		return userDAO.findByIds(ids1);
//	}
	
	/**********************************************/
	
	public User USERfindById( ObjectId id);
	
	public User USERfindById( String id);
	
	/**********************************************/
	public User USERfindByEmail(String email);
	
	/**********************************************/
	public boolean USERareFiends(ObjectId objId, ObjectId friendId);
	
	public boolean USERareFiends(String objId, ObjectId friendId);
	/**********************************************/
	public boolean USERemailPasswordValid(String email, String password);
	/**********************************************/
	public void USERupdateSNELP(ObjectId userId, String surname, String name,
			String email, String login, String password);
	
	public void USERupdateSNELP(String userId, String surname, String name,
			String email, String login, String password);
	
	/**********************************************/
	public void USERupdateWholeUser(String _id, User user);
	
	public void USERupdateWholeUser(ObjectId _id, User user);
	/**********************************************/
	public void USERaddFriend(ObjectId whoAccepted, ObjectId whoAsked);
	
	public void USERaddFriend(String whoAccepted, ObjectId whoAsked);
	
	/**********************************************/
	public void USERdeleteFriend(ObjectId user1, ObjectId user2);
	
	public void USERdeleteFriend(String user1, String user2);
	/**********************************************/
	public void USERrefuseFriend(ObjectId whoRefused, ObjectId whoAsked);
	
	public void USERrefuseFriend(String whoRefused, String whoAsked);
	
	/**********************************************/
	public void USERaddPostInvolvedIn(ObjectId userId, ObjectId postId);
	
	public void USERaddPostInvolvedIn(String userId, String postId);
	
	/**********************************************/
	public void USERdeletePostInvolvedIn(ObjectId userId, ObjectId postId);
	
	public void USERdeletePostInvolvedIn(String userId, String postId);
	
	/**********************************************/
	public void USERaddGroupToUser(ObjectId userId, ObjectId groupId);
	
	public void USERaddGroupToUser(String userId, String groupId);
	
	
	/**********************************************/
	public void USERdeleteGroupFromUser(ObjectId userId, ObjectId groupId);
	
	public void USERdeleteGroupFromUser(String userId, String groupId);
	
	
	/**********************************************/
	public void USERaddPictureToUser(ObjectId userId, ObjectId pictureId);
	
	public void USERaddPictureToUser(String userId, String pictureId);
	
	/**********************************************/
	
	public void USERdeletePictureFromUser(ObjectId userId, ObjectId pictureId);
	
public void USERdeletePictureFromUser(String userId, String pictureId);
	
	/**********************************************/
	public void USERdelete(String id);
	public void USERdelete(ObjectId id);
	
	
	
	/*********************************************************/
	/*														 */
	/*														 */	
	/*					POST & COMMENT						 */
	/*														 */
	/*														 */
	/*														 */
	/*********************************************************/
	
	
public void POSTcreatePost( String authorId, String author, String body, String postedOnType, String postedOnId);



public List<Post> POSTfindPostedOnDateDsc(String wallEntityType, ObjectId id);

public List<Post> POSTfindPostedOnDateDscWithLimit(String wallEntityType, ObjectId id, int limit);


public List<Post> POSTfindByAuthorIdsDateDscWithLimit(List<ObjectId> _authorIds, int limit);


public void POSTupdateWholePost(String _id, Post post);

	public void POSTupdateWholePost(ObjectId _id, Post post);

public void POSTaddComment(ObjectId postId, Comment comment);

public void POSTdeleteComment ( ObjectId postId, Comment comment);


public void POSTdelete(String id);
public void POSTdelete(ObjectId id);
public void POSTdelete(Post post);



/*********************************************************/
/*														 */
/*														 */	
/*						PICTURE							 */
/*														 */
/*														 */
/*														 */
/*********************************************************/
	
	
	
	
	public void createPicture();
	public void createGroup();
	public void createEvent();
	
	

}
