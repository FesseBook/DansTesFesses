package model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

public class UserContainer {
	private ObjectId _id;
	private String _surname;
	private String _name;
	private String _email;  // unique a implementer
	private String _login;
	
	
	public UserContainer(User user){
		_id = user.get_id();
		_surname = user.get_surname();
		_name = user.get_name();
		_email = user.get_email();
		_login = user.get_login();
	}
	
	public ObjectId get_id() {
		return _id;
	}
	
	public String get_surname() {
		return _surname;
	}
	public void set_surname(String _surname) {
		this._surname = _surname;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public String get_email() {
		return _email;
	}
	public void set_email(String _email) {
		this._email = _email;
	}
	public String get_login() {
		return _login;
	}
	public void set_login(String _login) {
		this._login = _login;
	}

	public static List<UserContainer> toList (List<User> userList){
		List <UserContainer> res = new ArrayList<UserContainer>();
		for (int i=0; i<userList.size();i++){
			res.add(i,  new UserContainer(userList.get(i)) );
		}
		return res;
	}
	
	
	
}
