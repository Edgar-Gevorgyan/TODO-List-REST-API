package com.gevorgyan.controller;

import com.gevorgyan.model.TodoListEntity;
import com.gevorgyan.service.TodoListService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/todos")
@Consumes("application/json")
@Produces("application/json")
public class TodoListController {

    /**
     * Controller Logic
     */

    private final TodoListService todoListService;

    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @GET
    public Response getTodos() {
        var todos = todoListService.getAllTodos();
        return Response.ok(todos).build();
    }

    @GET
    @Path("{id}")
    public Response getTodo(int id) {
        try{
            var todos = todoListService.getTodoById(id);
            return Response.ok(todos).build();
        } catch (ArrayIndexOutOfBoundsException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response createTodo(TodoListEntity todo) {
        try{
            todoListService.createTodo(todo);
            return Response.status(Response.Status.CREATED).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }


    @PUT
    @Path("{id}")
    public Response updateTodo(int id, TodoListEntity todo) {
        try{
            todoListService.updateTodoById(id, todo);
            return Response.noContent().build();
        } catch (ArrayIndexOutOfBoundsException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }


    @DELETE
    @Path("{id}")
    public Response deleteTodo(int id) {
        try{
            todoListService.deleteTodoById(id);
            return Response.accepted().build();
        } catch (ArrayIndexOutOfBoundsException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}