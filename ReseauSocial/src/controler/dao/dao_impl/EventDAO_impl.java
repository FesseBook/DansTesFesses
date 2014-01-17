package controler.dao.dao_impl;

import org.bson.types.ObjectId;

import model.Event;

import com.google.code.morphia.Datastore;

public class EventDAO_impl {

	
	Datastore eventDatastore;

	public EventDAO_impl(Datastore dataStore) {
		eventDatastore = dataStore;
	}

	public void create(Event group) {
		eventDatastore.save(group);
	};
	
	
	public void update(int id, Event Group) {

	};

	public void delete(String id) {
		ObjectId objId = new ObjectId(id);
		eventDatastore.delete(Event.class, objId);

	}

	public void delete(ObjectId id) {
		eventDatastore.delete(Event.class, id);

	}
	
}
