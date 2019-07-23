package kr.ac.skuniv.todo.dao;

import java.util.List;

import junit.framework.TestCase;
import kr.ac.skuniv.todo.dto.Todo;

public class TodoDAOTest extends TestCase{
	TodoDAO dao = new TodoDAO();
	public void testAddTodo()throws Exception{
		dao.addTodo("servlet study");
	}
	public void testUpdateTodo()throws Exception{
		dao.updateTodo(1);		
	}
	public void testGetTodoList() throws Exception{
		List<Todo> todoList = dao.getTodoList();
		System.out.println(todoList.size());
	}
}
