package kr.ac.skuniv.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.skuniv.common.DBUtil;
import kr.ac.skuniv.todo.dto.Todo;

public class TodoDAO {
	public void deleteTodo(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from todo where id=?";
			ps = conn.prepareStatement(sql);			
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps);
		}
	}
	public void updateTodo(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "update todo set done=true where id=?";
			ps = conn.prepareStatement(sql);			
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps);
		}
	}
	public void addTodo(String todo) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into todo(todo) values(?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, todo);
			ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps);
		}
	}
	public List<Todo> getTodoList(){
		List<Todo> todoList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from todo order by id desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Todo todo = new Todo();
				todo.setId(rs.getInt(1));
				todo.setTodo(rs.getString(2));
				todo.setDone(rs.getBoolean(3));
				todoList.add(todo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps);
		}
		return todoList;
	}
	
	public Todo getTodo(int id){
		Todo todo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from todo where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				todo = new Todo();
				todo.setId(rs.getInt(1));
				todo.setTodo(rs.getString(2));
				todo.setDone(rs.getBoolean(3));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps);
		}
		return todo;
	}
}
