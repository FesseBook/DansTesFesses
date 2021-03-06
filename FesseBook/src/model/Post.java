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
	
	public ObjectId get_id() {
		return _id;
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
	
	

}
