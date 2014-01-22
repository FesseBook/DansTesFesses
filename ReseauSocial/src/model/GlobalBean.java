package model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

public class GlobalBean {
	private ObjectId _id;
	private String _surname;
	private String _name;
	private String _email;  // unique a implementer
	private String _login;
	
	private ArrayList<ObjectId> _myFriends;  // 9 premiers
	private ArrayList<UserContainer> _myFiendsContainer; // 9 premiers
	

	private ArrayList<ObjectId> _waitingForYourFriendshipResponse; // a conserver ou non en fonction d'ajax
	private ArrayList<UserContainer> _waitingForYourFriendshipResponseContainer; // a conserver ou non en fonction d'ajax
	
	private ArrayList<ObjectId> _responsesYouAreWaitingFor;// a conserver ou non en fonction d'ajax
	private ArrayList<UserContainer> _responsesYouAreWaitingForContainer;// a conserver ou non en fonction d'ajax
	
	///////////////////////
	
	
	private ObjectId  _currentWallId;
	private String _currentWallType;
	
	private ArrayList<ObjectId> _postInvolved; // 20 premiers
	private ArrayList<Post> _postContainer; // 20 premiers
	
	
	private ArrayList<ObjectId> _Pictures; // 9 premiers
	private ArrayList<Picture> _PicturesContainer; // 9 premiers
	
	private ArrayList<ObjectId> _Groups; // 9 premiers
	private ArrayList<GroupContainer> _GroupContainer;// 9 premiers
	
	private ArrayList<ObjectId> _Friends;// a conserver ou non en fonction d'ajax
	private ArrayList<UserContainer> _FiendsContainer;// a conserver ou non en fonction d'ajax
	
	
	
	
	
	

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId id) {
		this._id=id;
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

	public List<ObjectId> get_postInvolved() {
		return _postInvolved;
	}

	public void set_postInvolved(ArrayList<ObjectId> _postInvolved) {
		this._postInvolved = _postInvolved;
	}

	public List<Post> get_postContainer() {
		return _postContainer;
	}

	public void set_postContainer(ArrayList<Post> _postContainer) {
		this._postContainer = _postContainer;
	}

	public List<ObjectId> get_myFriends() {
		return _myFriends;
	}

	public void set_myFriends(ArrayList<ObjectId> _myFriends) {
		this._myFriends = _myFriends;
	}

	public List<UserContainer> get_myFiendsContainer() {
		return _myFiendsContainer;
	}

	public void set_myFiendsContainer(ArrayList<UserContainer> _myFiendsContainer) {
		this._myFiendsContainer = _myFiendsContainer;
	}

	public List<ObjectId> get_Pictures() {
		return _Pictures;
	}

	public void set_Pictures(ArrayList<ObjectId> _Pictures) {
		this._Pictures = _Pictures;
	}

	public List<Picture> get_PicturesContainer() {
		return _PicturesContainer;
	}

	public void set_myPicturesContainer(ArrayList<Picture> _PicturesContainer) {
		this._PicturesContainer = _PicturesContainer;
	}

	public List<ObjectId> get_Groups() {
		return _Groups;
	}

	public void set_Groups(ArrayList<ObjectId> _Groups) {
		this._Groups = _Groups;
	}

	public List<GroupContainer> get_GroupContainer() {
		return _GroupContainer;
	}

	public void set_GroupContainer(ArrayList<GroupContainer> _GroupContainer) {
		this._GroupContainer = _GroupContainer;
	}

	public List<ObjectId> get_waitingForYourFriendshipResponse() {
		return _waitingForYourFriendshipResponse;
	}

	public void set_waitingForYourFriendshipResponse(
			ArrayList<ObjectId> _waitingForYourFriendshipResponse) {
		this._waitingForYourFriendshipResponse = _waitingForYourFriendshipResponse;
	}

	public List<UserContainer> get_waitingForYourFriendshipResponseContainer() {
		return _waitingForYourFriendshipResponseContainer;
	}

	public void set_waitingForYourFriendshipResponseContainer(
			ArrayList<UserContainer> _waitingForYourFriendshipResponseContainer) {
		this._waitingForYourFriendshipResponseContainer = _waitingForYourFriendshipResponseContainer;
	}

	public List<ObjectId> get_responsesYouAreWaitingFor() {
		return _responsesYouAreWaitingFor;
	}

	public void set_responsesYouAreWaitingFor(
			ArrayList<ObjectId> _responsesYouAreWaitingFor) {
		this._responsesYouAreWaitingFor = _responsesYouAreWaitingFor;
	}



	public List<UserContainer> get_responsesYouAreWaitingForContainer() {
		return _responsesYouAreWaitingForContainer;
	}



	public void set_responsesYouAreWaitingForContainer(
			ArrayList<UserContainer> _responsesYouAreWaitingForConatainer) {
		this._responsesYouAreWaitingForContainer = _responsesYouAreWaitingForConatainer;
	}
	
	
	public ObjectId get_currentWallId() {
		return _currentWallId;
	}

	public void set_currentWallId(ObjectId _currentWallId) {
		this._currentWallId = _currentWallId;
	}

	public ArrayList<ObjectId> get_Friends() {
		return _Friends;
	}

	public void set_Friends(ArrayList<ObjectId> _Friends) {
		this._Friends = _Friends;
	}

	public ArrayList<UserContainer> get_FiendsContainer() {
		return _FiendsContainer;
	}

	public void set_FiendsContainer(ArrayList<UserContainer> _FiendsContainer) {
		this._FiendsContainer = _FiendsContainer;
	}

	public void set_PicturesContainer(ArrayList<Picture> _PicturesContainer) {
		this._PicturesContainer = _PicturesContainer;
	}
	
	public String get_currentWallType() {
		return _currentWallType;
	}

	public void set_currentWallType(String _wallType) {
		this._currentWallType = _wallType;
	}
	

	@Override
	public String toString() {
		return "GlobalBean [_id=" + _id + ", _surname=" + _surname + ", _name="
				+ _name + ", _email=" + _email + ", _login=" + _login + "]";
	}

	



}
