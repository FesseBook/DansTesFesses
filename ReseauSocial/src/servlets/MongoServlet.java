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
import com.google.code.morphia.Morphia;

import dao.UserDAO_impl;

/**
 * Servlet implementation class MongoServlet
 */
public class MongoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CompletionBase cmplB;
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
