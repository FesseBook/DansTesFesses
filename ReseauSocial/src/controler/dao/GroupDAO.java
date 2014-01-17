package controler.dao;

import java.util.List;

import model.Group;

import org.bson.types.ObjectId;

public interface GroupDAO {
	
	public void create(Group group) ;

	public Group findById(String id) ;

	public Group findById(ObjectId id);

	public List<Group> findGroups() ;

	public List<Group> findGroupsWithLimit(int limit);

	// /////////////////////////////////////////////

	public List<Group> findByName(String name) ;

	public List<Group> findByNames(List<String> names) ;

	public List<Group> findByNamesWithLimit(List<String> names, int limit) ;

	public List<Group> findByNameWithLimit(String name, int limit) ;

	// /////////////////// ONE TO MANY //////////////////////////

	public Group findByPostId(String postId) ;

	public Group findByPostId(ObjectId postId) ;

	public List<Group> findByPostsId(List<ObjectId> postId) ;

	public List<Group> findByPostsIdWithLimit(List<ObjectId> postIds, int limit) ;

	// ///////////////////////// MANY TO MANY /////////////////////

	public List<Group> findByMemberId(String memberId) ;

	public List<Group> findByMemberId(ObjectId memberId) ;

	public List<Group> findByMembersId(List<ObjectId> membersId) ;

	public List<Group> findByMemberIdWithLimit(String memberId, int limit) ;

	public List<Group> findByMembersIdWithLimit(List<ObjectId> memberIds,
			int limit) ;

	// //////////////////////// ONE TO MANY ///////////////////////////

	public Group findByPictureId(String pictureId);

	public Group findByPictureId(ObjectId pictureId) ;

	public List<Group> findByPicturesId(List<ObjectId> picturesId) ;

	public List<Group> findByPicturesIdWithLimit(List<ObjectId> pictureIds,
			int limit) ;

	public List<Group> findByAdminId(String adminId) ;

	public List<Group> findByAdminId(ObjectId adminId);

	public List<Group> findByAdminsId(List<ObjectId> adminsId) ;

	public List<Group> findByAdminIdWithLimit(String adminId, int limit) ;

	public List<Group> findByAdminsIdWithLimit(List<ObjectId> adminIds,
			int limit) ;
	
	
	
	public void update(int id, Group Group) ;

	public void delete(String id);

	public void delete(ObjectId id);
}
