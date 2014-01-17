package controler.dao;

import java.util.List;

import model.Picture;

import org.bson.types.ObjectId;

public interface PictureDAO {
	
	public void create( Picture Picture);
	
	
	public Picture findById(String id);
	public Picture findById(ObjectId id);
	
	public List<Picture> findByIds(List<ObjectId> ids);
	
	public List<Picture> findByIdsWithLimit(List<ObjectId> ids,int limit);
	
	
	///////////////////////////////////////////////
	
	public List<Picture> findPictures();
	public List<Picture> findPicturesWithLimit(int limit);
	///////////////////////////////////////////////
	
	public List<Picture> findByName(String name);
	
	
	public List<Picture> findByNameWithLimit(String name, int limit);
	
	public List<Picture> findByNames(List<String> names);
	
	
	public List<Picture> findByNamesWithLimit(List<String> names, int limit);
	///////////////////////////////////////////////
	
	public List<Picture> findByAuthor(String author);
	
	public List<Picture> findByAuthors(List<String> authors);
	
	
	public List<Picture> findByAuthorWithLimit(String author, int limit);
	
	public List<Picture> findByAuthorsWithLimit(List<String> authors, int limit);
	////////////////////////////////////////////////


	public List<Picture> findByAuthorId(String authorId);
	
	public List<Picture> findByAuthorId(ObjectId authorId);
	
	public List<Picture> findByAuthorsId(List<ObjectId> authorsId);
	public List<Picture> findByAuthorsIdWithLimit(List<ObjectId> authorsId, int limit);
	
	public List<Picture> findByAuthorIdWithLimit(String authorId, int limit);
	
	public List<Picture> findByAuthorIdWithLimit(ObjectId authorId, int limit);
	
	public int update(int id, Picture Picture);	
	
	public void delete(String id);
	
	public void delete(ObjectId id);

}
