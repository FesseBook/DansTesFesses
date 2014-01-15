package dao;

import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

import model.User;

public class UserDAO_impl implements UserDAO{

	Datastore userDatastore;
	
		UserDAO_impl(Mongo mongo){
			Datastore userDatastore = new Morphia().createDatastore(mongo, "Usermanager");
		}
	
	public void create( User user){
		userDatastore.save(user);
	};
	
	
	public User findOne(String id){
		ObjectId objId = new ObjectId(id);
		return userDatastore.createQuery(User.class).field("_id").equal(objId).get();
	}
	
	public List<User> findUsers(){
		return userDatastore.createQuery(User.class).asList();
	};
	
	///////////////////////////////////////////////
	
	public List<User> findByName(String name){
		return userDatastore.createQuery(User.class).field("_name").equal(name).asList();
	};
	
	
	public List<User> findByNameWithLimit(String name, int limit){
		return userDatastore.createQuery(User.class).field("_name").equal(name).limit(limit).asList();
	};
	///////////////////////////////////////////////
	
	public List<User> findBySurname(String surname){
		return userDatastore.createQuery(User.class).field("_surname").equal(surname).asList();
	};
	
	public List<User> findBySurameWithLimit(String surname, int limit){
		return userDatastore.createQuery(User.class).field("_surname").equal(surname).limit(limit).asList();
	};
	////////////////////////////////////////////////

	public List<User> findByEmail(String email){
		return userDatastore.createQuery(User.class).field("_email").equal(email).asList();
	};
	public List<User> findByEmailWithLimit(String email, int limit){
		return userDatastore.createQuery(User.class).field("_email").equal(email).limit(limit).asList();
	};
	////////////////////////////////////////////////

	public List<User> findByLogin(String login){
		return userDatastore.createQuery(User.class).field("_login").equal(login).asList();
	};
	public List<User> findByLoginWithLimit(String login, int limit){
		return userDatastore.createQuery(User.class).field("_login").equal(login).limit(limit).asList();
	};
	////////////////////////////////////////////////
	
	
	public boolean areFiends(ObjectId objId, ObjectId friendId){
		return userDatastore.find(User.class,)
	}
	
	
	
	/*
	
	
	public List<User>findByFriends( String _login);
	public List<User>findByFriends( int _id);
	
	public User findOneById( int _id);
	public User findOneByNameAndSurname( String _name, String _surname);
	public User findOneByLogin(String _login);
	
	public int update(int id, User user);
	
	public int delete( /* id ?); */
	
}
