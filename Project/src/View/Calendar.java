/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Paul
 */
import Controller.Controler_Appointement;
import DAO.My_CNX;
import Model.UserList;
import java.awt.Color;
import java.io.File;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;


public class Calendar extends javax.swing.JFrame {

    /**
     * Creates new form Calendar
     */
    private UserList UL;
    private int idp;
    private JComboBox<String> comboBoxL1,comboBoxL2,comboBoxL3,comboBoxL4,comboBoxL5,comboBoxL6,comboBoxJ1,comboBoxJ2,comboBoxJ3,comboBoxJ4,comboBoxJ5,comboBoxJ6,comboBoxM1,comboBoxM2,comboBoxM3,comboBoxM4,comboBoxM5,comboBoxM6,comboBoxS1,comboBoxS2,comboBoxS3,comboBoxS4,comboBoxS5,comboBoxS6;
    private java.sql.Date Lundi= new java.sql.Date(2020-1900,11,15);
    private java.sql.Date Mardi= new java.sql.Date(2020-1900,11,16);
    private java.sql.Date Mercredi= new java.sql.Date(2020-1900,11,17);
    private java.sql.Date Jeudi= new java.sql.Date(2020-1900,11,18);
    private java.sql.Date Vendredi= new java.sql.Date(2020-1900,11,19);
    private java.sql.Date Samedi= new java.sql.Date(2020-1900,11,20);
    public Calendar(UserList U,int id) {
        UL=U;
        idp=id;
        initComponents();
         //Centrer la forme
        this.setLocationRelativeTo(null);
        
        //Creer une borbure jaune pour le Jpanel titre
        Border jpanel_title_border = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.yellow);        
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        
        jLabel_close.setBorder(label_border);
        jLabel_hind.setBorder(label_border);
        // COMBO BOX 1 JOUR 1 CLINIQUE
        comboBoxL1 = new JComboBox<>();
        comboBoxL2 = new JComboBox<>();
        comboBoxL3 = new JComboBox<>();
        comboBoxL4 = new JComboBox<>();
        comboBoxL5 = new JComboBox<>();
        comboBoxL6 = new JComboBox<>();
        
        comboBoxJ1 = new JComboBox<>();
        comboBoxJ2 = new JComboBox<>();
        comboBoxJ3 = new JComboBox<>();
        comboBoxJ4 = new JComboBox<>();
        comboBoxJ5 = new JComboBox<>();
        comboBoxJ6 = new JComboBox<>();
        
        comboBoxM1 = new JComboBox<>();
        comboBoxM2 = new JComboBox<>();
        comboBoxM3 = new JComboBox<>();
        comboBoxM4 = new JComboBox<>();
        comboBoxM5 = new JComboBox<>();
        comboBoxM6 = new JComboBox<>();
        
        comboBoxS1 = new JComboBox<>();
        comboBoxS2 = new JComboBox<>();
        comboBoxS3 = new JComboBox<>();
        comboBoxS4 = new JComboBox<>();
        comboBoxS5 = new JComboBox<>();
        comboBoxS6 = new JComboBox<>();
        
        
        
        
        for(int i=0;i<UL.getAppList().size();i++){
            if(UL.getAppList().get(i).getDisponible()==1){
                if(UL.getAppList().get(i).getDay().equals(Lundi)){
                    if(UL.getAppList().get(i).getClinic().equals("Jonhson street")){
                        comboBoxJ1.addItem(UL.getAppList().get(i).toString());
                    }
                    if(UL.getAppList().get(i).getClinic().equals("Stanford avenue")){
                        comboBoxS1.addItem(UL.getAppList().get(i).toString());
                    }
                    if(UL.getAppList().get(i).getClinic().equals("Manchester avenue")){
                        comboBoxM1.addItem(UL.getAppList().get(i).toString());
                    }
                    if(UL.getAppList().get(i).getClinic().equals("Liverpool street")){
                        comboBoxL1.addItem(UL.getAppList().get(i).toString());
                    }
                }
                if(UL.getAppList().get(i).getDay().equals(Mardi)){
                    if(UL.getAppList().get(i).getClinic().equals("Jonhson street")){
                        comboBoxJ2.addItem(UL.getAppList().get(i).toString());
                    }
                    if(UL.getAppList().get(i).getClinic().equals("Stanford avenue")){
                        comboBoxS2.addItem(UL.getAppList().get(i).toString());
                    }
                    if(UL.getAppList().get(i).getClinic().equals("Manchester avenue")){
                        comboBoxM2.addItem(UL.getAppList().get(i).toString());
                    }
                    if(UL.getAppList().get(i).getClinic().equals("Liverpool street")){
                        comboBoxL2.addItem(UL.getAppList().get(i).toString());
                    }
                }
                if(UL.getAppList().get(i).getDay().equals(Mercredi)){
                    if(UL.getAppList().get(i).getClinic().equals("Jonhson street")){
                        comboBoxJ3.addItem(UL.getAppList().get(i).toString());
                    }
                    if(UL.getAppList().get(i).getClinic().equals("Stanford avenue")){
                        comboBoxS3.addItem(UL.getAppList().get(i).toString());
                    }
                    if(UL.getAppList().get(i).getClinic().equals("Manchester avenue")){
                        comboBoxM3.addItem(UL.getAppList().get(i).toString());
                    }
                    if(UL.getAppList().get(i).getClinic().equals("Liverpool street")){
                        comboBoxL3.addItem(UL.getAppList().get(i).toString());
                    }
                }
                if(UL.getAppList().get(i).getDay().equals(Jeudi)){
                    if(UL.getAppList().get(i).getClinic().equals("Jonhson street")){
                        comboBoxJ4.addItem(UL.getAppList().get(i).toString());
                    }
                    if(UL.getAppList().get(i).getClinic().equals("Stanford avenue")){
                        comboBoxS4.addItem(UL.getAppList().get(i).toString());
                    }
                    if(UL.getAppList().get(i).getClinic().equals("Manchester avenue")){
                        comboBoxM4.addItem(UL.getAppList().get(i).toString());
                    }
                    if(UL.getAppList().get(i).getClinic().equals("Liverpool street")){
                        comboBoxL4.addItem(UL.getAppList().get(i).toString());
                    }
                }
                if(UL.getAppList().get(i).getDay().equals(Vendredi)){
                    if(UL.getAppList().get(i).getClinic().equals("Jonhson street")){
                        comboBoxJ5.addItem(UL.getAppList().get(i).toString());
                    }
                    if(UL.getAppList().get(i).getClinic().equals("Stanford avenue")){
                        comboBoxS5.addItem(UL.getAppList().get(i).toString());
                    }
                    if(UL.getAppList().get(i).getClinic().equals("Manchester avenue")){
                        comboBoxM5.addItem(UL.getAppList().get(i).toString());
                    }
                    if(UL.getAppList().get(i).getClinic().equals("Liverpool street")){
                        comboBoxL5.addItem(UL.getAppList().get(i).toString());
                    }
                }
                if(UL.getAppList().get(i).getDay().equals(Samedi)){
                    if(UL.getAppList().get(i).getClinic().equals("Jonhson street")){
                        comboBoxJ6.addItem(UL.getAppList().get(i).toString());
                    }
                    if(UL.getAppList().get(i).getClinic().equals("Stanford avenue")){
                        comboBoxS6.addItem(UL.getAppList().get(i).toString());
                    }
                    if(UL.getAppList().get(i).getClinic().equals("Manchester avenue")){
                        comboBoxM6.addItem(UL.getAppList().get(i).toString());
                    }
                    if(UL.getAppList().get(i).getClinic().equals("Liverpool street")){
                        comboBoxL6.addItem(UL.getAppList().get(i).toString());
                    }
                }
            }
        }
           
        jTable3.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(comboBoxL1));
        jTable3.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(comboBoxL2));
        jTable3.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBoxL3));
        jTable3.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(comboBoxL4));
        jTable3.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(comboBoxL5));
        jTable3.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(comboBoxL6));
        
        jTable1.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(comboBoxJ1));
        jTable1.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(comboBoxJ2));
        jTable1.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBoxJ3));
        jTable1.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(comboBoxJ4));
        jTable1.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(comboBoxJ5));
        jTable1.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(comboBoxJ6));
        
        jTable2.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(comboBoxM1));
        jTable2.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(comboBoxM2));
        jTable2.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBoxM3));
        jTable2.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(comboBoxM4));
        jTable2.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(comboBoxM5));
        jTable2.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(comboBoxM6));
        
        jTable4.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(comboBoxS1));
        jTable4.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(comboBoxS2));
        jTable4.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBoxS3));
        jTable4.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(comboBoxS4));
        jTable4.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(comboBoxS5));
        jTable4.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(comboBoxS6));
        
    }        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel_hind = new javax.swing.JLabel();
        jLabel_close = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));

        jPanel3.setBackground(new java.awt.Color(110, 89, 222));

        jLabel_hind.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel_hind.setText(" -");
        jLabel_hind.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_hind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_hindMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_hindMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_hindMouseExited(evt);
            }
        });

        jLabel_close.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel_close.setText(" X");
        jLabel_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseExited(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(110, 89, 222));
        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("             CHOOSE AN APPOINTEMENT");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196)
                .addComponent(jLabel_hind, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_close, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_hind, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_close, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(110, 89, 222));
        jButton1.setText("Previous");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Johnson street", null, null, null, null, null, null}
            },
            new String [] {
                "", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setRowHeight(60);
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Manchester Avenue", null, null, null, null, null, null}
            },
            new String [] {
                "", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setRowHeight(60);
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Liverpool street", null, null, null, null, null, null}
            },
            new String [] {
                "", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable3.setRowHeight(60);
        jScrollPane3.setViewportView(jTable3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Stanford Avenue", null, null, null, null, null, null}
            },
            new String [] {
                "", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable4.setRowHeight(60);
        jScrollPane4.setViewportView(jTable4);

        jButton2.setBackground(new java.awt.Color(110, 89, 222));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Set a new appointment");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jButton1)
                            .addGap(168, 168, 168)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(17, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Interface_patient(UL, idp).setVisible(true);    // on instancie un objet Form2

        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseExited

        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_close.setBorder(label_border);
        jLabel_close.setForeground(Color.black);
    }//GEN-LAST:event_jLabel_closeMouseExited

    private void jLabel_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseEntered

        // change kes bords en blanc
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        jLabel_close.setBorder(label_border);
        // Change le trait en blanc
        jLabel_close.setForeground(Color.white);
    }//GEN-LAST:event_jLabel_closeMouseEntered

    private void jLabel_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseClicked

        System.exit(0);
    }//GEN-LAST:event_jLabel_closeMouseClicked

    private void jLabel_hindMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_hindMouseExited

        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_hind.setBorder(label_border);
        jLabel_hind.setForeground(Color.black);
    }//GEN-LAST:event_jLabel_hindMouseExited

    private void jLabel_hindMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_hindMouseEntered

        // change kes bords en blanc
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        jLabel_hind.setBorder(label_border);
        // Change le trait en blanc
        jLabel_hind.setForeground(Color.white);
    }//GEN-LAST:event_jLabel_hindMouseEntered

    private void jLabel_hindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_hindMouseClicked

    }//GEN-LAST:event_jLabel_hindMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String query = "SELECT * FROM appointement WHERE jour = ? AND heureDebut=? AND clinics=?";
        try {
            PreparedStatement st = My_CNX.getConnection().prepareStatement(query);   
            if(comboBoxJ1.getSelectedIndex()>-1){
                String s=comboBoxJ1.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Lundi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxJ2.getSelectedIndex()>-1){
                String s=comboBoxJ2.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Mardi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxJ3.getSelectedIndex()>-1){
                String s=comboBoxJ3.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Mercredi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxJ4.getSelectedIndex()>-1){
                String s=comboBoxJ4.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Jeudi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxJ5.getSelectedIndex()>-1){
                String s=comboBoxJ5.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Vendredi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxJ6.getSelectedIndex()>-1){
                String s=comboBoxJ6.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Samedi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxL1.getSelectedIndex()>-1){
                String s=comboBoxL1.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Lundi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxL2.getSelectedIndex()>-1){
                String s=comboBoxL2.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Mardi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxL3.getSelectedIndex()>-1){
                String s=comboBoxL3.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Mercredi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxL4.getSelectedIndex()>-1){
                String s=comboBoxL4.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Jeudi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxL5.getSelectedIndex()>-1){
                String s=comboBoxL5.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Vendredi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxL6.getSelectedIndex()>-1){
                String s=comboBoxL6.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Samedi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxS1.getSelectedIndex()>-1){
                String s=comboBoxS1.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Lundi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxS2.getSelectedIndex()>-1){
                String s=comboBoxS2.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Mardi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxS3.getSelectedIndex()>-1){
                String s=comboBoxS3.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Mercredi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxS4.getSelectedIndex()>-1){
                String s=comboBoxS4.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Jeudi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxS5.getSelectedIndex()>-1){
                String s=comboBoxS5.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Vendredi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxS6.getSelectedIndex()>-1){
                String s=comboBoxS6.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Samedi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxM1.getSelectedIndex()>-1){
                String s=comboBoxM1.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Lundi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxM2.getSelectedIndex()>-1){
                String s=comboBoxM2.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Mardi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxM3.getSelectedIndex()>-1){
                String s=comboBoxM3.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Mercredi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxM4.getSelectedIndex()>-1){
                String s=comboBoxM4.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Jeudi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxM5.getSelectedIndex()>-1){
                String s=comboBoxM5.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Vendredi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }
            else if(comboBoxM6.getSelectedIndex()>-1){
                String s=comboBoxM6.getSelectedItem().toString();
                int j=-1;
                for(int i=0;i<UL.getAppList().size();i++){
                    if(UL.getAppList().get(i).toString().equals(s) && UL.getAppList().get(i).getDay().equals(Samedi)){
                        st.setDate(1,UL.getAppList().get(i).getDay());
                        st.setTime(2,UL.getAppList().get(i).getBegin());
                        st.setString(3,UL.getAppList().get(i).getClinic());
                        ResultSet rs= st.executeQuery();
                        if(rs.next())
                        {
                            j=rs.getInt("idAppointement");
                        }
                    }
                }                 
                Controler_Appointement App= new Controler_Appointement(UL);
                App.takeAppointement(j,idp);
            }   
        }
        catch (SQLException ex) {
                     Logger.getLogger(Register_form_patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Interface_patient(UL, idp).setVisible(true);    // on instancie un objet Form2

        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_close;
    private javax.swing.JLabel jLabel_hind;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables
}
