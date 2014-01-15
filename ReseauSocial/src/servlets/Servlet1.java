package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;
import model.User;
//import dao.EJBGestionPost;
import dao.EJBGestionUser;
import dao.UserDAO;

public class Servlet1 extends HttpServlet {
//
//
//	@EJB
//	EJBGestionUser gestionnaireUser;
//	
//	@EJB
//	EJBGestionPost gestionnairePost;
//	
//	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
//		
//		// Savoir quelle op�ration on traite
//		String operation = request.getParameter("operation");
//		
//		if (operation.equals("demandeCreation")) {
//			request.getRequestDispatcher("CreationUser.html").forward(request, response);
//			
//		} else if (operation.equals("rechercheUser")) {
//			// Quel(s) user(s) rechercher ?
//			String userRechercher = request.getParameter("aChercher");
//			List<User> usersAAfficher = gestionnaireUser.recherche(userRechercher);
//			request.setAttribute("usersAAfficher", usersAAfficher);
//			request.getRequestDispatcher("AfficherUsers.jsp").forward(request, response);
//			
//		} else if (operation.equals("visiterAmi")) {
//			// R�cup�rer l'ami correspondant
//			int idAmi = Integer.valueOf(request.getParameter("idAmiChoisi"));
//			User userAmi = gestionnaireUser.findById(idAmi);
//			List<Post> postsAmi = gestionnairePost.getPostsUnAmi(userAmi);
//			request.setAttribute("postsAAfficher", postsAmi);
//			request.getRequestDispatcher("AfficherPosts.jsp");
//			
//		} else if (operation.equals("retourMonMur")) {
//			int monId = Integer.valueOf(request.getParameter("monId"));
//			User monUser = gestionnaireUser.findById(monId);
//			List<Post> mesPosts = gestionnairePost.getMyPosts(monUser);
//			request.getRequestDispatcher("AfficherPosts.jsp");
			
		}
		
		

//
//	@EJB
//	EJBGestionUser gestionnaireUser;
//	
	
//	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
//		
//		// Savoir quelle op�ration on traite
//		String operation = request.getParameter("operation");
//		
//		if (operation.equals("demandeCreation")) {
//			// Est ce qu'on ne peut pas plut�t passer directement de la page Accueil.html � la page qui sert � cr�er un compte ?
//			request.getRequestDispatcher("CreationUser.html").forward(request, response);
//		}
//		
//		
//
//	}
	
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
//<<<<<<< HEAD
//		// Savoir quelle op�ration on traite
//		String operation = request.getParameter("operation");
//		
//		if (operation.equals("creation")) {
//			// R�cup�rer les informations du futur User
//			String name = request.getParameter("name");
//			String email = request.getParameter("email");
//			String password = request.getParameter("password");
//			// Cr�er le User et le stocker dans la base
//			gestionnaireUser.creerUser(name, email, password);
//			// IL FAUDRA TESTER LE CAS OU LE NOM EST DEJA PRIS PAR UN AUTRE USER
//			List<Post> postsAAfficher = new ArrayList<Post>();
//			User userCourant = 
//			request.setAttribute("postsAAfficher", postsAAfficher);
//			request.getRequestDispatcher("AfficherPost.jsp").forward(request, response);
//			
//		} else if (operation.equals("authentification")) {
//			// R�cup�rer les identifiants du client
//			String login = request.getParameter("login");
//			String password = request.getParameter("password");
//			// Questionner la BD pour savoir si ces identifiants sont valides
//			boolean identifiantsValides = gestionnaireUser.identifiantsValides(login, password);
//			if (identifiantsValides) {
//				// R�cup�rer le User correspondant
//				User user = gestionnaireUser.getUserByLogin(login);
//				// R�cup�rer la liste des posts de ses amis
//				List<Post> postsAmis = gestionnaireUser.getPostsTouslesAmis(user);
//				request.setAttribute("listePost", postsAmis);
//				request.getRequestDispatcher("AfficherPost.jsp").forward(request, response);
//				
//			} else {
//				// Retourner vers la page d'accueil
//				request.getRequestDispatcher("Accueil.html").forward(request, response);
//			}
//		}
//=======
////		// Savoir quelle op�ration on traite
////		String operation = request.getParameter("operation");
////		
////		if (operation.equals("creation")) {
////			// R�cup�rer les informations du futur User
////			String name = request.getParameter("name");
////			String email = request.getParameter("email");
////			String password = request.getParameter("password");
////			// Cr�er le User et le stocker dans la base
////			gestionnaireUser.creerUser(name, email, password);
////			// IL FAUDRA TESTER LE CAS OU LE NOM EST DEJA PRIS PAR UN AUTRE USER
////			
////		} else if (operation.equals("authentification")) {
////			// R�cup�rer les identifiants du client
////			String login = request.getParameter("login");
////			String password = request.getParameter("password");
////			// Questionner la BD pour savoir si ces identifiants sont valides
////			boolean identifiantsValides = gestionnaireUser.identifiantsValides(login, password);
////			if (identifiantsValides) {
////				// R�cup�rer le User correspondant
////				User user = gestionnaireUser.getUserByLogin(login);
////				// R�cup�rer la liste des posts de ses amis
////				List<Post> postsAmis = gestionnaireUser.getPostsAmis(user);
////				request.setAttribute("listePost", postsAmis);
////				request.getRequestDispatcher("AfficherPost.jsp").forward(request, response);
////				
////			} else {
////				// Retourner vers la page d'accueil
////				request.getRequestDispatcher("Accueil.html").forward(request, response);
////			}
////		} else if (operation.equals("visiterAmi")) {
////			// R�cup�rer l'ami correspondant
////			int idAmi = Integer.valueOf(request.getParameter("idAmiChoisi"));
////			User userAmi = gestionnaireUser.findById(idAmi);
////		}
//>>>>>>> 0855835561b6072b4a9b1c8ad83756d6bf2550e8
	}
}
