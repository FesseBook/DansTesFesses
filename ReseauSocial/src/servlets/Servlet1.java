package servlets;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.CompletionBase;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;

import controler.EJBGestionPost;
import controler.EJBGestionUser;
import controler.EJBPrincipal;
import controler.dao.UserDAO;
import model.GlobalBean;
import model.Post;
//import model.PostJSP;
import model.User;
//import model.UserJSP;

public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	CompletionBase cmplB;
	EJBPrincipal ejbP;
	Datastore datastore;
	GlobalBean gbb;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public void init(ServletConfig config){
	
	
 	Morphia morphia = new Morphia();
	morphia.mapPackage("model");
	MongoClientOptions.Builder builder = new MongoClientOptions.Builder().alwaysUseMBeans(true);
	try {
		datastore= morphia.createDatastore(	new MongoClient("localhost", builder.build()),"intergiciel");
	} catch (UnknownHostException e) {
		e.printStackTrace();
	}
	
	ejbP = new EJBPrincipal(datastore);
	
    }
	
	
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	
		
	
		
		
		
		
		
//		// Savoir quelle op�ration on traite
//		String operation = request.getParameter("operation");
//		
//		if (operation.equals("demandeCreation")) {
//			request.getRequestDispatcher("CreationUser.html").forward(request, response);
//			
//		} else if (operation.equals("rechercheUser")) {
//			// Quel(s) user(s) rechercher ?
//			String userRechercher = request.getParameter("userAChercher");
//			String idUserCourant = request.getParameter("idUserCourant");
//			User userCourant = gestionnaireUser.getUserById(idUserCourant);
//			List<User> usersAmis = gestionnaireUser.recherche(userRechercher);
//			List<User> usersAAfficher = gestionnaireUser.getMyFriends(userCourant);
//			request.setAttribute("usersAAfficher", usersAAfficher);
//			request.setAttribute("usersAmis", usersAmis);
//			request.setAttribute("userCourant", userCourant);
//			request.getRequestDispatcher("AfficherUsers.jsp").forward(request, response);
//			
//		} else if (operation.equals("visiterAmi")) {
//			// R�cup�rer l'ami correspondant
//			String idFriend = request.getParameter("idFriend");
//			String idUserCourant = request.getParameter("idUserCourant");
//			User userAmi = gestionnaireUser.getUserById(idFriend);
//			User userCourant = gestionnaireUser.getUserById(idUserCourant);
//			boolean areFriends = gestionnaireUser.areFriends(userCourant, userAmi);
//			List<Post> postsAAfficher = new ArrayList<Post>();
//			if (areFriends) {
//				postsAAfficher = gestionnairePost.getMyPosts(userAmi);
//			}
//			List<User> usersAAfficher = gestionnaireUser.getMyFriends(userAmi);
//			request.setAttribute("usersAAfficher", usersAAfficher);
//			request.setAttribute("postsAAfficher", postsAAfficher);
//			request.setAttribute("userCourant", userCourant);
//			request.setAttribute("userAmi", userAmi);
//			request.getRequestDispatcher("AfficherPost.jsp").forward(request, response);
//			
//		} else if (operation.equals("retourMonMur")) {
//			String idUserCourant = request.getParameter("idUserCourant");
//			User userCourant = gestionnaireUser.getUserById(idUserCourant);
//			List<Post> postsAAfficher = gestionnairePost.getMyPosts(userCourant);
//			List<User> usersAAfficher = gestionnaireUser.getMyFriends(userCourant);
//			request.setAttribute("usersAAfficher", usersAAfficher);
//			request.setAttribute("postsAAfficher", postsAAfficher);
//			request.setAttribute("userCourant", userCourant);
//			request.getRequestDispatcher("AfficherPost.jsp").forward(request, response);
//			
//		}
	}
		
		

	
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
	 	Morphia morphia = new Morphia();
		morphia.mapPackage("model");
		//morphia.mapPackageFromClass(User.class);
		MongoClientOptions.Builder builder = new MongoClientOptions.Builder().alwaysUseMBeans(true);
		try {
			datastore= morphia.createDatastore(	new MongoClient("localhost", builder.build()),"intergiciel");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ejbP = new EJBPrincipal(datastore);
	    
		
		// Savoir quelle op�ration on traite
		String operation = request.getParameter("operation");
		
		if (operation.equals("inscription")) {
			// R�cup�rer les informations du futur User
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			System.out.print(" \n \n \n \n");
			System.out.print("Vérification du couple email mot de passe");
			System.out.print(" \n \n \n \n");

			/****************************************/
			/*                                      */
			/* PARTIE A METTRE DANS EJBPrincipal    */
			/*                                      */
			/****************************************/
			
			if (!ejbP.USERemailPasswordValid(email, password)) {
				ejbP.createUser(name, "surname", email, password);
				
				System.out.print(" \n \n ");
				System.out.print("l'email n'existait pas on a crée l'utilisateur sans erreur");
				System.out.print(" \n \n ");

				List<User> lUser = (ArrayList<User>) ejbP
						.USERfindByEmail(email);
				
				if (lUser != null) {
					System.out
							.print("recherche user par email passe sans erreur");
					

					if (lUser.isEmpty()) {
						System.out
								.println("la recherche par email a renvoyé une liste vide \n ");
					} else {
						
						User user1 = lUser.get(0);
//						System.out
//						.println(user1.toString());
						gbb = ejbP.createGlobalBean(user1);
//						System.out
//						.println(gbb.toString());
					}

				} else {
					System.out.print("recherche user par email erreur");
				}
			} else {
				System.out.print(" \n l 'utilisateur existe deja ");
			}
			
			
			

		}
		
		else if (operation.equals("login")){
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			if (!ejbP.USERemailPasswordValid(email, password)) {
				
				List<User> lUser = (ArrayList<User>) ejbP
						.USERfindByEmail(email);
				
				if (lUser != null) {
					System.out
							.print("recherche user par email passe sans erreur");
					

					if (lUser.isEmpty()) {
						System.out
								.println("la recherche par email a renvoyé une liste vide \n ");
					} else {
						
						User user1 = lUser.get(0);
//						System.out
//						.println(user1.toString());
						
						
						/**************************************/
						/*                                    */
						/*        SESSION A CREER ?           */
						/**************************************/
						
						
						
						gbb = ejbP.createGlobalBean(user1);
//						System.out
//						.println(gbb.toString());
					}

				} else {
					System.out.print("recherche user par email erreur");
				}
				
			}else{
				//rediriger ou informer la page d'accueil que l 'utilisateur n 'existe pas
			}
			
			
		}

		// TO DO checker que la combinaison email n'existe pas
		// Creer l user
		// Instancier une session
		// Stocker l'user dans une instance User pour avoir ses attributs en
		// cache
		// Ajouter les Attribut à la requête
		// Rediriger vers le home

		// /* // Cr�er le User et le stocker dans la base
		// gestionnaireUser.creerUser(name, email, password);
		// // IL FAUDRA TESTER LE CAS OU LE NOM EST DEJA PRIS PAR UN AUTRE USER
		// User userCourant = gestionnaireUser.getUserByEmail(email);
		// List<Post> postsAAfficher =
		// gestionnairePost.getPostsTouslesAmis(userCourant); // normalement,
		// cette liste est vide
		// List<User> usersAAfficher =
		// gestionnaireUser.getMyFriends(userCourant); // normalement, cette
		// liste est vide
		// request.setAttribute("usersAAfficher", usersAAfficher);
		// request.setAttribute("postsAAfficher", postsAAfficher);
		// request.setAttribute("userCourant", userCourant);
		// request.getRequestDispatcher("AfficherPost.jsp").forward(request,
		// response);
		// */
		//
		// } else if (operation.equals("authentification")) {
		// // R�cup�rer les identifiants du client
		// String email = request.getParameter("email");
		// String password = request.getParameter("password");
		// // Questionner la BD pour savoir si ces identifiants sont valides
		// boolean identifiantsValides =
		// gestionnaireUser.emailPasswordValid(email, password);
		// if (identifiantsValides) {
		//
		// // Créer une session
		// // R�cup�rer le User correspondant
		// // Récupérer les infos relatives à ses amis
		// // Récupérer ses post et ou ses pictures et ou les post de ses amis
		// //rediriger vers le home
		//
		//
		// User userCourant = gestionnaireUser.getUserByEmail(email);
		// List<Post> postsAAfficher =
		// gestionnairePost.getPostsTouslesAmis(userCourant);
		// List<User> usersAAfficher =
		// gestionnaireUser.getMyFriends(userCourant);
		// request.setAttribute("usersAAfficher", usersAAfficher);
		// request.setAttribute("postsAAfficher", postsAAfficher);
		// request.setAttribute("userCourant", userCourant);
		// request.getRequestDispatcher("AfficherPost.jsp").forward(request,
		// response);
		//
		// } else {
		// // Retourner vers la page d'accueil
		// String messageErreur = "Les identifiants saisis sont mauvais !";
		// request.setAttribute("messageErreur", messageErreur);
		// request.getRequestDispatcher("Accueil.html").forward(request,
		// response);
		// }
		//
		// ///////////////////////////////////////////////////////////////////////////////////////////////////
		// //Créer une autre servlet pour le fonctionnement courant gérer la
		// conservation de la session d'une servlet à l 'autre
		// ///////////////////////////////////////////////////////////////////////////////////////////////////
		//
		//
		// } /*else if (operation.equals("publication")) {
		// String body = request.getParameter("body");
		// String idUserCourant = request.getParameter("idUserCourant");
		// User userCourant =
		// gestionnaireUser.findById(Integer.valueOf(idUserCourant));
		// gestionnairePost.creerPost(userCourant, body);
		// } */
	}

}

