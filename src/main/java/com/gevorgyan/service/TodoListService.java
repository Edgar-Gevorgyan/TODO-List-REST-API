package com.gevorgyan.service;

import com.gevorgyan.model.TodoListEntity;
import com.gevorgyan.repository.TodoListRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class TodoListService {

    /**
     * Business Logic
     */

    private final static int MAX_TODO_ITEM_LENGTH = 255;
    private final TodoListRepository todoListRepository;

    public TodoListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public List<TodoListEntity> getAllTodos() {
        return todoListRepository.getAllTodos();
    }

    public TodoListEntity getTodoById(int id) {
        validateId(id);
        return todoListRepository.getTodoById(id);
    }

    public void createTodo(TodoListEntity todo) {
        validateTodo(todo);
        todoListRepository.addTodo(todo);
    }

    public void updateTodoById(int id, TodoListEntity todo) {
        validateId(id);
        validateTodo(todo);
        todoListRepository.updateTodoById(id, todo);
    }

    public void deleteTodoById(int id) {
        validateId(id);
        todoListRepository.deleteTodoById(id);
    }

    private void validateId(int id){
        int size = getAllTodos().size();
        if (!(id < size)) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void validateTodo(TodoListEntity todo){
        // empty
        if(todo == null || todo.getData() == null || todo.getData().isBlank()){
            throw new IllegalArgumentException();
        }

        // duplicate
        getAllTodos().stream()
                .filter(todo::equals)
                .findAny()
                .ifPresent(duplicate -> {
                    throw new IllegalArgumentException();
                });

        // too long
        if(todo.getData().length() > MAX_TODO_ITEM_LENGTH){
            throw new IllegalArgumentException();
        }
    }
}