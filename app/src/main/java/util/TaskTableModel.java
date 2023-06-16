package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

public class TaskTableModel extends AbstractTableModel {

    private String[] columns = {"Name", "Description", "Deadline", "Task completed", "Edit", "Delete"};
    private List<Task> tasks = new ArrayList();
    private boolean[] cellEditable;

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return cellEditable[columnIndex];
    }

    // Esse método retorna qual é a classe do componente em determinada coluna:
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (tasks.isEmpty()) {
            return Object.class;
        }
        return getColumnValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return getColumnValueAt(rowIndex, columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 3) {
            tasks.get(rowIndex).setIsCompleted((boolean) aValue);
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
        updateCellEditable();
        fireTableDataChanged();
    }

    private Object getColumnValueAt(int rowIndex, int columnIndex) {
        Task task = tasks.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                return task.getName();
            }
            case 1 -> {
                return task.getDescription();
            }
            case 2 -> {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(task.getDeadline());
            }
            case 3 -> {
                return task.isCompleted();
            }
            case 4 -> {
                return "Edit";
            }
            case 5 -> {
                return "Delete";
            }
            default -> {
                return "Not found";
            }
        }
    }

    private void updateCellEditable() {
        int numColumns = getColumnCount();
        cellEditable = new boolean[numColumns];
        for (int i = 0; i < numColumns; i++) {
            cellEditable[i] = (i == 3);

        }
    }
}
