package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

public class ProjectController {

    private static final String INSERT_SQL = "INSERT INTO projects (name, description, createdAt, updatedAt) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE projects SET name = ?, description = ?, createdAt = ?, updatedAt = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM projects WHERE id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM projects";
    private static final String DELETE_ALL_SQL = "DELETE from projects";

    // Método que salva um projeto:
    public void save(Project project) throws SQLException {
        // Estabelece a conexão com o banco de dados e prepara a query:
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            statement.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao salvar o projeto: ",
                    ex.getMessage(), ex);
        }
    }

    public void update(Project project) throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setTimestamp(3, new Timestamp(project.getCreatedAt().getTime()));
            statement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            statement.setInt(5, project.getId());
            statement.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao atualizar o projeto: " + ex.getMessage(), ex);
        }
    }

    public void removeById(int idProject) {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
            statement.setInt(1, idProject);
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar o projeto: " + ex.getMessage());
        }
    }

    public List<Project> getAll() {
        List<Project> projects = new ArrayList<>();

        ResultSet resultSet = null;

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL)) {
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Project project = new Project();

                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getTimestamp("createdAt"));
                project.setUpdatedAt(resultSet.getTimestamp("updatedAt"));

                projects.add(project);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao inserir o projeto: " + ex.getMessage());
        }

        return projects;
    }

    public void removeAllProjects() {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_ALL_SQL)) {
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao remover os projetos: " + ex.getMessage());
        }
    }
}
