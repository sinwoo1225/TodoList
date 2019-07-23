<%@page import="kr.ac.skuniv.todo.dto.Todo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<title>todoList</title>
<link rel="stylesheet" type="text/css" href="todo.css">
</head>
<body>

	<div class="todo-list-template">
		<div class="title">My To Do List</div>
		<section class="form-wrapper">
			<div class="form">
				<input type="text" id="myInput" placeholder="할일..." />
				<div class="add-button" >추가</div>
				
			</div>
		</section>
		<section class="todos-wrapper">
			<ul id="todo-item-list">
				<%
					List<Todo> todoList = (List<Todo>) request.getAttribute("todoList");
					if (todoList != null) {
						for (Todo todo : todoList) {
				%>
				<li class="todo-item" value="<%=todo.getId() %>">
					<span class="todo-text"><%=todo.getTodo()%></span>
					<%if(todo.isDone()){ %>
						<span>done</span></li>
					<%}else{ %>
						<span>ing...</span>
				</li>
				
				<%
					}
					}
					}
				%>
			</ul>
		</section>
	</div>
<script type="text/javascript">
	const inputBtn = document.querySelector('.add-button');
	inputBtn.addEventListener('click',function(){
		const inputValue = document.querySelector('#myInput').value;
		location.href="regTodo.sku?todo="+inputValue;
	})
	
	let todoUl = document.querySelector("#todo-item-list");

	todoUl.addEventListener('click',function(event){
		//alert("test");
	    let eventTarget = event.target; 
	    if(eventTarget.tagName==="SPAN"){
	    	eventTarget = eventTarget.parentElement
	    }
	 //   alert(document.querySelector("#todoID").value);
	   	location.href="DoneTodo.sku?id="+eventTarget.value;
	   
	});
	
</script>
</body>
</html>