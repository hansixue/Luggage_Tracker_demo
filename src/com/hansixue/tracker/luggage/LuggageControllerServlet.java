package com.hansixue.tracker.luggage;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class LuggageControllerServlet
 */
@WebServlet("/LuggageControllerServlet")
public class LuggageControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LuggageDbUtil luggageDbutil;
	@Resource(name="jdbc/luggage_tracker_demo")
	private DataSource dataSource;
	


	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
        try {
            luggageDbutil = new LuggageDbUtil(dataSource);
        }
        catch (Exception exc) {
            throw new ServletException(exc);
        }
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
				listLuggages(request, response);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		

	}

	private void listLuggages(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get students from db util
		List<Luggage> luggages = luggageDbutil.getLuggages("select * from guest_luggage;");
		
		// add students to the request
		request.setAttribute("LUGGAGE_LIST", luggages);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listall.jsp");
		dispatcher.forward(request, response);
		
	}



}
