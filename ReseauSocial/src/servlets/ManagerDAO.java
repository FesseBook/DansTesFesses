package servlets;

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

import model.*;
import dao.*;

public class ManagerDAO {

		Datastore datastore;
	ManagerDAO() throws UnknownHostException{
	
	Morphia morphia = new Morphia();
	morphia.mapPackage("model");
	//morphia.mapPackageFromClass(User.class);
	MongoClientOptions.Builder builder = new MongoClientOptions.Builder().alwaysUseMBeans(true);
	datastore= morphia.createDatastore(	new MongoClient("localhost", builder.build()),"intergiciel");
	
	User user = new User();
	user.set_login("bob");
	user.set_email("email");
	user.set_name("bob");
	user.set_myFriends(new ArrayList<ObjectId>());
	user.set_surname("tom");
	user.set_password("xxxxx");
	
	UserDAO_impl usrDao= new UserDAO_impl(datastore);
	
	usrDao.create(user);
	
	List<User> userlist = usrDao.findUsers();
	int s = userlist.size();
	System.out.println("taille de la liste des users  : " + s);
	
	for (User usr : userlist){
	System.out.println("id :"+ usr.get_id());
	System.out.println("Name :"+ usr.get_name());
	}
	
	User usr1 = userlist.get(0);
	usrDao.delete(usr1.get_id().toString());
	System.out.println("user COllection size should be   : " + (s-1) +" actually is :" +usrDao.findUsers().size());
	
	
	usr1 = userlist.get(1);
	usrDao.delete(usr1.get_id());
	System.out.println("user COllection size should be   : " + (s-2) +" actually is :" +usrDao.findUsers().size());
	
	
	//mongo = new MongoClient(configuration.getEpgMongoDbHost(), builder.build());
	//datastore= morphia.createDatastore(new MongoClient("localhost", 27017), "intergiciel");
	
//	String dbName = new String("intergiciel");
//	Mongo mongo = new Mongo(new MongoURI("//localhost"));
//	Morphia morphia = new Morphia();
//	 datastore = morphia.createDatastore(mongo, dbName);
	
	

}
	
//	public static void main() throws UnknownHostException{
//		
//		ManagerDAO man = new ManagerDAO();
//		UserDAO_impl userDao = new UserDAO_impl(man.datastore) ;
//		
//	}
	
}
