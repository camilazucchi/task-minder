package util;

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
    // Colunas:
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 1:
                return tasks.get(rowIndex).getName();
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
        }
        return null;
    }
}
