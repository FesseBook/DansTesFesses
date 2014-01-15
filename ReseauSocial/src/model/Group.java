package model;

import java.util.*;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.*;

@Entity(value="Group", noClassnameStored=true)
public class Group {
	@Id
	private ObjectId _id;
	private String _name;
	private String _description;
	private ArrayList<ObjectId> _postsId;
	private ArrayList<ObjectId> _membersId;
	private ArrayList<ObjectId> _picturesId;
	private ArrayList<ObjectId> _adminsId;
	private ArrayList<ObjectId> _waitingForResponse;
	
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
	public String get_description() {
		return _description;
	}
	public void set_description(String _description) {
		this._description = _description;
	}
	public ArrayList<ObjectId> get_postsId() {
		return _postsId;
	}
	public void set_postsId(ArrayList<ObjectId> _postsId) {
		this._postsId = _postsId;
	}
	public ArrayList<ObjectId> get_membersId() {
		return _membersId;
	}
	public void set_membersId(ArrayList<ObjectId> _membersId) {
		this._membersId = _membersId;
	}
	public ArrayList<ObjectId> get_picturesId() {
		return _picturesId;
	}
	public void set_picturesId(ArrayList<ObjectId> _picturesId) {
		this._picturesId = _picturesId;
	}
	public ArrayList<ObjectId> get_adminId() {
		return _adminsId;
	}
	public void set_adminId(ArrayList<ObjectId> _adminId) {
		this._adminsId = _adminId;
	}
	public ArrayList<ObjectId> get_adminsId() {
		return _adminsId;
	}
	public void set_adminsId(ArrayList<ObjectId> _adminsId) {
		this._adminsId = _adminsId;
	}
	public ArrayList<ObjectId> get_waitingForResponse() {
		return _waitingForResponse;
	}
	public void set_waitingForResponse(ArrayList<ObjectId> _waitingForResponse) {
		this._waitingForResponse = _waitingForResponse;
	}


}
