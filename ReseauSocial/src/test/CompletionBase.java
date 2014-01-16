package test;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Comment;
import model.Post;
import model.User;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;

import dao.PostDAO_impl;
import dao.UserDAO_impl;

public class CompletionBase {
	
	Datastore testDatastore;
	
public CompletionBase() {
};
public void init()throws UnknownHostException{
	Morphia morphia = new Morphia();
	morphia.mapPackage("model");
	MongoClientOptions.Builder builder = new MongoClientOptions.Builder().alwaysUseMBeans(true);
	testDatastore= morphia.createDatastore(	new MongoClient("localhost", builder.build()),"intergiciel");
	

	

UserDAO_impl userDao= new UserDAO_impl(testDatastore);

PostDAO_impl postDao= new PostDAO_impl(testDatastore);

	String prenoms = "Adam/Alex/Alexandre/Alexis/Anthony/Antoine/"
+"Benjamin/Cédric/Charles/Christopher/David/Dylan/Édouard/Elliot/"
+"Émile/Étienne/Félix/Gabriel/Guillaume/Hugo/Isaac/Jacob/Jérémy/"
+"Jonathan/Julien/Justin/Léo/Logan/Loïc/Louis/Lucas/Ludovic/Malik/"
+"Mathieu/Mathis/Maxime/Michaël/Nathan/Nicolas/Noah/Olivier/Philippe/"
+"Raphaël/Samuel/Simon/Thomas/Tommy/Tristan/Victor/Vincent";

	String str[]=prenoms.split("/");
	int length1 =str.length;
	System.out.println("taille de la liste des prenom pour la completion  :"+ length1 + "\n");
	int randomP;
	int randomN ;
		for (int i = 0; i < 50; i++) {
			randomP = (int) (Math.random() * length1);
			randomN = (int) (Math.random() * length1);
			System.out.println("randomP , randomN : " + randomP+" , "+randomN +"\n");
			String name = str[randomP];
			String surname = str[randomN];

			User user = new User();
			user.set_surname(surname);
			user.set_name(name);
			user.set_login(surname+"."+name);
			user.set_email(surname + "." + name + "@book");
			user.set_password(surname + "." + name);

			userDao.create(user);
		}
	
	List<User> userlist = userDao.findUsers();
	int length2 =userlist.size();
	int randomUser;
	for (int i = 0; i < 100; i++) {
		 randomUser = (int) (Math.random() * length2);
		
		System.out.println("randomUser : " + randomUser +"\n");
		User user = userlist.get(randomUser);
		Post post = new Post();
		post.set_author(user.get_login());
		post.set_authorId(user.get_id());
		post.set_date(new Date());
		post.set_postedOnId(user.get_id());
		post.set_postedOnType("_user");
		post.set_comments(new ArrayList<Comment>());
		
				
		String s ="Lorem ipsum dolor sit amet, consectetur"
		+"adipiscing elit. Aenean vehicula sapien vel malesuada"
		+"vulputate. Nam fermentum consectetur nibh, et lobortis "
		+"ipsum interdum vel. Curabitur et massa ut velit vehicula"
		+"pharetra non et neque. Ut vitae arcu metus. Curabitur convallis"
		+"eu magna eget vestibulum. Sed bibendum porttitor ante a lacinia. Mauris"; 
		post.set_body(s);
		System.out.print("\n  ajout d un post en base \n");
		postDao.create(post);
		System.out.print("\n  post ajouté en base \n");
		post = postDao.findPostedOnDateDscWithLimit("_user", user.get_id(), 1);
		System.out.print("\n  post trouvé en base  \n");
		userDao.addPostInvolvedIn(user.get_id(), post.get_id());
		System.out.print("\n  user mis à jour \n");
		System.out.print("=============================== \n =====================");
		
		
		
	}
	
	
}
}