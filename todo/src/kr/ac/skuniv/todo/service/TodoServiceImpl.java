package kr.ac.skuniv.todo.service;

import java.util.List;

import kr.ac.skuniv.todo.dao.TodoDAO;
import kr.ac.skuniv.todo.dto.Todo;

public class TodoServiceImpl implements TodoService {
	TodoDAO todoDao = new TodoDAO();
	@Override
	public void regTodo(String todo) {
		todoDao.addTodo(todo);
	}

	@Override
	public void todoDone(int id) {
		todoDao.updateTodo(id);
	}

	@Override
	public List<Todo> viewTodoList() {
		return todoDao.getTodoList();
	}

	@Override
	public Todo getTodo(int id) {
		
		return todoDao.getTodo(id);
	}

	@Override
	public void deleteTodo(int id) {
		todoDao.deleteTodo(id);
	}

}
