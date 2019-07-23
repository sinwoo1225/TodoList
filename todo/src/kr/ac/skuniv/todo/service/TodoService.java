package kr.ac.skuniv.todo.service;

import java.util.List;

import kr.ac.skuniv.todo.dto.Todo;

public interface TodoService {
	public void regTodo(String todo);
	public void todoDone(int id);
	public List<Todo> viewTodoList();
	public Todo getTodo(int id);
	public void deleteTodo(int id);
}
