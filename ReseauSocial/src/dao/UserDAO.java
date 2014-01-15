package dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import model.Post;
import model.User;

public interface UserDAO {
	
<<<<<<< HEAD
	public void create( User user);
	
	public List<User> findUsers();
	
	public List<User> findByName(String _name);
	
	public List<User>findByFriends( String _login);
	public List<User>findByFriends( int _id);
	
	public User findOneById( int _id);
	public User findOneByNameAndSurname( String _name, String _surname);
	public User findOneByLogin(String _login);
	
	public int update(int id, User user);
	
	public int delete( /* id ?*/);
	
	public boolean identifiantsValides(String login, String password);
=======
//	public void create( User user);
//	
//	public List<User> findUsers();
//	
//	public List<User> findByName(String _name);
//	
//	public List<User>findByFriends( String _login);
//	public List<User>findByFriends( int _id);
//	
//	public User findOneById(String _id);
//	//public User findOneByNameAndSurname( String _name, String _surname);
//	//public User findOneByLogin(String _login);
//	
//	public int update(int id, User user);
//	
//	public int delete( /* id ?*/);
>>>>>>> 0855835561b6072b4a9b1c8ad83756d6bf2550e8

}
