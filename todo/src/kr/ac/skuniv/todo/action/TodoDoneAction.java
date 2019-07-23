package kr.ac.skuniv.todo.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.skuniv.todo.service.TodoService;
import kr.ac.skuniv.todo.service.TodoServiceImpl;

public class TodoDoneAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TodoService service = new TodoServiceImpl();
		service.todoDone(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect("todoview.sku");
	}

}
