package dao;

import java.util.List;

import org.bson.types.ObjectId;

import model.Group;

import model.Group;

import com.google.code.morphia.Datastore;

public class GroupDAO_impl implements GroupDAO{

	
	Datastore groupDatastore;

	public GroupDAO_impl(Datastore dataStore) {
		groupDatastore = dataStore;
	}

	public void create(Group group) {
		groupDatastore.save(group);
	};

	public Group findById(String id) {
		ObjectId objId = new ObjectId(id);
		return groupDatastore.createQuery(Group.class).field("_id")
				.equal(objId).get();
	}

	public Group findById(ObjectId id) {
		return groupDatastore.createQuery(Group.class).field("_id").equal(id)
				.get();
	}

	public List<Group> findGroups() {
		return groupDatastore.createQuery(Group.class).asList();
	};

	public List<Group> findGroupsWithLimit(int limit) {
		return groupDatastore.createQuery(Group.class).limit(limit).asList();
	};

	// /////////////////////////////////////////////

	public List<Group> findByName(String name) {
		return groupDatastore.createQuery(Group.class).field("_name")
				.equal(name).asList();
	};

	public List<Group> findByNames(List<String> names) {
		return groupDatastore.createQuery(Group.class)
				.filter("_name in", names).asList();
	};

	public List<Group> findByNamesWithLimit(List<String> names, int limit) {
		return groupDatastore.createQuery(Group.class)
				.filter("_name in", names).limit(limit).asList();
	};

	public List<Group> findByNameWithLimit(String name, int limit) {
		return groupDatastore.createQuery(Group.class).field("_name")
				.equal(name).limit(limit).asList();
	};

	// /////////////////// ONE TO MANY //////////////////////////

	public Group findByPostId(String postId) {
		ObjectId objId = new ObjectId(postId);
		return groupDatastore.createQuery(Group.class).field("_postsId")
				.hasThisElement(objId).get();
	};

	public Group findByPostId(ObjectId postId) {
		return groupDatastore.createQuery(Group.class).field("_postsId")
				.hasThisElement(postId).get();
	};

	public List<Group> findByPostsId(List<ObjectId> postId) {
		return groupDatastore.createQuery(Group.class).field("_postsId")
				.hasAnyOf(postId).asList();
	};

	public List<Group> findByPostsIdWithLimit(List<ObjectId> postIds, int limit) {
		return groupDatastore.createQuery(Group.class).field("_postsId")
				.hasAnyOf(postIds).limit(limit).asList();
	};

	// ///////////////////////// MANY TO MANY /////////////////////

	public List<Group> findByMemberId(String memberId) {
		ObjectId objId = new ObjectId(memberId);
		return groupDatastore.createQuery(Group.class).field("_membersId")
				.hasThisElement(objId).asList();
	};

	public List<Group> findByMemberId(ObjectId memberId) {
		return groupDatastore.createQuery(Group.class).field("_membersId")
				.hasThisElement(memberId).asList();
	};

	public List<Group> findByMembersId(List<ObjectId> membersId) {
		return groupDatastore.createQuery(Group.class).field("_membersId")
				.hasAnyOf(membersId).asList();
	};

	public List<Group> findByMemberIdWithLimit(String memberId, int limit) {
		ObjectId objId = new ObjectId(memberId);
		return groupDatastore.createQuery(Group.class).field("_membersId")
				.hasThisElement(objId).limit(limit).asList();
	};

	public List<Group> findByMembersIdWithLimit(List<ObjectId> memberIds,
			int limit) {
		return groupDatastore.createQuery(Group.class).field("_membersId")
				.hasAnyOf(memberIds).limit(limit).asList();
	};

	// //////////////////////// ONE TO MANY ///////////////////////////

	public Group findByPictureId(String pictureId) {
		ObjectId objId = new ObjectId(pictureId);
		return groupDatastore.createQuery(Group.class).field("_picturesId")
				.hasThisElement(objId).get();
	};

	public Group findByPictureId(ObjectId pictureId) {
		return groupDatastore.createQuery(Group.class).field("_picturesId")
				.hasThisElement(pictureId).get();
	};

	public List<Group> findByPicturesId(List<ObjectId> picturesId) {
		return groupDatastore.createQuery(Group.class).field("_picturesId")
				.hasAnyOf(picturesId).asList();
	};

	public List<Group> findByPicturesIdWithLimit(List<ObjectId> pictureIds,
			int limit) {
		return groupDatastore.createQuery(Group.class).field("_postsId")
				.hasAnyOf(pictureIds).limit(limit).asList();
	};

	// ///////////////////////// MANY TO MANY /////////////////////

	public List<Group> findByAdminId(String adminId) {
		ObjectId objId = new ObjectId(adminId);
		return groupDatastore.createQuery(Group.class).field("_adminsId")
				.hasThisElement(objId).asList();
	};

	public List<Group> findByAdminId(ObjectId adminId) {
		return groupDatastore.createQuery(Group.class).field("_adminsId")
				.hasThisElement(adminId).asList();
	};

	public List<Group> findByAdminsId(List<ObjectId> adminsId) {
		return groupDatastore.createQuery(Group.class).field("_adminsId")
				.hasAnyOf(adminsId).asList();
	};

	public List<Group> findByAdminIdWithLimit(String adminId, int limit) {
		ObjectId objId = new ObjectId(adminId);
		return groupDatastore.createQuery(Group.class).field("_adminsId")
				.hasThisElement(objId).limit(limit).asList();
	};

	public List<Group> findByAdminsIdWithLimit(List<ObjectId> adminIds,
			int limit) {
		return groupDatastore.createQuery(Group.class).field("_adminsId")
				.hasAnyOf(adminIds).limit(limit).asList();
	};
	
	
	
	
	
	// ///////////////// Tous les updates qui nous interessent A voir
	// ///////////////////////
	public void update(int id, Group Group) {

	};

	public void delete(String id) {
		ObjectId objId = new ObjectId(id);
		groupDatastore.delete(Group.class, objId);

	}

	public void delete(ObjectId id) {
		groupDatastore.delete(Group.class, id);

	}
	
}
