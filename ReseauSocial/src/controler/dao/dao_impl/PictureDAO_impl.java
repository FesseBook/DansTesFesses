package controler.dao.dao_impl;

import java.util.List;

import model.Group;
import model.Picture;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;

import controler.dao.PictureDAO;

public class PictureDAO_impl implements PictureDAO{
	
Datastore pictureDatastore;
	
	public	PictureDAO_impl(Datastore dataStore){
			pictureDatastore = dataStore;
		}
	
	public void create( Picture Picture){
		pictureDatastore.save(Picture);
	};
	
	
	public Picture findById(String id){
		ObjectId objId = new ObjectId(id);
		return pictureDatastore.createQuery(Picture.class).field("_id").equal(objId).get();
	}
	public Picture findById(ObjectId id){
		return pictureDatastore.createQuery(Picture.class).field("_id").equal(id).get();
	}
	
	public List<Picture> findByIds(List<ObjectId> ids){
		return pictureDatastore.createQuery(Picture.class).filter("_id in", ids).asList();
	};
	
	public List<Picture> findByIdsWithLimit(List<ObjectId> ids,int limit){
		return pictureDatastore.createQuery(Picture.class).filter("_id in", ids).limit(limit).asList();
	};
	
	
	///////////////////////////////////////////////
	
	public List<Picture> findPictures(){
		return pictureDatastore.createQuery(Picture.class).asList();
	};
	public List<Picture> findPicturesWithLimit(int limit){
		return pictureDatastore.createQuery(Picture.class).limit(limit).asList();
	};
	///////////////////////////////////////////////
	
	public List<Picture> findByName(String name){
		return pictureDatastore.createQuery(Picture.class).field("_name").equal(name).asList();
	};
	
	
	public List<Picture> findByNameWithLimit(String name, int limit){
		return pictureDatastore.createQuery(Picture.class).field("_name").equal(name).limit(limit).asList();
	};
	
	public List<Picture> findByNames(List<String> names){
		return pictureDatastore.createQuery(Picture.class).filter("_name in", names).asList();
	};
	
	
	public List<Picture> findByNamesWithLimit(List<String> names, int limit){
		return pictureDatastore.createQuery(Picture.class).filter("_name in", names).limit(limit).asList();
	};
	///////////////////////////////////////////////
	
	public List<Picture> findByAuthor(String author){
		return pictureDatastore.createQuery(Picture.class).field("_author").equal(author).asList();
	};
	
	public List<Picture> findByAuthors(List<String> authors){
		return pictureDatastore.createQuery(Picture.class).filter("_author in", authors).asList();
	};
	
	
	public List<Picture> findByAuthorWithLimit(String author, int limit){
		return pictureDatastore.createQuery(Picture.class).field("_author").equal(author).limit(limit).asList();
	};
	
	public List<Picture> findByAuthorsWithLimit(List<String> authors, int limit){
		return pictureDatastore.createQuery(Picture.class).filter("_author in", authors).limit(limit).asList();
	};
	////////////////////////////////////////////////


	public List<Picture> findByAuthorId(String authorId){
		ObjectId objId = new ObjectId(authorId);
		return pictureDatastore.createQuery(Picture.class).field("_authorId").equal(objId).asList();
	};
	
	public List<Picture> findByAuthorId(ObjectId authorId){
		return pictureDatastore.createQuery(Picture.class).field("_authorId").equal(authorId).asList();
	};
	
	public List<Picture> findByAuthorsId(List<ObjectId> authorsId){
		return pictureDatastore.createQuery(Picture.class).filter("_authorId in", authorsId).asList();
	};
	public List<Picture> findByAuthorsIdWithLimit(List<ObjectId> authorsId, int limit){
		return pictureDatastore.createQuery(Picture.class).filter("_authorId in", authorsId).limit(limit).asList();
	};
	
	public List<Picture> findByAuthorIdWithLimit(String authorId, int limit){
		ObjectId objId = new ObjectId(authorId);
		return pictureDatastore.createQuery(Picture.class).field("_authorId").equal(objId).limit(limit).asList();
	};
	
	public List<Picture> findByAuthorIdWithLimit(ObjectId authorId, int limit){
		return pictureDatastore.createQuery(Picture.class).field("_authorId").equal(authorId).limit(limit).asList();
	};
	
	
	
	/////////////////// Tous les updates qui nous interessent  A voir ///////////////////////
	public int update(int id, Picture Picture){
		return 0;
	};
	
	//////////////////////// TO DO ////////////////////////////////
	/*
	 *
	 * 
	 *
	 *
	 *
	 *
	 *///////////////////////////////////////////////////////////////
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////
	public void delete(String id){
			ObjectId objId = new ObjectId(id);
			pictureDatastore.delete(Picture.class, objId);
		
	}
	
	public void delete(ObjectId id){
		pictureDatastore.delete(Picture.class, id);
	
}

}
