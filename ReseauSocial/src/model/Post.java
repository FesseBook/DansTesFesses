package model;

import java.util.*;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.*;

@Entity(value="Post", noClassnameStored=true)
public class Post {
	@Id
	private ObjectId _id;
	
	private ObjectId _authorId;
	
	private String _author;
	
	private Date _date;
	
	private String _body;
	
	@Embedded
	private ArrayList<Comment> _comments;
	
	private int _likes;
	
	private ArrayList<String> _tags;
	
	private String _postedOnType;
	
	private ObjectId _postedOnId;
	
	
	
	
	
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId id){
		this._id = id;
	}

	public ObjectId get_authorId() {
		return _authorId;
	}
	public void set_authorId(ObjectId _authorId) {
		this._authorId = _authorId;
	}
	public String get_author() {
		return _author;
	}
	public void set_author(String _author) {
		this._author = _author;
	}
	public Date get_date() {
		return _date;
	}
	public void set_date(Date _date) {
		this._date = _date;
	}
	public String get_body() {
		return _body;
	}
	public void set_body(String _body) {
		this._body = _body;
	}
	public ArrayList<Comment> get_comments() {
		return _comments;
	}
	public void set_comments(ArrayList<Comment> _comments) {
		this._comments = _comments;
	}
	public int get_likes() {
		return _likes;
	}
	public void set_likes(int _likes) {
		this._likes = _likes;
	}
	public ArrayList<String> get_tags() {
		return _tags;
	}
	public void set_tags(ArrayList<String> _tags) {
		this._tags = _tags;
	}
	public String get_postedOnType() {
		return _postedOnType;
	}
	public void set_postedOnType(String _postedOnType) {
		this._postedOnType = _postedOnType;
	}
	public ObjectId get_postedOnId() {
		return _postedOnId;
	}
	public void set_postedOnId(ObjectId _postedOnId) {
		this._postedOnId = _postedOnId;
	}
	@Override
	public String toString() {
		return "Post [_id=" + _id + ", _authorId=" + _authorId + ", _author="
				+ _author + ", _date=" + _date + ", _body=" + _body
				+ ", _likes=" + _likes + ", _tags=" + _tags
				+ ", _postedOnType=" + _postedOnType + ", _postedOnId="
				+ _postedOnId + "]";
	}
	
	

}
