package controler.dao;

import model.Event;

import org.bson.types.ObjectId;

public interface EventDAO {
	
	public void create(Event group);
	
	public void update(int id, Event Group);

	public void delete(String id) ;

	public void delete(ObjectId id) ;

}
