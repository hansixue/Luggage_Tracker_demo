package com.hansixue.tracker.luggage;

import java.io.IOException;	
import javax.sql.DataSource;
import jakarta.annotation.Resource;
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

	private luggageDbUtil luggageDbutil;
	@Resource(name="jdbc/jdbc/luggage_tracker_demo")
	private DataSource dataSource;
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
