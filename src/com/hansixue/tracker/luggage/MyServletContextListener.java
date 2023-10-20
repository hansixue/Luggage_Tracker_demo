package com.hansixue.tracker.luggage;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

/**
 * Servlet implementation class MyServletContextListener
 */
public class MyServletContextListener extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            AbandonedConnectionCleanupThread.uncheckedShutdown();
        } catch (Exception e) {
            // Handle exceptions
        }
    }


}
