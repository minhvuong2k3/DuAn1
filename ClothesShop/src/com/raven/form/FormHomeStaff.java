package com.raven.form;

import com.raven.DAO.NhanVienDAO;
import com.raven.cell.CellAction;
import com.raven.cell.CellAddress;
import com.raven.cell.CellAge;
import com.raven.cell.CellGender;
import com.raven.cell.CellName;
import com.raven.cell.CellTel;
import com.raven.main.AddEmployee;
//import com.raven.chart.ModelChart;
import com.raven.model.ModelName;
import com.raven.model.ModelStaff;
import com.raven.model.NhanVien;
import java.awt.Color;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;

public class FormHomeStaff extends javax.swing.JPanel {
    
    NhanVienDAO dao = new NhanVienDAO();
    List<NhanVien> list = dao.select();

    public FormHomeStaff() {
        initComponents();
        setOpaque(false);
        table1.addTableStyle(jScrollPane1);
        initDataTable();
    }

    private void initDataTable() {
        table1.addTableCell(new CellName(), 0);
        table1.addTableCell(new CellGender(), 1);
        table1.addTableCell(new CellAge(), 2);
        table1.addTableCell(new CellAddress(), 3);
        table1.addTableCell(new CellTel(), 4);
        table1.addTableCell(new CellAction(), 5);
        Date date = new Date();
        int day = date.getYear()+1900;
        for(int i=0;i<list.size();i++){
            table1.addRow(new ModelStaff(new ModelName(list.get(i).getHoten(), ""), list.get(i).getGioiTinh()?"Mail":"Femail", day-(Integer.parseInt(list.get(i).getNgaySinh().substring(0,4))), list.get(i).getEmail(), list.get(i).getSdt()), false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel2 = new com.raven.swing.RoundPanel();
        roundPanel3 = new com.raven.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new com.raven.swing.Table();
        button1 = new button.Button();

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        roundPanel3.setBackground(new java.awt.Color(51, 51, 51));

        table1.setForeground(new java.awt.Color(255, 255, 255));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Gender", "Age", "Email", "Tel", "Action"
            }
        ));
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setMinWidth(180);
            table1.getColumnModel().getColumn(0).setPreferredWidth(180);
            table1.getColumnModel().getColumn(2).setMinWidth(70);
            table1.getColumnModel().getColumn(2).setMaxWidth(70);
            table1.getColumnModel().getColumn(4).setPreferredWidth(50);
            table1.getColumnModel().getColumn(5).setMinWidth(120);
            table1.getColumnModel().getColumn(5).setPreferredWidth(75);
            table1.getColumnModel().getColumn(5).setMaxWidth(120);
        }

        button1.setText("Add");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        AddEmployee add = new AddEmployee();
        add.setVisible(true);
    }//GEN-LAST:event_button1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button button1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.RoundPanel roundPanel3;
    private com.raven.swing.Table table1;
    // End of variables declaration//GEN-END:variables
}
