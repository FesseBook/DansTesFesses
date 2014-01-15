package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;
import model.User;
import dao.EJBGestionUser;
import dao.UserDAO;

public class Servlet1 extends HttpServlet {
//
//	@EJB
//	EJBGestionUser gestionnaireUser;
//	
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
//		// Savoir quelle op�ration on traite
//		String operation = request.getParameter("operation");
//		
//		if (operation.equals("demandeCreation")) {
//			// Est ce qu'on ne peut pas plut�t passer directement de la page Accueil.html � la page qui sert � cr�er un compte ?
//			request.getRequestDispatcher("CreationUser.html").forward(request, response);
//		}
//		
//		
	}
	
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
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
//				List<Post> postsAmis = gestionnaireUser.getPostsAmis(user);
//				request.setAttribute("listePost", postsAmis);
//				request.getRequestDispatcher("AfficherPost.jsp").forward(request, response);
//				
//			} else {
//				// Retourner vers la page d'accueil
//				request.getRequestDispatcher("Accueil.html").forward(request, response);
//			}
//		} else if (operation.equals("visiterAmi")) {
//			// R�cup�rer l'ami correspondant
//			int idAmi = Integer.valueOf(request.getParameter("idAmiChoisi"));
//			User userAmi = gestionnaireUser.findById(idAmi);
//		}
	}
}
