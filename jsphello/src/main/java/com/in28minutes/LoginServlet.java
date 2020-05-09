package com.in28minutes;

import java.io.IOException;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/login.do")
public class LoginServlet extends HttpServlet {
	private LoginValidationService loginValidationService = new LoginValidationService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		request.setAttribute("name", name);
		if (loginValidationService.isValid(name, password)) {
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
			return;
		}
		request.setAttribute("errorMessage", "Invalid Credentials!");
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
		httpServletRequest.setAttribute("name", httpServletRequest.getParameter("name"));
		httpServletRequest.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(httpServletRequest, httpServletResponse);
	}
}
