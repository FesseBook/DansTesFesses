package controler.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import model.Group;
import model.Post;
import model.User;

public interface UserDAO {
	
	public void create(User user);

	public User findById(String id);
	
	public User findById(ObjectId id);
	
	public List<User> findByIds(List<ObjectId> userIds);
	
	public List<User> findUsers();
	
	public List<User> findUsersWithLimit(int limit);
	
	public List<User> findByName(String name);
	
	public List<User> findByNameWithLimit(String name, int limit);
	
	public List<User> findBySurname(String surname);
	
	public List<User> findBySurnames(List<String> surnames);
	
	public List<User> findBySurameWithLimit(String surname, int limit);
	
	public List<User> findBySurnamesWithLimit(List<String> surnames, int limit);
	
	public List<User> findByEmail(String email);
	
	//public List<User> findByEmails(List<String> emails);
	
	public List<User> findByEmailWithLimit(String email, int limit);
	
	public List<User> findByLogin(String login);
	
	public List<User> findByLogin(List<String> logins);
	
	public List<User> findByLoginWithLimit(String login, int limit);
	
	public List<User> findByFriend(ObjectId friendId);
	
	public List<User> findByFriends(List<ObjectId> friendIds);
	
	public List<User> findByGroups(Group groupId);
	
	public List<User> findByGroups(List<Group> groupIds);
	
	public List<User> findByPostInvolved(ObjectId postId);
	
	public List<User> findByPostInvolved(List<ObjectId> postIds);
	
	public List<User> findByPictures(ObjectId pictureId) ;

	public List<User> findByPictures(List<ObjectId> pictureIds) ;
	
	public boolean areFiends(ObjectId objId, ObjectId friendId);
	
	public boolean emailPasswordValid(String email, String password);
	
	public void updateSNELP(ObjectId userId, String surname, String name,
			String email, String login, String password);
	
	public void updateWholeUser(String _id, User user);
	
	public void updateWholeUser(ObjectId _id, User user);
	
	public void addFriend(ObjectId whoAccepted, ObjectId whoAsked);
	
	public void deleteFriend(ObjectId user1, ObjectId user2);
	
	public void refuseFriend(ObjectId whoRefused, ObjectId whoAsked);
	
	public void addPostInvolvedIn(ObjectId userId, ObjectId postId);
	
	public void deletePostInvolvedIn(ObjectId userId, ObjectId postId);
	
	public void addGroupToUser(ObjectId userId, ObjectId groupId);
	
	public void deleteGroupFromUser(ObjectId userId, ObjectId groupId);
	
	public void addPictureToUser(ObjectId userId, ObjectId pictureId);
	
	public void deletePictureFromUser(ObjectId userId, ObjectId pictureId);
	
	public void delete(String id);
	
	public void delete(ObjectId id);
}
