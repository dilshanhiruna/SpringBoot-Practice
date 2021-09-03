package todolist.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ToDoController {

    @Autowired
    private ToDoService todoservice;

    @RequestMapping("/todos")
    public List<ToDo> getAllToDos(){

        return todoservice.getAllToDos();
    }
    @RequestMapping("/todos/{id}")
    public Optional<ToDo> getToDo(@PathVariable Integer id){
        return todoservice.getToDo(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/todos")
    public void createToDo(@RequestBody ToDo toDo){
        todoservice.createToDo(toDo);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/todos/{id}")
    public void updateTodo(@PathVariable Integer id, @RequestBody ToDo toDo){
        todoservice.updateToDo(id,toDo);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/todos/{id}")
    public void deleteTodo(@PathVariable Integer id){
        todoservice.deleteTodo(id);
    }
}
