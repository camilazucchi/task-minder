package main;


import controller.ProjectController;
import controller.TaskController;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Project;


public class Main {
    
    public static void main(String[] agrs) {
        
        ProjectController projectController = new ProjectController();
        TaskController taskController = new TaskController();
        /*
        Project project = new Project();
        project.setName("Projeto teste");
        project.setUpdatedAt(new Date());
        project.setDescription("Descrição teste");
        
        try {
            projectController.save(project);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        projectController.removeAllProjects();
        
        List<Project> projects = projectController.getAll();
        System.out.println("Total de projetos " + projects.size());
        
        
        /* Task task = new Task();
        task.setIdProject(4);
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
        }*/
        taskController.removeById(1);
        taskController.removeById(2);
        taskController.removeById(3);
        taskController.removeById(4);
        taskController.removeById(5);
        taskController.removeById(8);
        taskController.removeById(9);
    }
}
