package com.patterns.architectural.frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*In this tutorial we’ll be digging deeper into the Front Controller Pattern, 
 * part of the Enterprise Patterns as defined in Martin Fowler‘s book “Patterns 
 * of Enterprise Application Architecture”.

  Front Controller is defined as “a controller that handles all requests 
  for a Web site”. It stands in front of a web-application and delegates 
  requests to subsequent resources. It also provides an interface to common
  behavior such as security, internationalization and presenting particular views to certain users.

  This enables an application to change its behavior at runtime. 
  Furthermore it helps to read and maintain an application by preventing code duplication.
  
  If the application is running, we can reach this command by pointing our browser to
   http://localhost:8080/front-controller/?command=Search&title=patterns.

The SearchCommand resolves to two views, the second view can be tested with the following request 
http://localhost:8080/front-controller/?command=Search&title=any-title.

To round up our scenario we’ll implement a second command, which is fired as fallback in 
all cases, a command request is unknown to the Servlet:


*/

public class FrontControllerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		trackRequest(request);
		if(isAuthenticUser()){
		FrontCommand command = getCommand(request);
		command.init(getServletContext(), request, response);
		command.process();
		}
	}

	private FrontCommand getCommand(HttpServletRequest request) {
		try {
			Class type = Class
					.forName(String.format("com.baeldung.enterprise.patterns.front." + "controller.commands.%sCommand",
							request.getParameter("command")));
			return (FrontCommand) type.asSubclass(FrontCommand.class).newInstance();
		} catch (Exception e) {
			return new UnknownCommand();
		}
	}
	
	private boolean isAuthenticUser(){
	      System.out.println("User is authenticated successfully.");
	      return true;
	   }

	   private void trackRequest(HttpServletRequest request){
	      System.out.println("Page requested: " + request);
	   }

}
