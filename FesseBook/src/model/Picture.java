package model;

import java.util.*;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.*;

@Entity(value="Picture", noClassnameStored=true)
public class Picture {
	@Id
	private ObjectId _id;
	private String _name;
	private Date _date;
	private int _authorId;
	private int _author;
	private ArrayList<Integer> _tags;
	private ArrayList<ObjectId> _friendsTagged;
	private int _pictureURI;
	private Byte[] _picture;
	
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public Date get_date() {
		return _date;
	}
	public void set_date(Date _date) {
		this._date = _date;
	}
	public int get_authorId() {
		return _authorId;
	}
	public void set_authorId(int _authorId) {
		this._authorId = _authorId;
	}
	public int get_author() {
		return _author;
	}
	public void set_author(int _author) {
		this._author = _author;
	}
	public ArrayList<Integer> get_tags() {
		return _tags;
	}
	public void set_tags(ArrayList<Integer> _tags) {
		this._tags = _tags;
	}
	public int get_pictureURI() {
		return _pictureURI;
	}
	public void set_pictureURI(int _pictureURI) {
		this._pictureURI = _pictureURI;
	}
	public Byte[] get_picture() {
		return _picture;
	}
	public void set_picture(Byte[] _picture) {
		this._picture = _picture;
	}
	public ArrayList<ObjectId> get_friendsTagged() {
		return _friendsTagged;
	}
	public void set_friendsTagged(ArrayList<ObjectId> _friendsTagged) {
		this._friendsTagged = _friendsTagged;
	}
}
