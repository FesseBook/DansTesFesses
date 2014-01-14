package test;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mongodb.*;
import com.google.code.morphia.Morphia;

import dao.UserDAO_impl;

/**
 * Servlet implementation class MongoServlet
 */
public class MongoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ManagerDAO man;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MongoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public void init(ServletConfig config){
    	 try {
			man = new ManagerDAO();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDAO_impl userDao = new UserDAO_impl(man.datastore) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
