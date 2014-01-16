package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;
import model.PostJSP;
import model.User;
import model.UserJSP;
import dao.EJBGestionPost;
import dao.EJBGestionUser;
import dao.UserDAO;

public class Servlet1 extends HttpServlet {

	@EJB
	EJBGestionUser gestionnaireUser;
	
	@EJB
	EJBGestionPost gestionnairePost;
	
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		// Savoir quelle opération on traite
		String operation = request.getParameter("operation");
		
		if (operation.equals("demandeCreation")) {
			request.getRequestDispatcher("CreationUser.html").forward(request, response);
			
		} else if (operation.equals("rechercheUser")) {
			// Quel(s) user(s) rechercher ?
			String userRechercher = request.getParameter("userAChercher");
			String idUserCourant = request.getParameter("idUserCourant");
			User userCourant = gestionnaireUser.getUserById(idUserCourant);
			List<User> usersAmis = gestionnaireUser.recherche(userRechercher);
			List<User> usersAAfficher = gestionnaireUser.getMyFriends(userCourant);
			request.setAttribute("usersAAfficher", usersAAfficher);
			request.setAttribute("usersAmis", usersAmis);
			request.setAttribute("userCourant", userCourant);
			request.getRequestDispatcher("AfficherUsers.jsp").forward(request, response);
			
		} else if (operation.equals("visiterAmi")) {
			// Récupérer l'ami correspondant
			String idFriend = request.getParameter("idFriend");
			String idUserCourant = request.getParameter("idUserCourant");
			User userAmi = gestionnaireUser.getUserById(idFriend);
			User userCourant = gestionnaireUser.getUserById(idUserCourant);
			boolean areFriends = gestionnaireUser.areFriends(userCourant, userAmi);
			List<Post> postsAAfficher = new ArrayList<Post>();
			if (areFriends) {
				postsAAfficher = gestionnairePost.getMyPosts(userAmi);
			}
			List<User> usersAAfficher = gestionnaireUser.getMyFriends(userAmi);
			request.setAttribute("usersAAfficher", usersAAfficher);
			request.setAttribute("postsAAfficher", postsAAfficher);
			request.setAttribute("userCourant", userCourant);
			request.setAttribute("userAmi", userAmi);
			request.getRequestDispatcher("AfficherPost.jsp").forward(request, response);
			
		} else if (operation.equals("retourMonMur")) {
			String idUserCourant = request.getParameter("idUserCourant");
			User userCourant = gestionnaireUser.getUserById(idUserCourant);
			List<Post> postsAAfficher = gestionnairePost.getMyPosts(userCourant);
			List<User> usersAAfficher = gestionnaireUser.getMyFriends(userCourant);
			request.setAttribute("usersAAfficher", usersAAfficher);
			request.setAttribute("postsAAfficher", postsAAfficher);
			request.setAttribute("userCourant", userCourant);
			request.getRequestDispatcher("AfficherPost.jsp").forward(request, response);
			
		}
	}
		
		

	
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		// Savoir quelle opération on traite
		String operation = request.getParameter("operation");
		
		if (operation.equals("creation")) {
			// Récupérer les informations du futur User
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			// Créer le User et le stocker dans la base
			gestionnaireUser.creerUser(name, email, password);
			// IL FAUDRA TESTER LE CAS OU LE NOM EST DEJA PRIS PAR UN AUTRE USER
			User userCourant = gestionnaireUser.getUserByEmail(email);
			List<Post> postsAAfficher = gestionnairePost.getPostsTouslesAmis(userCourant); // normalement, cette liste est vide
			List<User> usersAAfficher = gestionnaireUser.getMyFriends(userCourant); // normalement, cette liste est vide
			request.setAttribute("usersAAfficher", usersAAfficher);
			request.setAttribute("postsAAfficher", postsAAfficher);
			request.setAttribute("userCourant", userCourant);
			request.getRequestDispatcher("AfficherPost.jsp").forward(request, response);
			
		} else if (operation.equals("authentification")) {
			// Récupérer les identifiants du client
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			// Questionner la BD pour savoir si ces identifiants sont valides
			boolean identifiantsValides = gestionnaireUser.emailPasswordValid(email, password);
			if (identifiantsValides) {
				// Récupérer le User correspondant
				User userCourant = gestionnaireUser.getUserByEmail(email);
				List<Post> postsAAfficher = gestionnairePost.getPostsTouslesAmis(userCourant);
				List<User> usersAAfficher = gestionnaireUser.getMyFriends(userCourant);
				request.setAttribute("usersAAfficher", usersAAfficher);
				request.setAttribute("postsAAfficher", postsAAfficher);
				request.setAttribute("userCourant", userCourant);
				request.getRequestDispatcher("AfficherPost.jsp").forward(request, response);
				
			} else {
				// Retourner vers la page d'accueil
				String messageErreur = "Les identifiants saisis sont mauvais !";
				request.setAttribute("messageErreur", messageErreur);
				request.getRequestDispatcher("Accueil.html").forward(request, response);
			}
		} else if (operation.equals("publication")) {
			String body = request.getParameter("body");
			String idUserCourant = request.getParameter("idUserCourant");
			User userCourant = gestionnaireUser.findById(Integer.valueOf(idUserCourant));
			gestionnairePost.creerPost(userCourant, body);
		}
	}

}
