package com.cont;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterFormCont")
public class RegisterFormContServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name").trim();
		String email=request.getParameter("email").trim();
		String pass=request.getParameter("password").trim();
		int age=Integer.parseInt(request.getParameter("age").trim());
		String addr=request.getParameter("address").trim();
		// type cast if any
		ArrayList errors=new ArrayList();
		//validation
		if(name.length()<=0)
			errors.add("Name field can't left blank");
		if(email.length()<=0)
			errors.add("Email can't left blank");
		if(pass.length()<=0)
			errors.add("password required");
		if(age < 18)
			errors.add("you are not eligible");
		if(addr.length() <= 0)
			errors.add("Specify full addresss");
		
		//redirection
		if(!errors.isEmpty()) {
		RequestDispatcher rd=request.getRequestDispatcher("error.html");
		rd.forward(request, response);
		}
		RequestDispatcher rd=request.getRequestDispatcher("Success.html");
		rd.forward(request, response);
		
	}

}
