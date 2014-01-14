package model;

import java.util.Date;
import com.google.code.morphia.annotations.*;

@Embedded
public class Comment {
	
	private int _authorId;
	private String _author;
	private String _body;
	private Date _date;
	private int _likes;
	
	
	public int get_authorId() {
		return _authorId;
	}
	public void set_authorId(int _authorId) {
		this._authorId = _authorId;
	}
	public String get_author() {
		return _author;
	}
	public void set_author(String _author) {
		this._author = _author;
	}
	public String get_body() {
		return _body;
	}
	public void set_body(String _body) {
		this._body = _body;
	}
	public Date get_date() {
		return _date;
	}
	public void set_date(Date _date) {
		this._date = _date;
	}
	public int get_likes() {
		return _likes;
	}
	public void set_likes(int _likes) {
		this._likes = _likes;
	}
}
