package view;

import controller.ProjectController;
import controller.TaskController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.JTableHeader;
import model.Project;
import model.Task;
import util.TaskTableModel;

public class MainScreen extends javax.swing.JFrame {

    ProjectController projectController;
    TaskController taskController;

    DefaultListModel projectsModel;
    TaskTableModel tasksModel;

    public MainScreen() {
        initComponents();
        decorateTableTask();
        initDataController();
        initComponentsModel();
        updateProjectsList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneTasks = new javax.swing.JScrollPane();
        jTableTasks = new javax.swing.JTable();
        jPanelToolBar = new javax.swing.JPanel();
        jLabelToolBarTitle = new javax.swing.JLabel();
        jLabelToolBarSubtitle = new javax.swing.JLabel();
        jPanelProjects = new javax.swing.JPanel();
        jLabelProjectsTitle = new javax.swing.JLabel();
        jLabelProjectsAdd = new javax.swing.JLabel();
        jPanelTasks = new javax.swing.JPanel();
        jLabelTasksTitle = new javax.swing.JLabel();
        jLabelTasksAdd = new javax.swing.JLabel();
        jPanelProjectsList = new javax.swing.JPanel();
        jScrollPanelProjects = new javax.swing.JScrollPane();
        jListProjects = new javax.swing.JList<>();
        jPanelTasksList = new javax.swing.JPanel();
        jPanelEmptyList = new javax.swing.JPanel();
        jLabelEmptyListImg = new javax.swing.JLabel();
        jLabelEmptyListTitle = new javax.swing.JLabel();
        jLabelEmptyListSubtitle = new javax.swing.JLabel();

        jTableTasks.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTableTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Description", "Deadline", "Task completed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTasks.setRowHeight(50);
        jTableTasks.setSelectionBackground(new java.awt.Color(255, 102, 153));
        jTableTasks.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTasks.setShowHorizontalLines(true);
        jTableTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTasksMouseClicked(evt);
            }
        });
        jScrollPaneTasks.setViewportView(jTableTasks);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 800));

        jPanelToolBar.setBackground(new java.awt.Color(66, 62, 55));

        jLabelToolBarTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabelToolBarTitle.setForeground(new java.awt.Color(237, 235, 215));
        jLabelToolBarTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/task-done.png"))); // NOI18N
        jLabelToolBarTitle.setText("TaskMinder");

        jLabelToolBarSubtitle.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabelToolBarSubtitle.setForeground(new java.awt.Color(237, 235, 215));
        jLabelToolBarSubtitle.setText("Stay organized, get things done!");

        javax.swing.GroupLayout jPanelToolBarLayout = new javax.swing.GroupLayout(jPanelToolBar);
        jPanelToolBar.setLayout(jPanelToolBarLayout);
        jPanelToolBarLayout.setHorizontalGroup(
            jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelToolBarLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelToolBarTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelToolBarLayout.createSequentialGroup()
                        .addComponent(jLabelToolBarSubtitle, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                        .addGap(64, 64, 64)))
                .addGap(100, 100, 100))
        );
        jPanelToolBarLayout.setVerticalGroup(
            jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBarLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabelToolBarTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelToolBarSubtitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(63, 63, 63))
        );

        jPanelProjects.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProjects.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 226, 219)));

        jLabelProjectsTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelProjectsTitle.setForeground(new java.awt.Color(66, 62, 55));
        jLabelProjectsTitle.setText("Projects");

        jLabelProjectsAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        jLabelProjectsAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelProjectsAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProjectsAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelProjectsLayout = new javax.swing.GroupLayout(jPanelProjects);
        jPanelProjects.setLayout(jPanelProjectsLayout);
        jPanelProjectsLayout.setHorizontalGroup(
            jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProjectsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelProjectsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProjectsAdd)
                .addGap(20, 20, 20))
        );
        jPanelProjectsLayout.setVerticalGroup(
            jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelProjectsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelProjectsAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelTasks.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTasks.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 226, 219)));
        jPanelTasks.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabelTasksTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTasksTitle.setForeground(new java.awt.Color(66, 62, 55));
        jLabelTasksTitle.setText("Tasks");

        jLabelTasksAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        jLabelTasksAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelTasksAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTasksAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelTasksLayout = new javax.swing.GroupLayout(jPanelTasks);
        jPanelTasks.setLayout(jPanelTasksLayout);
        jPanelTasksLayout.setHorizontalGroup(
            jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTasksLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelTasksTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTasksAdd)
                .addGap(20, 20, 20))
        );
        jPanelTasksLayout.setVerticalGroup(
            jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTasksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTasksAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(jLabelTasksTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelProjectsList.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProjectsList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 226, 219)));

        jListProjects.setBorder(null);
        jListProjects.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jListProjects.setForeground(new java.awt.Color(66, 62, 55));
        jListProjects.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListProjects.setAlignmentX(1.0F);
        jListProjects.setAlignmentY(1.0F);
        jListProjects.setFixedCellHeight(40);
        jListProjects.setSelectionBackground(new java.awt.Color(255, 102, 153));
        jListProjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProjectsMouseClicked(evt);
            }
        });
        jScrollPanelProjects.setViewportView(jListProjects);

        javax.swing.GroupLayout jPanelProjectsListLayout = new javax.swing.GroupLayout(jPanelProjectsList);
        jPanelProjectsList.setLayout(jPanelProjectsListLayout);
        jPanelProjectsListLayout.setHorizontalGroup(
            jPanelProjectsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProjectsListLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPanelProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanelProjectsListLayout.setVerticalGroup(
            jPanelProjectsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProjectsListLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPanelProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanelTasksList.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTasksList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 226, 219)));

        jPanelEmptyList.setBackground(new java.awt.Color(255, 255, 255));

        jLabelEmptyListImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyListImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/idea.png"))); // NOI18N

        jLabelEmptyListTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelEmptyListTitle.setForeground(new java.awt.Color(66, 62, 55));
        jLabelEmptyListTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyListTitle.setText("Your task list is currently empty.");

        jLabelEmptyListSubtitle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelEmptyListSubtitle.setForeground(new java.awt.Color(102, 102, 102));
        jLabelEmptyListSubtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyListSubtitle.setText("Let's get started! Click the button to add your first task.");

        javax.swing.GroupLayout jPanelEmptyListLayout = new javax.swing.GroupLayout(jPanelEmptyList);
        jPanelEmptyList.setLayout(jPanelEmptyListLayout);
        jPanelEmptyListLayout.setHorizontalGroup(
            jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmptyListLayout.createSequentialGroup()
                .addGroup(jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEmptyListImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelEmptyListLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelEmptyListTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanelEmptyListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEmptyListSubtitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelEmptyListLayout.setVerticalGroup(
            jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmptyListLayout.createSequentialGroup()
                .addComponent(jLabelEmptyListImg, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelEmptyListTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEmptyListSubtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelTasksListLayout = new javax.swing.GroupLayout(jPanelTasksList);
        jPanelTasksList.setLayout(jPanelTasksListLayout);
        jPanelTasksListLayout.setHorizontalGroup(
            jPanelTasksListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
            .addGroup(jPanelTasksListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTasksListLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelEmptyList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelTasksListLayout.setVerticalGroup(
            jPanelTasksListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 491, Short.MAX_VALUE)
            .addGroup(jPanelTasksListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTasksListLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelEmptyList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelProjectsList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelProjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTasksList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelProjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelProjectsList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTasksList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelProjectsAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProjectsAddMouseClicked
        ProjectDialogScreen projectDialogScreen = new ProjectDialogScreen(this, rootPaneCheckingEnabled);
        projectDialogScreen.setVisible(true);

        projectDialogScreen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                loadProjects();
            }
        });
    }//GEN-LAST:event_jLabelProjectsAddMouseClicked

    private void jLabelTasksAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTasksAddMouseClicked
        TaskDialogScreen taskDialogScreen = new TaskDialogScreen(this, rootPaneCheckingEnabled);
        // Retorna o �ndice do item selecionado:
        int projectIndex = jListProjects.getSelectedIndex();
        Project project = (Project) projectsModel.get(projectIndex);
        taskDialogScreen.setProject(project);
        taskDialogScreen.setVisible(true);
    }//GEN-LAST:event_jLabelTasksAddMouseClicked

    private void jTableTasksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTasksMouseClicked
        int rowIndex = jTableTasks.rowAtPoint(evt.getPoint());
        int columnIndex = jTableTasks.columnAtPoint(evt.getPoint());

        switch (columnIndex) {
            case 3 -> {
                Task task = tasksModel.getTasks().get(rowIndex);
                taskController.update(task);
            }
            case 4 -> {
            }
            case 5 -> {
            }
        }
    }//GEN-LAST:event_jTableTasksMouseClicked

    
    private void jListProjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProjectsMouseClicked
        // Retorna o �ndice do item clicado:
        int projectIndex = jListProjects.getSelectedIndex();
        Project project = (Project) projectsModel.get(projectIndex);
        loadTasks(project.getId());
    }//GEN-LAST:event_jListProjectsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainScreen().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelEmptyListImg;
    private javax.swing.JLabel jLabelEmptyListSubtitle;
    private javax.swing.JLabel jLabelEmptyListTitle;
    private javax.swing.JLabel jLabelProjectsAdd;
    private javax.swing.JLabel jLabelProjectsTitle;
    private javax.swing.JLabel jLabelTasksAdd;
    private javax.swing.JLabel jLabelTasksTitle;
    private javax.swing.JLabel jLabelToolBarSubtitle;
    private javax.swing.JLabel jLabelToolBarTitle;
    private javax.swing.JList<String> jListProjects;
    private javax.swing.JPanel jPanelEmptyList;
    private javax.swing.JPanel jPanelProjects;
    private javax.swing.JPanel jPanelProjectsList;
    private javax.swing.JPanel jPanelTasks;
    private javax.swing.JPanel jPanelTasksList;
    private javax.swing.JPanel jPanelToolBar;
    private javax.swing.JScrollPane jScrollPaneTasks;
    private javax.swing.JScrollPane jScrollPanelProjects;
    private javax.swing.JTable jTableTasks;
    // End of variables declaration//GEN-END:variables

    public void decorateTableTask() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
        }

        JTableHeader header = jTableTasks.getTableHeader();
        // Customizando o header da tabela de tarefas:
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBorder(null);
        header.setBackground(new Color(255, 102, 153));
        header.setForeground(new Color(255, 255, 255));

        // Criando um sort autom�tico para as colunas da tabela:
        jTableTasks.setAutoCreateRowSorter(true);
    }

    // Nossos controladores:
    public void initDataController() {
        projectController = new ProjectController();
        taskController = new TaskController();
    }

    // Iniciando o projectModel:
    public void initComponentsModel() {
        projectsModel = new DefaultListModel();
        loadProjects();

        tasksModel = new TaskTableModel();
        jTableTasks.setModel(tasksModel);
        
        if(!projectsModel.isEmpty()) {
            jListProjects.setSelectedIndex(0);
            Project project = (Project) projectsModel.get(0);
            loadTasks(project.getId());
        }
    }

    // M�todo respons�vel por carregas as tarefas:
    public void loadTasks(int idProject) {
        // Pega todas as tarefas pertencentes a um projeto espec�fico:
        List<Task> tasks = taskController.getAll(idProject);
        tasksModel.setTasks(tasks);

        showJTableTasks(!tasks.isEmpty());
    }

    private void showJTableTasks(boolean hasTasks) {
        if (hasTasks) {
        if (jPanelEmptyList.isVisible()) {
            jPanelEmptyList.setVisible(false);
            jPanelTasksList.remove(jPanelEmptyList);
        }

        if (!jScrollPaneTasks.isVisible()) {
            jPanelTasksList.add(jScrollPaneTasks);
            jScrollPaneTasks.setVisible(true);
            jScrollPaneTasks.setSize(jPanelTasksList.getWidth(), jPanelTasksList.getHeight());
        }
    } else {
        if (jScrollPaneTasks.isVisible()) {
            jScrollPaneTasks.setVisible(false);
            jPanelTasksList.remove(jScrollPaneTasks);
        }

        if (!jPanelEmptyList.isVisible()) {
            jPanelEmptyList.setVisible(true);
            jPanelEmptyList.setSize(jPanelTasksList.getWidth(), jPanelTasksList.getHeight());
            jPanelTasksList.add(jPanelEmptyList);
        }
    }
    }

    // M�todo respons�vel por carregar os projetos:
    public void loadProjects() {
        List<Project> projects = projectController.getAll();

        projectsModel.clear();

        projects.forEach(projectsModel::addElement);
    }

    private void updateProjectsList() {
        // jListProjects � o nosso componente gr�fico que ter� os projetos.
        jListProjects.setModel(projectsModel);
    }
}
