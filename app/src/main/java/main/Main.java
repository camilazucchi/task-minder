package main;


import controller.ProjectController;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Project;


public class Main {
    
    public static void main(String[] agrs) {
        ProjectController projectController = new ProjectController();
        Project project = new Project();
        project.setName("Projeto teste");
        project.setUpdatedAt(new Date());
        project.setDescription("Descrição teste");
        try {
            projectController.save(project);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
