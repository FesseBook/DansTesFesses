package model;

import java.util.*;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.*;

@Entity(value="Event", noClassnameStored=true)
public class Event {
	@Id
	private ObjectId _id;
	private String _name;
	private String _location;
	private Date _date;
	private Date _eventDate;
	private ArrayList<ObjectId> _invited;
	private ArrayList<ObjectId> _present;
	private String _description;
	private ArrayList<ObjectId> _posts;
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId id){
		this._id = id;
	}

	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	public String get_location() {
		return _location;
	}
	public void set_location(String _location) {
		this._location = _location;
	}
	public Date get_date() {
		return _date;
	}
	public void set_date(Date _date) {
		this._date = _date;
	}
	public Date get_eventDate() {
		return _eventDate;
	}
	public void set_eventDate(Date _eventDate) {
		this._eventDate = _eventDate;
	}
	public ArrayList<ObjectId> get_invited() {
		return _invited;
	}
	public void set_invited(ArrayList<ObjectId> _invited) {
		this._invited = _invited;
	}
	public ArrayList<ObjectId> get_present() {
		return _present;
	}
	public void set_present(ArrayList<ObjectId> _present) {
		this._present = _present;
	}
	public String get_description() {
		return _description;
	}
	public void set_description(String _description) {
		this._description = _description;
	}
	public ArrayList<ObjectId> get_posts() {
		return _posts;
	}
	public void set_posts(ArrayList<ObjectId> _posts) {
		this._posts = _posts;
	}

}
