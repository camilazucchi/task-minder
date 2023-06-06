package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

public class TaskController {

    private static final String INSERT_SQL = "INSERT INTO tasks(idProject, name, description, completed, notes, deadline, createdAt, updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE tasks SET idProject = ?, name = ?, notes = ?, deadline = ?, completed = ?, createdAt = ?, updatedAt = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM tasks WHERE id = ?";
    private static final String SELECT_SQL = "SELECT * FROM tasks WHERE idProject = ?";

    public void save(Task task) throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            if (task.getDeadline() != null) {
                statement.setDate(6, new Date(task.getDeadline().getTime()));
            } else {
                statement.setNull(6, java.sql.Types.DATE);
            }
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));

            System.out.println("SQL Query: " + statement.toString());
            System.out.println("idProject: " + task.getIdProject());
            System.out.println("name: " + task.getName());
            System.out.println("description: " + task.getDescription());
            System.out.println("completed: " + task.isCompleted());
            System.out.println("notes: " + task.getNotes());
            System.out.println("deadline: " + task.getDeadline());
            System.out.println("createdAt: " + task.getCreatedAt());
            System.out.println("updatedAt: " + task.getUpdatedAt());

            statement.execute();
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar a tarefa: " + ex.getMessage());
            ex.printStackTrace();
            throw new SQLException("Erro ao salvar a tarefa: ", ex.getMessage(), ex);
        }
    }

    public void update(Task task) {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {
            // Setando os valores do statement:
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            // Executando a query:
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar tarefa: " + ex.getMessage());
        }
    }

    public void removeById(int taskId) throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
            // Setando os valores:
            statement.setInt(1, taskId);
            // Executando a query:
            statement.execute();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao deletar tarefa: " + ex.getMessage());
        }
    }

    // Pegando todas as tarefas com base em um projeto:
    public List<Task> getAll(int idProject) {
        ResultSet resultSet = null;

        // Lista de tarefas que ser� devolvida quando a chamada do m�todo acontecer.
        List<Task> tasks = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_SQL)) {
            // Setando o valor que corresponde ao filtro de busca:
            statement.setInt(1, idProject);
            // Valor retornado pela execu��o da query:
            resultSet = statement.executeQuery();

            // Enquanto houverem valores a serem percorridos no resultSet:
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                tasks.add(task);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao inserir a tarefa: " + ex.getMessage());
        }
        // Lista de tarefas criada e carregada do banco de dados:
        return tasks;
    }
}
