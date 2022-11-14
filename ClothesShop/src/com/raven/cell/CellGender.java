package com.raven.cell;

import com.raven.table.TableCustom;
import com.raven.table.cell.TableCustomCell;
import com.raven.table.model.TableRowData;

public class CellGender extends TableCustomCell {
    
    public CellGender() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        swtGender = new javaswingdev.SwitchButton();
        lblGender = new javax.swing.JLabel();

        jLabel1.setForeground(new java.awt.Color(200, 200, 200));
        jLabel1.setText("Gender");

        swtGender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                swtGenderMouseClicked(evt);
            }
        });

        lblGender.setForeground(new java.awt.Color(200, 200, 200));
        lblGender.setText("Gender");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(swtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGender)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(swtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void swtGenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_swtGenderMouseClicked
        if (swtGender.isSelected()) {
            lblGender.setText("Male");
        } else {
            lblGender.setText("Female");
        }
    }//GEN-LAST:event_swtGenderMouseClicked

    @Override
    public void setData(Object o) {
        if (o.toString().trim().equals("Male")) {
            swtGender.setSelected(true);
            lblGender.setText("Male");

        } else {
            swtGender.setSelected(false);
            lblGender.setText("Female");
        }
    }

    @Override
    public Object getData() {
        return swtGender.isSelected() ? "Male" : "Female";
    }

    @Override
    public TableCustomCell createComponentCellEditor(TableCustom tc, TableRowData trd, Object o, int i, int i1) {
        CellGender cell = new CellGender();
        cell.setData(o);
        return cell;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup group;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblGender;
    private javaswingdev.SwitchButton swtGender;
    // End of variables declaration//GEN-END:variables
}
