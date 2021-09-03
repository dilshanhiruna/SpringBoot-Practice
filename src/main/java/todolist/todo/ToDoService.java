package todolist.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> getAllToDos(){
        List<ToDo> toDos = new ArrayList<>();
        toDoRepository.findAll().forEach(toDos::add);
        return toDos;
    }
    public Optional<ToDo> getToDo (Integer id){
        return toDoRepository.findById(id);
    }

    public void createToDo(ToDo toDo) {
        toDoRepository.save(toDo);
    }
    public void updateToDo(Integer id,ToDo toDo) {
        toDoRepository.save(toDo);
    }
    public void deleteTodo(Integer id) {
        toDoRepository.deleteById(id);
    }
}
