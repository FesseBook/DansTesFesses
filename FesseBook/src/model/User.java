	package model;

import java.util.*;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.*;

@Entity(value="User", noClassnameStored=true)
public class User {
	@Id
	private ObjectId _id;
	private String _surname;
	private String _name;
	private String _email;  // unique a implementer
	private String _login;
	private String _password;
	private ArrayList<ObjectId> _myPostsAndComment; // store the id of all post the user is involved posting or commenting
	private ArrayList<ObjectId> _myFriends;
	private ArrayList<ObjectId> _myPictures;
	private ArrayList<ObjectId> _myGroups;
	
	
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
	public String get_password() {
		return _password;
	}
	public void set_password(String _password) {
		this._password = _password;
	}
	public ArrayList<ObjectId> get_myPostsAndComment() {
		return _myPostsAndComment;
	}
	public void set_myPostsAndComment(ArrayList<ObjectId> _myPostsAndComment) {
		this._myPostsAndComment = _myPostsAndComment;
	}
	public ArrayList<ObjectId> get_myFriends() {
		return _myFriends;
	}
	public void set_myFriends(ArrayList<ObjectId> _myFriends) {
		this._myFriends = _myFriends;
	}
	public ArrayList<ObjectId> get_myPictures() {
		return _myPictures;
	}
	public void set_myPictures(ArrayList<ObjectId> _myPictures) {
		this._myPictures = _myPictures;
	}
	public ArrayList<ObjectId> get_myGroups() {
		return _myGroups;
	}
	public void set_myGroups(ArrayList<ObjectId> _myGroups) {
		this._myGroups = _myGroups;
	}
	
	
	
	

}
