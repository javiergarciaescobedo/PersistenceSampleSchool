package persistencesampleschool;

import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import persistencesampleschool.controller.SchoolDecimalJTextFieldEditor;
import persistencesampleschool.controller.SchoolGroupsListRenderer;
import persistencesampleschool.data.SchoolGroup;
import persistencesampleschool.data.SchoolGroups;
import persistencesampleschool.data.SchoolStudent;
import persistencesampleschool.data.SchoolStudents;
import persistencesampleschool.model.SchoolStudentsTableModel;
import persistencesampleschool.resources.SchoolValues;

public class SchoolMain extends javax.swing.JFrame {

    private final EntityManager entityManager = 
            Persistence.createEntityManagerFactory("PersistenceSampleSchoolPU").createEntityManager();
    private SchoolStudents schoolStudents;
    private SchoolStudent schoolStudentSelected;
    private SchoolStudentsTableModel schoolStudentsTableModel;
    private final SchoolGroups schoolGroups = new SchoolGroups();
    private boolean creatingStudent = false;
    
    /**
     * Creates new form SchoolMain
     */
    public SchoolMain() {
        initComponents();
        // Save default background color to be used en jTableSchoolStudents
        SchoolValues.defaultBackgroundColor = jTableSchoolStudents.getSelectionBackground();
        // Connection with database using an entity manager

        setLocationRelativeTo(null);
        
        initJTableSchoolStudents();
        
        // Fill JComboBox with all groups 
        schoolGroups.findAll(entityManager);
        jComboBoxSchoolGroup.setModel(new DefaultComboBoxModel(schoolGroups.getSchoolGroupList().toArray()));
        jComboBoxSchoolGroup.setRenderer(new SchoolGroupsListRenderer());
    }
    
    // Set configuration and data content for students jTable
    private void initJTableSchoolStudents() {
        schoolStudents = new SchoolStudents();
        // Load data from database
        schoolStudents.findAll(entityManager);

        // Model for JTable, assigning classgroups content
        schoolStudentsTableModel = new SchoolStudentsTableModel(schoolStudents);
        jTableSchoolStudents.setModel(schoolStudentsTableModel);  

        // Allow only one row selected
        jTableSchoolStudents.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Listen for student selection in jtable
        jTableSchoolStudents.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent event) {
                    int indexSelectedRow = jTableSchoolStudents.getSelectedRow();
                    if(indexSelectedRow >= 0) {
                        schoolStudentSelected = schoolStudents.getSchoolStudentList().get(indexSelectedRow);
                        showDetailStudentSelected();
                    } else {
                        jTextFieldName.setText("");
                        jTextFieldSurnames.setText("");
                        jTextFieldGrade.setText("");
                    }
                }
            }
        );
        
        enableEditingStudentDetail(false);
    }

    public void showDetailStudentSelected() {
        int indexSelectedRow = jTableSchoolStudents.getSelectedRow();
        if(indexSelectedRow >= 0) {
            schoolStudentSelected = schoolStudents.getSchoolStudentList().get(indexSelectedRow);
            jTextFieldName.setText(schoolStudentSelected.getName());
            jTextFieldSurnames.setText(schoolStudentSelected.getSurnames());
            
            if(schoolStudentSelected.getGrade() != null) {
                jTextFieldGrade.setText(String.valueOf(schoolStudentSelected.getGrade()));
            } else {
                jTextFieldGrade.setText("");
            }
            
            if(schoolStudentSelected.getDateBirth() != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");            
                jTextFieldDateBirth.setText(dateFormat.format(schoolStudentSelected.getDateBirth()));
            } else {
                jTextFieldDateBirth.setText("");
            }
            
            jComboBoxSchoolGroup.setSelectedItem(schoolStudentSelected.getSchoolGroup());
        } else {
            jTextFieldName.setText("");
            jTextFieldSurnames.setText("");
            jTextFieldGrade.setText("");
            jTextFieldDateBirth.setText("");            
        }
    }
    
    private void enableEditingStudentDetail(boolean enable) {
        jTextFieldName.setEnabled(enable);
        jTextFieldSurnames.setEnabled(enable);
        jTextFieldDateBirth.setEnabled(enable);
        jTextFieldGrade.setEnabled(enable);
        jComboBoxSchoolGroup.setEnabled(enable);
        
        jButtonSave.setEnabled(enable);
        jButtonCancel.setEnabled(enable);
        
        jButtonAddStudent.setEnabled(!enable);
        jButtonEditStudent.setEnabled(!enable);
        jButtonRemoveStudent.setEnabled(!enable);
        
        jTableSchoolStudents.setEnabled(!enable);
        if(enable) {
            jTableSchoolStudents.setSelectionBackground(Color.GRAY);
        } else {
            jTableSchoolStudents.setSelectionBackground(SchoolValues.defaultBackgroundColor);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxSchoolGroup = new javax.swing.JComboBox();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonAddStudent = new javax.swing.JButton();
        jButtonEditStudent = new javax.swing.JButton();
        jButtonRemoveStudent = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButtonGroups = new javax.swing.JButton();
        jTextFieldGrade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSchoolStudents = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldSurnames = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDateBirth = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBoxSchoolGroup.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButtonAddStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/persistencesampleschool/resources/add.png"))); // NOI18N
        jButtonAddStudent.setToolTipText("Añadir estudiante");
        jButtonAddStudent.setFocusable(false);
        jButtonAddStudent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAddStudent.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddStudentActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonAddStudent);

        jButtonEditStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/persistencesampleschool/resources/edit.png"))); // NOI18N
        jButtonEditStudent.setToolTipText("Editar datos del estudiante seleccionado");
        jButtonEditStudent.setFocusable(false);
        jButtonEditStudent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEditStudent.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEditStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditStudentActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonEditStudent);

        jButtonRemoveStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/persistencesampleschool/resources/remove.png"))); // NOI18N
        jButtonRemoveStudent.setToolTipText("Suprimir estudiante seleccionado");
        jButtonRemoveStudent.setFocusable(false);
        jButtonRemoveStudent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRemoveStudent.setMaximumSize(new java.awt.Dimension(39, 39));
        jButtonRemoveStudent.setMinimumSize(new java.awt.Dimension(39, 39));
        jButtonRemoveStudent.setPreferredSize(new java.awt.Dimension(39, 39));
        jButtonRemoveStudent.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRemoveStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveStudentActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonRemoveStudent);
        jToolBar1.add(jSeparator1);

        jButtonGroups.setIcon(new javax.swing.ImageIcon(getClass().getResource("/persistencesampleschool/resources/group.png"))); // NOI18N
        jButtonGroups.setToolTipText("Mantenimiento de grupos");
        jButtonGroups.setFocusable(false);
        jButtonGroups.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGroups.setMaximumSize(new java.awt.Dimension(39, 39));
        jButtonGroups.setMinimumSize(new java.awt.Dimension(39, 39));
        jButtonGroups.setPreferredSize(new java.awt.Dimension(39, 39));
        jButtonGroups.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGroupsActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonGroups);

        jTextFieldGrade.setColumns(5);
        jTextFieldGrade.setToolTipText("Formato: 00.0");
        jTextFieldGrade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldGradeFocusLost(evt);
            }
        });

        jLabel5.setText("Grupo:");

        jButtonSave.setText("Guardar");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancelar");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jTableSchoolStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableSchoolStudents);

        jLabel4.setText("Calificación expediente:");

        jTextFieldSurnames.setColumns(30);

        jLabel2.setText("Apellidos:");

        jTextFieldName.setColumns(20);

        jLabel1.setText("Nombre:");

        jTextFieldDateBirth.setColumns(10);

        jLabel3.setText("Fecha Nacimiento:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldSurnames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextFieldDateBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jComboBoxSchoolGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextFieldGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldSurnames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDateBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxSchoolGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCancel)
                            .addComponent(jButtonSave)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddStudentActionPerformed
        creatingStudent = true;
        
        schoolStudentSelected = new SchoolStudent();

        // Keep JTable without any selection
        jTableSchoolStudents.clearSelection();
        
        enableEditingStudentDetail(true);
        showDetailStudentSelected();        
    }//GEN-LAST:event_jButtonAddStudentActionPerformed

    private void jButtonEditStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditStudentActionPerformed
        int indexSelectedRow = jTableSchoolStudents.getSelectedRow();
        if(indexSelectedRow >= 0) {
            creatingStudent = false;

            enableEditingStudentDetail(true);

        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar en la lista el estudiante que desea editar");            
        }
    }//GEN-LAST:event_jButtonEditStudentActionPerformed

    private void jButtonRemoveStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveStudentActionPerformed
        int indexSelectedRow = jTableSchoolStudents.getSelectedRow();
        if(indexSelectedRow >= 0) {
            schoolStudentSelected = schoolStudents.getSchoolStudentList().get(indexSelectedRow);
            int response = JOptionPane.showConfirmDialog(this, 
                    "¿Desea eliminar a " 
                    + schoolStudentSelected.getSurnames() + ", " 
                    + schoolStudentSelected.getName() + "?",
                    "Confirme eliminación",
                    JOptionPane.YES_NO_OPTION);
            if(response == JOptionPane.YES_OPTION) {
                // Remove student from database
                entityManager.getTransaction().begin();
                entityManager.remove(schoolStudentSelected);
                entityManager.getTransaction().commit();

                // Remove student from list and table
                schoolStudents.getSchoolStudentList().remove(schoolStudentSelected);
                schoolStudentsTableModel.fireTableRowsDeleted(indexSelectedRow, indexSelectedRow);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar en la lista el estudiante que desea eliminar");
        }
    }//GEN-LAST:event_jButtonRemoveStudentActionPerformed

    private void jButtonGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGroupsActionPerformed
        SchoolGroupsJDialog schoolGroupsJDialog = new SchoolGroupsJDialog(this, true);
        schoolGroupsJDialog.setEntityManager(entityManager);
        schoolGroupsJDialog.setVisible(true);
        // Update combobox content 
        schoolGroups.findAll(entityManager);
        jComboBoxSchoolGroup.setModel(new DefaultComboBoxModel(schoolGroups.getSchoolGroupList().toArray()));
        // select the student's group
        jComboBoxSchoolGroup.setSelectedItem(schoolStudentSelected.getSchoolGroup());
    }//GEN-LAST:event_jButtonGroupsActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        entityManager.getTransaction().begin();

        schoolStudentSelected.setName(jTextFieldName.getText());
        schoolStudentSelected.setSurnames(jTextFieldSurnames.getText());
        if(jTextFieldDateBirth.getText().isEmpty()) {
            schoolStudentSelected.setDateBirth(null);
        } else {
            schoolStudentSelected.setDateBirth(
                Date.valueOf(jTextFieldDateBirth.getText()));
        }
        if(jTextFieldGrade.getText().isEmpty()) {
            schoolStudentSelected.setGrade(null);
        } else {
            schoolStudentSelected.setGrade(
                BigDecimal.valueOf(Double.valueOf(jTextFieldGrade.getText())));
        }
        
        schoolStudentSelected.setSchoolGroup(
                (SchoolGroup)jComboBoxSchoolGroup.getSelectedItem());
        
        if(creatingStudent) {
            entityManager.persist(schoolStudentSelected);
            
            // Add new student to list
            schoolStudents.getSchoolStudentList().add(schoolStudentSelected);
            // Show new student in JTable
            schoolStudentsTableModel.fireTableRowsInserted(
                    schoolStudents.getSchoolStudentList().size()-1, 
                    schoolStudents.getSchoolStudentList().size()-1);
            // Select new student in JTable
            jTableSchoolStudents.setRowSelectionInterval(
                    schoolStudents.getSchoolStudentList().size()-1, 
                    schoolStudents.getSchoolStudentList().size()-1);
        } else {
            entityManager.merge(schoolStudentSelected);
        }
        
        entityManager.getTransaction().commit();
        enableEditingStudentDetail(false);
        
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        entityManager.getTransaction().begin();
        entityManager.getTransaction().rollback();
        enableEditingStudentDetail(false);
        showDetailStudentSelected();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jTextFieldGradeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldGradeFocusLost
        if(!jTextFieldGrade.getText().isEmpty() && 
                !SchoolDecimalJTextFieldEditor.verifyDecimalValue(
                    jTextFieldGrade, 
                    SchoolValues.STUDENT_GRADE_PRECISION, 
                    SchoolValues.STUDENT_GRADE_SCALE)) {                        
        }
    }//GEN-LAST:event_jTextFieldGradeFocusLost

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SchoolMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchoolMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchoolMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchoolMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchoolMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddStudent;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonEditStudent;
    private javax.swing.JButton jButtonGroups;
    private javax.swing.JButton jButtonRemoveStudent;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox jComboBoxSchoolGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTable jTableSchoolStudents;
    private javax.swing.JTextField jTextFieldDateBirth;
    private javax.swing.JTextField jTextFieldGrade;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldSurnames;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
