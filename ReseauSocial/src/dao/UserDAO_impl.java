package dao;

import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

import model.Group;
import model.Post;
import model.User;

public class UserDAO_impl implements UserDAO {

	Datastore userDatastore;

	public UserDAO_impl(Datastore dataStore) {
		userDatastore = dataStore;
	}

	public void create(User user) {
		userDatastore.save(user);
	};

	public User findById(String id) {
		ObjectId objId = new ObjectId(id);
		return userDatastore.createQuery(User.class).field("_id").equal(objId)
				.get();
	}

	public User findById(ObjectId id) {
		return userDatastore.createQuery(User.class).field("_id").equal(id)
				.get();
	}

	public List<User> findUsers() {
		return userDatastore.createQuery(User.class).asList();
	};

	public List<User> findUsersWithLimit(int limit) {
		return userDatastore.createQuery(User.class).limit(limit).asList();
	};

	// /////////////////////////////////////////////

	public List<User> findByName(String name) {
		return userDatastore.createQuery(User.class).field("_name").equal(name)
				.asList();
	};

	public List<User> findByNameWithLimit(String name, int limit) {
		return userDatastore.createQuery(User.class).field("_name").equal(name)
				.limit(limit).asList();
	};

	// /////////////////////////////////////////////

	public List<User> findBySurname(String surname) {
		return userDatastore.createQuery(User.class).field("_surname")
				.equal(surname).asList();
	};

	public List<User> findBySurnames(List<String> surnames) {
		return userDatastore.createQuery(User.class)
				.filter("_surname in", surnames).asList();
	};

	public List<User> findBySurameWithLimit(String surname, int limit) {
		return userDatastore.createQuery(User.class).field("_surname")
				.equal(surname).limit(limit).asList();
	};

	public List<User> findBySurnamesWithLimit(List<String> surnames, int limit) {
		return userDatastore.createQuery(User.class)
				.filter("_surname in", surnames).limit(limit).asList();
	};

	// //////////////////////////////////////////////

	public List<User> findByEmail(String email) {
		return userDatastore.createQuery(User.class).field("_email")
				.equal(email).asList();
	};

	public List<User> findByEmail(List<String> emails) {
		return userDatastore.createQuery(User.class)
				.filter("_surname in", emails).asList();
	};

	public List<User> findByEmailWithLimit(String email, int limit) {
		return userDatastore.createQuery(User.class).field("_email")
				.equal(email).limit(limit).asList();
	};

	// //////////////////////////////////////////////

	public List<User> findByLogin(String login) {
		return userDatastore.createQuery(User.class).field("_login")
				.equal(login).asList();
	};

	public List<User> findByLogin(List<String> logins) {
		return userDatastore.createQuery(User.class)
				.filter("_login in", logins).asList();
	};

	public List<User> findByLoginWithLimit(String login, int limit) {
		return userDatastore.createQuery(User.class).field("_login")
				.equal(login).limit(limit).asList();
	};

	// //////////////////////////////////////////////

	public List<User> findByFriends(ObjectId friendId) {
		return userDatastore.createQuery(User.class).field("_myFriends")
				.hasThisElement(friendId).asList();
	}

	// /// voir si le parcours de tableau fonctionne
	public List<User> findByFriends(List<ObjectId> friendIds) {
		return userDatastore.createQuery(User.class)
				.filter("_myFriends in", friendIds).asList();
	}

	// /////////////////////////////////////////////

	// //////////////////////////////////////////////

	public List<User> findByGroups(Group groupId) {
		return userDatastore.createQuery(User.class).field("_myGroups")
				.hasThisElement(groupId).asList();
	}

	// /// voir si le parcours de tableau fonctionne
	public List<User> findByGroups(List<Group> groupIds) {
		return userDatastore.createQuery(User.class)
				.filter("_myGroups in", groupIds).asList();
	}

	// //////////////////////////////////////////////
	public List<User> findByPostInvolved(ObjectId postId) {
		return userDatastore.createQuery(User.class).field("_postInvolved")
				.hasThisElement(postId).asList();
	}

	public List<User> findByPostInvolved(List<ObjectId> postIds) {
		return userDatastore.createQuery(User.class)
				.filter("_postInvolved in", postIds).asList();
	}

	// //////////////////////////////////////////////
	public List<User> findByPictures(ObjectId pictureId) {
		return userDatastore.createQuery(User.class).field("_myPictures")
				.hasThisElement(pictureId).asList();
	}

	public List<User> findByPictures(List<ObjectId> pictureIds) {
		return userDatastore.createQuery(User.class)
				.filter("_myPictures in", pictureIds).asList();
	}

	// //////////////////A tester pour voir la prise en compte du 2 eme critère
	// ///////////////////

	public boolean areFiends(ObjectId objId, ObjectId friendId) {
		return (userDatastore.createQuery(User.class).filter("_id",objId)
				.field("_myFriends").hasThisElement(friendId)) != null;
	}

	public boolean emailPasswordValid(String email, String password) {
		return (userDatastore.createQuery(User.class).filter("_email", email)
				.filter("_password", password)) != null;
	}
	

	

	
	public void updateWholeDocument(String _id, User user) {
		User p = findById(_id);
		user.set_id(p.get_id());
		userDatastore.delete(p);
		userDatastore.save(user);
	}
	
	public void updateWholeDocument(ObjectId _id, User user) {
		User p = findById(_id);
		user.set_id(p.get_id());
		userDatastore.delete(p);
		userDatastore.save(user);
	}
	/////////////////////////////////////////////////////////////
	
	public void addFriend (ObjectId whoAccepted, ObjectId whoAsked){
		userDatastore.update(this.findById(whoAccepted), userDatastore.createUpdateOperations(User.class).add("_myFriends", whoAsked));
		userDatastore.update(this.findById(whoAsked), userDatastore.createUpdateOperations(User.class).add("_myFriends", whoAccepted));
		userDatastore.update(this.findById(whoAccepted), userDatastore.createUpdateOperations(User.class).removeAll("_waitingForYourFriendshipResponse",whoAsked));
		userDatastore.update(this.findById(whoAsked), userDatastore.createUpdateOperations(User.class).removeAll("_responsesYouAreWaitingFor",whoAccepted));
		
	}
	
	public void deleteFriend (ObjectId user1, ObjectId user2){
		userDatastore.update(this.findById(user1), userDatastore.createUpdateOperations(User.class).removeAll("_myFriends",user2));
		userDatastore.update(this.findById(user2), userDatastore.createUpdateOperations(User.class).removeAll("_myFriends",user1));
		
	}
	
	public void refuseFriend(ObjectId whoRefused, ObjectId whoAsked){
		userDatastore.update(this.findById(whoRefused), userDatastore.createUpdateOperations(User.class).removeAll("_waitingForYourFriendshipResponse",whoAsked));
		userDatastore.update(this.findById(whoAsked), userDatastore.createUpdateOperations(User.class).removeAll("_responsesYouAreWaitingFor",whoRefused));
		
	}
	////////////////////////////////////////////////////////
	public void addPostInvolvedIn( ObjectId userId, ObjectId postId){
		userDatastore.update(this.findById(userId), userDatastore.createUpdateOperations(User.class).add("_postInvolved", postId));
	}
	public void deletePostInvolvedIn( ObjectId userId, ObjectId postId){
		userDatastore.update(this.findById(userId), userDatastore.createUpdateOperations(User.class).removeAll("_postInvolved", postId));
	}
	
	////////////////////////////////////////////////////////
	
	public void  addGroupToUser(ObjectId userId, ObjectId groupId){
		userDatastore.update(this.findById(userId), userDatastore.createUpdateOperations(User.class).add("_myGroups", groupId));
	}
	public void deleteGroupFromUser( ObjectId userId, ObjectId groupId){
		userDatastore.update(this.findById(userId), userDatastore.createUpdateOperations(User.class).removeAll("_myGroups", groupId));
	}
		
	////////////////////////////////////////////////////////
	
	public void  addPictureToUser(ObjectId userId, ObjectId pictureId){
		userDatastore.update(this.findById(userId), userDatastore.createUpdateOperations(User.class).add("_myPictures", pictureId));
	}
	public void deletePictureFromUser( ObjectId userId, ObjectId pictureId){
		userDatastore.update(this.findById(userId), userDatastore.createUpdateOperations(User.class).removeAll("_myPictures", pictureId));
	}
	
	
	
	
	// ////////////////////// TO DO ////////////////////////////////
	/*
	 *
	 * 
	 *
	 *
	 *
	 *
	 */// ////////////////////////////////////////////////////////////

	// ////////////////////////////////////////////////////////////////////////////////////////
	public void delete(String id) {
		ObjectId objId = new ObjectId(id);
		userDatastore.delete(User.class, objId);

	}

	public void delete(ObjectId id) {
		userDatastore.delete(User.class, id);

	}

}
