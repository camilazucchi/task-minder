package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

public class TaskTableModel extends AbstractTableModel {

    // Colunas do componente gráfico Table:
    String[] columns = {"Name", "Description", "Deadline", "Task completed", "Edit", "Delete"};
    // Lista que guarda tarefas:
    List<Task> tasks = new ArrayList();

    @Override
    // Linhas:
    public int getRowCount() {
        return tasks.size();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    // Colunas:
    public int getColumnCount() {
        return columns.length;
    }
    
    // Método que determina se a célula da tabela é editável:
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3;
    }
    
    // Esse método retorna qual é a classe do componente em determinada coluna:
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(tasks.isEmpty()) {
            return Object.class;
        }
        return this.getValueAt(0, columnIndex).getClass();
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return tasks.get(rowIndex).getName();
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(tasks.get(rowIndex).getDeadline());
            case 3:
                return tasks.get(rowIndex).isCompleted();
            case 4:
                return "";
            case 5:
                return "";
            default:
                return "Not found.";
        }
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
