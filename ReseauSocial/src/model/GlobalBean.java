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
	
	private ArrayList<ObjectId> _postInvolved; 
	
	private ArrayList<Post> _postContainer;
	
	private ArrayList<ObjectId> _myFriends;
	private ArrayList<UserContainer> _myFiendsContainer;
	
	
	private ArrayList<ObjectId> _myPictures;
	private ArrayList<Picture> _myPicturesContainer;
	
	private ArrayList<ObjectId> _myGroups;
	private ArrayList<GroupContainer> _myGroupContainer;
	
	
	private ArrayList<ObjectId> _waitingForYourFriendshipResponse;
	private ArrayList<UserContainer> _waitingForYourFriendshipResponseContainer;
	
	private ArrayList<ObjectId> _responsesYouAreWaitingFor;
	private ArrayList<UserContainer> _responsesYouAreWaitingForContainer;
	
	
	
	
	
	

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

	public List<ObjectId> get_myPictures() {
		return _myPictures;
	}

	public void set_myPictures(ArrayList<ObjectId> _myPictures) {
		this._myPictures = _myPictures;
	}

	public List<Picture> get_myPicturesContainer() {
		return _myPicturesContainer;
	}

	public void set_myPicturesContainer(ArrayList<Picture> _myPicturesContainer) {
		this._myPicturesContainer = _myPicturesContainer;
	}

	public List<ObjectId> get_myGroups() {
		return _myGroups;
	}

	public void set_myGroups(ArrayList<ObjectId> _myGroups) {
		this._myGroups = _myGroups;
	}

	public List<GroupContainer> get_myGroupContainer() {
		return _myGroupContainer;
	}

	public void set_myGroupContainer(ArrayList<GroupContainer> _myGroupContainer) {
		this._myGroupContainer = _myGroupContainer;
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

	@Override
	public String toString() {
		return "GlobalBean [_id=" + _id + ", _surname=" + _surname + ", _name="
				+ _name + ", _email=" + _email + ", _login=" + _login + "]";
	}

}
