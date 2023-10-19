package com.hansixue.tracker.luggage;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
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
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				System.out.println("Command is null!");
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listLuggages(request, response);
				break;
				
			case "ADD":
				addLuggage(request, response);
				break;
		/*		
			case "LOAD":
				loadLuggage(request, response);
				break;
				
			case "UPDATE":
				updateLuggage(request, response);
				break;
			
			case "DELETE":
				deleteLuggage(request, response);
				break;
		*/		
			default:
				System.out.println("defualt command running!");
				listLuggages(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void addLuggage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get data
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		int tagNumber = Integer.parseInt(request.getParameter("tagNumber"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		System.out.println("kepttime on page = "+ request.getParameter("keptTime"));
		Date keptTime = dateFormat.parse(request.getParameter("keptTime"));
		System.out.println("the Date is " + keptTime.toString());
		int keptStuffId = Integer.parseInt(request.getParameter("keptStuffId"));
		// create a luggage
		Luggage theLuggage = new Luggage(tagNumber,amount,keptTime,keptStuffId);
		//System.out.println(theLuggage.toString());
		//add the luggage to database
		luggageDbutil.addLuggage(theLuggage);
		//list all luggage
		listLuggages(request, response);
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
