package test;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoURI;

import controler.dao.dao_impl.PostDAO_impl;
import controler.dao.dao_impl.UserDAO_impl;
import model.*;


public class ManagerDAO {

		Datastore datastore;
		
	public ManagerDAO() throws UnknownHostException{
	
	Morphia morphia = new Morphia();
	morphia.mapPackage("model");
	//morphia.mapPackageFromClass(User.class);
	MongoClientOptions.Builder builder = new MongoClientOptions.Builder().alwaysUseMBeans(true);
	datastore= morphia.createDatastore(	new MongoClient("localhost", builder.build()),"intergiciel");
	}
	
	public void initTest1(){
	
	////////////////////////////////////////////////
	/*											  */
	/*					TEST					  */
	/*											  */
	/*											  */
	////////////////////////////////////////////////
	 
	
	
	UserDAO_impl usrDao= new UserDAO_impl(datastore);
	PostDAO_impl postDao= new PostDAO_impl(datastore);
	
	
	
	List<User> userlist = usrDao.findUsers();
	int s = userlist.size();
	System.out.println("taille de la liste des users  : " + s);
	
	List<ObjectId> myUserIdList = new ArrayList<ObjectId>();
	System.out.println("Les 4 users dont les posts nous interressent sont : ");
	for (int i=0; i<=3; i++){
	System.out.println("id : "+ userlist.get(i).get_id() + " Name :"+ userlist.get(i).get_name() + " SurnName :"+ userlist.get(i).get_surname());
	myUserIdList.add(userlist.get(i).get_id());
	}
	
	List<Post> resultPostL = postDao.findByAuthorIdsDateDsc(myUserIdList);
	for(Post p : resultPostL){
	System.out.print("Author : " +p.get_author() + "  authorId : "+ p.get_authorId());
	System.out.print("\n\n\n\n");
	}
	

}
	
	
	
	public void initTest2(){
		
	////////////////////////////////////////////////
	/*											  */
	/*					TEST					  */
	/*											  */
	/*											  */
	////////////////////////////////////////////////
		
		UserDAO_impl usrDao= new UserDAO_impl(datastore);
		PostDAO_impl postDao= new PostDAO_impl(datastore);
		
		
		
		List<User> userlist = usrDao.findUsers();
		int s = userlist.size();
		System.out.println("taille de la liste des users  : " + s);
		
		List<ObjectId> myUserIdList = new ArrayList<ObjectId>();
		System.out.println("Les 4 users qui nous interesse sont : ");
		for (int i = 0; i <= 3; i++) {
			System.out.println("id : " + userlist.get(i).get_id() + " Name :"
					+ userlist.get(i).get_name() + " SurnName :"
					+ userlist.get(i).get_surname());

			Boolean res = usrDao.emailPasswordValid(
					userlist.get(i).get_surname() + "."
							+ userlist.get(i).get_name() + "@book", userlist
							.get(i).get_surname()
							+ "."
							+ userlist.get(i).get_name());
			System.out.println("test connection  : " + res.toString());
		}
		
	}
		
	
//	public static void main() throws UnknownHostException{
//		
//		ManagerDAO man = new ManagerDAO();
//		UserDAO_impl userDao = new UserDAO_impl(man.datastore) ;
//		
//	}
	
}
