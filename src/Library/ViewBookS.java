/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

/**
 *
 * @author Nishu Lodhi
 */

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ViewBookS extends JFrame {

    private JButton bb;
    private JTable bookTable;

    public ViewBookS() {
        initComponents();
        setLocation(500, 300);
        displayStudentData();
    }

    private void displayStudentData() {
        try {
            ConnectionClass obj1 = new ConnectionClass();
            String query = "SELECT * FROM book_data";
            PreparedStatement preparedStatement = obj1.con.prepareStatement(query);
            ResultSet res = preparedStatement.executeQuery();

            // Get column names
            ResultSetMetaData metaData = res.getMetaData();
            int columnCount = metaData.getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = metaData.getColumnName(i);
            }

            // Get data
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnNames);
            while (res.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = res.getObject(i);
                }
                model.addRow(rowData);
            }

            bookTable.setModel(model);

            // Close database resources
            res.close();
            obj1.stm.close();
            obj1.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bb = new JButton("Back");
        bb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbActionPerformed(evt);
            }
        });

        bookTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(bookTable);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bb)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bb)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void bbActionPerformed(java.awt.event.ActionEvent evt) {
        LocalSection lgf = new LocalSection();
        lgf.setVisible(true);
        lgf.pack();
        lgf.setLocationRelativeTo(null);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewStudentAS().setVisible(true);
            }
        });
    }
}
