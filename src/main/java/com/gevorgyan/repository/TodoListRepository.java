package com.gevorgyan.repository;

import com.gevorgyan.model.TodoListEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TodoListRepository {

    /**
     * Data Storage Logic
     */

    private final List<TodoListEntity> todos = new ArrayList<>();

    public List<TodoListEntity> getAllTodos() {
        return todos;
    }

    public TodoListEntity getTodoById(int id) {
        return todos.get(id);
    }

    public void addTodo(TodoListEntity todo) {
        todos.add(todo);
    }

    public void updateTodoById(int id, TodoListEntity todo) {
        todos.remove(id);
        todos.add(id, todo);
    }

    public void deleteTodoById(int id) {
        todos.remove(id);
    }
}