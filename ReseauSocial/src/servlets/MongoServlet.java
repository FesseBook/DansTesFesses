package servlets;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.CompletionBase;
import test.ManagerDAO;

import com.mongodb.*;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;

import controler.EJBPrincipal;
import controler.dao.dao_impl.UserDAO_impl;

/**
 * Servlet implementation class MongoServlet
 */
public class MongoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CompletionBase cmplB;
	EJBPrincipal ejbP;
	Datastore datastore;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MongoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public void init(ServletConfig config){
    	
    	
    	////////////////// Completion de la base /////////////////////
    	 try {
    		 cmplB = new CompletionBase();
    		 System.out.println("BeforeCompletionBase");
    			cmplB.init();
			System.out.println("CompletionBase");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	///////////////////////////////////////////////////////////////////////////////////
//    	
//    	Morphia morphia = new Morphia();
//    	morphia.mapPackage("model");
//    	//morphia.mapPackageFromClass(User.class);
//    	MongoClientOptions.Builder builder = new MongoClientOptions.Builder().alwaysUseMBeans(true);
//    	try {
//			datastore= morphia.createDatastore(	new MongoClient("localhost", builder.build()),"intergiciel");
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	
//    	
//    	ejbP = new EJBPrincipal(datastore);
    	//////////////////////////////////////////////////////////////////////////////////////
    	
    	ManagerDAO man;
//		try {
//			man = new ManagerDAO();
//			man.initTest1();
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		try {
//			man = new ManagerDAO();
//			man.initTest2();
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
