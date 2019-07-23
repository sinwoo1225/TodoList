package kr.ac.skuniv.todo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.skuniv.todo.action.Action;
import kr.ac.skuniv.todo.action.ActionFactory;

@WebServlet("*.sku")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
		try {
			ActionFactory factory = ActionFactory.getInstance();
			Action action = factory.getAction(path);
			action.execute(request, response);
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/NotFound.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
	}

}
