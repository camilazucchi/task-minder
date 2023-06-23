package util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;

public class ButtonColumnCellRenderer extends DefaultTableCellRenderer {

    private String buttonType;
    
    public ButtonColumnCellRenderer(String buttonType) {
        this.buttonType = buttonType;
    }

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel label = (JLabel) super.getTableCellRendererComponent(table,
                "", isSelected, hasFocus, row, column);

        label.setHorizontalAlignment(CENTER);
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + buttonType + ".png")));

        return label;
    }

}
