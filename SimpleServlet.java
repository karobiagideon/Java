package org.kinyanjui.sentinelle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "A simple servlet demo", urlPatterns = { "/SimpleServlet" },
		initParams = {@WebInitParam(name = "defaultUser", value = "John Doe")}		
		)
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * System.out.println() will display any content added to it
		 * in tomcat's log files
		 */
		
		System.out.println("Hello from GET method");
		
		PrintWriter writer = response.getWriter();
		
		writer.println("<h1>Good evening</h1>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");		
		PrintWriter writer = response.getWriter();
		
		String jina = request.getParameter("userName");
		
		/*
		 * To retrieve a session object, we use the request object to call the getSession() method
		 * This is going to be attached to an object of type HttpSession
		 * With this, a session is created per user/machine
		 */

		/*
		
			Provides a way to identify a user across more than one page request or visit to a Web site and to store information about that user.

			The servlet container uses this interface to create a session between an HTTP client and an HTTP server. The session persists for a specified time period, across more than one connection or page request from the user. A session usually corresponds to one user, who may visit a site many times. The server can maintain a session in many ways such as using cookies or rewriting URLs.

			This interface allows servlets to

			View and manipulate information about a session, such as the session identifier, creation time, and last accessed time

			Bind objects to sessions, allowing user 

			information to persist across multiple user connections

			When an application stores an object in or removes an object from a session, the session checks whether the object implements HttpSessionBindingListener. If it does, the servlet notifies the object that it has been bound to or unbound from the session. Notifications are sent after the binding methods complete. For session that are invalidated or expire, notifications are sent after the session has been invalidated or expired.

			When container migrates a session between VMs in a distributed container setting, all session attributes implementing the HttpSessionActivationListener interface are notified.

			A servlet should be able to handle cases in which the client does not choose to join a session, such as when cookies are intentionally turned off. Until the client joins the session, isNew returns true. If the client chooses not to join the session, getSession will return a different session on each request, and isNew will always return true.

			Session information is scoped only to the current web application (ServletContext), so information stored in one context will not be directly visible in another.


		*/
		
		HttpSession session = request.getSession();
		
		/*
		 * a context object allows us to maintain data across an application for different users/ different browsers
		 * We use the request object to call the getServletContext() method
		 * This is wrapped in an object of ServletContext
		 * Adding values to the context is similar to how we do it for a session
		 */
		ServletContext context = request.getServletContext();
		
		/*As long as the variable jina has something...
		*We can call the setAttribute method of the session object to store our value
		*This method normally takes in two parameters in the following format
		*session.setAttribute(key/name, value);
		*/
		if(jina != "" && jina != null){
			session.setAttribute("userDefinedName", jina);
			context.setAttribute("userDefinedName", jina);
		}		
		
		writer.println("Your Username is: " + jina + "<br>");			
		writer.println("Session object has Username as: " + (String) session.getAttribute("userDefinedName") + "<br>");
		writer.println("context object has Username as: " + (String) context.getAttribute("userDefinedName") + "<br>");		
		writer.println("init Parameter object has default Username as: " + getServletConfig().getInitParameter("defaultUser"));
		
	}
}