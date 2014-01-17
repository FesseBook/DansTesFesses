package controler.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import model.Comment;
import model.Post;

public interface PostDAO {

	
	public void create(Post post) ;
	
	
	public List<Post> findByAuthor(String _author) ;

	public List<Post> findByAuthorId(String _authorId);
	
	public List<Post> findPostedOnDateDsc(String wallEntityType, ObjectId id);
	
	public List<Post> findPostedOnDateDscWithLimit(String wallEntityType, ObjectId id, int limit);

	public List<Post> findByAuthorId(ObjectId _authorId) ;

	public List<Post> findByAuthorIdsDateDsc(List<ObjectId> _authorIds);
	
	public List<Post> findByAuthorIdsDateDscWithLimit(List<ObjectId> _authorIds, int limit);
	
	public Post findById(String _id) ;

	public Post findById(ObjectId id) ;
	
	public List<Post> findByIds( List<ObjectId> ids);

	public List<Post> findByIdsDateDscWithLimit(List<ObjectId> ids, int limit);
	
	public List<Post> findByDate(Date _date);

	public void updateWholePost(String _id, Post post);

	public void updateWholePost(ObjectId _id, Post post) ;
	
	public void addComment(ObjectId postId, Comment comment);
	public void deleteComment ( ObjectId postId, Comment comment);
	

	public void delete(String id) ;
	public void delete(ObjectId id);
	public void delete(Post post) ;
	public List<Post> findByTag(String _tag);

	public List<Post> findByCommentator(String _author);

	public List<Post> findBydCommentatorId(ObjectId _id);
		
}
