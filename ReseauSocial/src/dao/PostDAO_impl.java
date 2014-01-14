package dao;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import model.Post;

public class PostDAO_impl implements PostDAO{
	
	Datastore userDatastore;
	
	PostDAO_impl(Mongo mongo){
		Datastore userDatastore = new Morphia().createDatastore(mongo, "Usermanager");
	}
	
	public void create(Post post) {
		userDatastore.save(post);
	}

	public List<Post> findByAuthor(String _author) {
		return userDatastore.createQuery(Post.class).field("_author").equal(_author).asList();
	}
	
	public List<Post> findByAuthorId(String _authorId) {
		ObjectId obj = new ObjectId(_authorId);
		return userDatastore.createQuery(Post.class).field("_id").equal(obj).asList();
	}
	
	public Post findById(String _id) {
		ObjectId obj = new ObjectId(_id);
		return userDatastore.createQuery(Post.class).field("_id").equal(obj).get();
	}
	
	public List<Post> findByDate( Date _date) {// gestion de la date a voir
		return userDatastore.createQuery(Post.class).field("_date").equal(_date).asList();
	}
	
	public void updateWholeDocument(String _id, Post post) {
		Post p = findById(_id);
		userDatastore.delete(p);
		userDatastore.save(post);
	}
	
	public void delete(String _id) {
		Post p = findById(_id);
		userDatastore.delete(p);
	}

	@Override
	public List<Post> findByTag(String _tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateWholeDocument(int _id, Post post) {
		// TODO Auto-generated method stub
		
	}
	 @Override
	public List<Post> findByCommentator( String _author) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Post> findBydCommentator(int _id) {
		// TODO Auto-generated method stub
		return null;
	}

}
