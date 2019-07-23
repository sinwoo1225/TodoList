package kr.ac.skuniv.todo.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.skuniv.todo.dto.Todo;
import kr.ac.skuniv.todo.service.TodoService;
import kr.ac.skuniv.todo.service.TodoServiceImpl;

public class DoneTodoAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TodoService service = new TodoServiceImpl();
		int id = Integer.parseInt(request.getParameter("id"));

		Todo todo = service.getTodo(id);
		if (todo.isDone()) {
			service.deleteTodo(id);
		} else {
			service.todoDone(id);
		}

		response.sendRedirect("todoview.sku");
	
	}

}
