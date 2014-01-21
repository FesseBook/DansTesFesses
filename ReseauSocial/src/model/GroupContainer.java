package model;

import org.bson.types.ObjectId;

public class GroupContainer {
	private ObjectId _id;
	private String _name;
	private String _description;
	
	
	
	public ObjectId get_id() {
		return _id;
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

}
