package main;


import controller.ProjectController;
import controller.TaskController;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Project;
import model.Task;


public class Main {
    
    public static void main(String[] agrs) {
        ProjectController projectController = new ProjectController();
        Project project = new Project();
        project.setName("Projeto teste");
        project.setUpdatedAt(new Date());
        project.setDescription("Descrição teste");
        project.setName("Novo nome");
        projectController.update(project);
        projectController.removeById(2);
        projectController.removeById(3);
        
        try {
            projectController.save(project);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TaskController taskController = new TaskController();
        
        Task task = new Task();
        task.setIdProject(1);
        task.setName("Criar as telas da aplicação");
        task.setDescription("Devem ser criadas telas para os cadastros");
        task.setNotes("Sem notas");
        task.setDeadline(new Date());
        task.setIsCompleted(false);
        task.setUpdatedAt(new Date());
        try {
            taskController.save(task);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
