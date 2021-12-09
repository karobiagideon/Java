package org.kinyanjui.sentinelle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlBasedServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//shall be used when small amount of data and insenstive data like a query has to be sent as a request

		//parameters are appended to the url and sent along with header info

		response.setContentType("text/html");	
		
		PrintWriter writer = response.getWriter();
		
		String jina = request.getParameter("userName");
		writer.println("Good evening from the GET method  " + jina);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//shall be used when comparatively large amount of senstive data has to be sent as a request

		//parameters are sent in separate line in the body
		//generally used to update or post some info to the server

		response.setContentType("text/html");	
		
		PrintWriter writer = response.getWriter();
		
		String jina = request.getParameter("userName");
		writer.println("Good evening from the POST method " + jina);
		
		String fullJina = request.getParameter("fullName");
		writer.println("<br>Your full name is: " + fullJina);
		
		String profession = request.getParameter("prof");
		writer.println("<br>You are a: " + profession);
		
		String[] location = request.getParameterValues("location");
		writer.println("<br>You are at " + location.length + " places<br>");
		
		for(int i = 0; i < location.length; i++){
			writer.print(location[i]);
		}
		
		}
	
}
