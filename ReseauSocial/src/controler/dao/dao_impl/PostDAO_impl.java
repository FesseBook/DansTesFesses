package controler.dao.dao_impl;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import controler.dao.PostDAO;
import model.Comment;
import model.Post;
import model.User;

public class PostDAO_impl implements PostDAO {

	Datastore postDatastore;

	public PostDAO_impl(Datastore datastore) {
		postDatastore = datastore;
	}

	public void create(Post post) {
		postDatastore.save(post);
	}

	public List<Post> findByAuthor(String _author) {
		return postDatastore.createQuery(Post.class).field("_author")
				.equal(_author).asList();
	}

	public List<Post> findByAuthorId(String _authorId) {
		ObjectId obj = new ObjectId(_authorId);
		return postDatastore.createQuery(Post.class).field("_authorId")
				.equal(obj).asList();
	}
	
	public List<Post> findPostedOnDateDsc(String wallEntityType, ObjectId id) {
		return postDatastore.createQuery(Post.class)
				.filter("_postedOnType", wallEntityType)
				.filter("_postedOnId", id).order("-_date").asList();
	}
	
	public List<Post> findPostedOnDateDscWithLimit(String wallEntityType, ObjectId id, int limit) {
		return postDatastore.createQuery(Post.class)
				.filter("_postedOnType", wallEntityType)
				.filter("_postedOnId", id).order("-_date").limit(limit).asList();
	}

	public List<Post> findByTag(String _tag) {
		return postDatastore.createQuery(Post.class).field("_tags")
				.hasThisElement(_tag).asList();
	}

	public List<Post> findByCommentator(String _author) {
		return postDatastore.createQuery(Post.class).field("_comments._author")
				.equal(_author).asList();
	}

	public List<Post> findBydCommentatorId(ObjectId _id) {
		return postDatastore.createQuery(Post.class)
				.field("_comments._authorId").equal(_id).asList();
	}
	

	public List<Post> findByAuthorId(ObjectId _authorId) {
		return postDatastore.createQuery(Post.class).field("_authorId")
				.equal(_authorId).asList();
	}

	public List<Post> findByAuthorIdsDateDsc(List<ObjectId> _authorIds) {
		return postDatastore.createQuery(Post.class).filter("_authorId in", _authorIds)
				.order("-_date").asList();
	}
	
	public List<Post> findByAuthorIdsDateDscWithLimit(List<ObjectId> _authorIds, int limit) {
		return postDatastore.createQuery(Post.class).filter("_authorId in", _authorIds)
				.order("-_date").limit(limit).asList();
	}

	public Post findById(String _id) {
		ObjectId obj = new ObjectId(_id);
		return postDatastore.createQuery(Post.class).field("_id").equal(obj)
				.get();
	}

	public Post findById(ObjectId id) {
		return postDatastore.createQuery(Post.class).field("_id").equal(id)
				.get();
	}

	public List<Post> findByDate(Date _date) {// gestion de la date a voir
		return postDatastore.createQuery(Post.class).field("_date")
				.equal(_date).asList();
	}

	public void updateWholePost(String _id, Post post) {
		Post p = findById(_id);
		post.set_id(p.get_id());
		postDatastore.delete(p);
		postDatastore.save(post);
	}

	public void updateWholePost(ObjectId _id, Post post) {
		Post p = findById(_id);
		post.set_id(p.get_id());
		postDatastore.delete(p);
		postDatastore.save(post);
	}
	
	public void addComment(ObjectId postId, Comment comment) {
		postDatastore
				.update(this.findById(postId),
						postDatastore.createUpdateOperations(Post.class).add(
								"_comments", comment));
	}
	
	public void deleteComment ( ObjectId postId, Comment comment){
		postDatastore.update(
				this.findById(postId),
				postDatastore.createUpdateOperations(Post.class).removeAll(
						"_comments", comment));
	}
	

	public void delete(String id) {
		ObjectId objId = new ObjectId(id);
		postDatastore.delete(Post.class, objId);

	}

	public void delete(ObjectId id) {
		postDatastore.delete(Post.class, id);

	}

	public void delete(Post post) {
		postDatastore.delete(post);

	}

	
	public List<Post> findByIds(List<ObjectId> ids) {
		return postDatastore.createQuery(Post.class).filter("_Id in", ids)
				.order("-_date").asList();
	}
	

	
	public List<Post> findByIdsDateDscWithLimit(List<ObjectId> ids, int limit) {
		return postDatastore.createQuery(Post.class).filter("_Id in", ids)
				.order("-_date").limit(limit).asList();
	}


}
