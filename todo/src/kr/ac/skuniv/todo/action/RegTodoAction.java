package kr.ac.skuniv.todo.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.skuniv.todo.service.TodoService;
import kr.ac.skuniv.todo.service.TodoServiceImpl;

public class RegTodoAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TodoService service = new TodoServiceImpl();
		service.regTodo(request.getParameter("todo"));
		response.sendRedirect("todoview.sku");
	}

}
