package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import model.Task;

public class TaskController {
    
    public void save(Task task) {
        
    }
    
    public void update(Task task) {
        
    }
    
    public void removeById(int taskId) {
        
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
    }
    
    public List<Task> getAll(int idProject) {
        return null;
    }
    
}