package todolist.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ToDoService {
    private List<ToDo> todos = new ArrayList<>(
            Arrays.asList(
                    new ToDo(1, "task_1","summary","description_1"),
                    new ToDo(2, "task_2","summary","description_2"),
                    new ToDo(3, "task_3","summary","description_3")
            )
    );
    public List<ToDo> getAllToDos(){
        return todos;
    }
    public ToDo getToDo (Integer id){
        return todos.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void createToDo(ToDo toDo) {
        todos.add(toDo);
    }
    public void updateToDo(Integer id,ToDo toDo) {
        for(int i=0 ; i<todos.size();i++){
            ToDo t = todos.get(i);
            if(t.getId().equals(id)) {
                todos.set(i,toDo);
                return;
            }
        }
    }
    public void deleteTodo(Integer id) {
        todos.removeIf(t->t.getId().equals(id));
    }
}
