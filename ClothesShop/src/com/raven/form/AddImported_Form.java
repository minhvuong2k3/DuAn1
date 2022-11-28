/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.raven.DAO.SanPhamDAO;
import com.raven.cell.CellAction;
import com.raven.model.ModelStaff;
import com.raven.model.ProductCard;
import com.raven.model.SanPham;
import com.raven.swing.scrollbar.ScrollBarCustom;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javaswingdev.Notification;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AD MIN
 */
public class AddImported_Form extends javax.swing.JPanel {
    static JComboBox invoice = new JComboBox();
    static List<Object[]> card = new ArrayList<>();
    
    SanPhamDAO dao = new SanPhamDAO();
    List<SanPham> list = dao.select();
    int indexCbo = 0;
    
    /**
     * Creates new form AddProducts
     */
    public AddImported_Form() {
        initComponents();
        setOpaque(false);
        tblCardPro.addTableStyle(cardcard);
        cardcard.setBorder(null);
        cardcard.setViewportBorder(null);
        cardcard.getViewport().setOpaque(false);
        cardcard.setVerticalScrollBar(new ScrollBarCustom());
        tblCardPro.addTableCell(new CellAction(), 5);

        cardcard.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        tblCardPro.addRow(new ModelStaff("123", "123", "123", 12, "123", "123", "123", "123"), false);  //  ture is animate row
        tblCardPro.addRow(new ModelStaff("123", "123", "123", 12, "123", "123", "123", "123"), false);  //  ture is animate row
        tblCardPro.addRow(new ModelStaff("123", "123", "123", 12, "123", "123", "123", "123"), false);  //  ture is animate row
        tblCardPro.addRow(new ModelStaff("123", "123", "123", 12, "123", "123", "123", "123"), false);  //  ture is animate row
        tblCardPro.addRow(new ModelStaff("123", "123", "123", 12, "123", "123", "123", "123"), false);  //  ture is animate row
        tblCardPro.addRow(new ModelStaff("123", "123", "123", 12, "123", "123", "123", "123"), false);  //  ture is animate row
        tblCardPro.addRow(new ModelStaff("123", "123", "123", 12, "123", "123", "123", "123"), false);  //  ture is animate row
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width, height, 15, 15);
        g2.dispose();
        super.paint(grphcs);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        cboSearch = new combo_suggestion.ComboBoxSuggestion();
        jSeparator1 = new javax.swing.JSeparator();
        roundPanel3 = new com.raven.swing.RoundPanel();
        lblImage = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblNameProduct = new javax.swing.JLabel();
        lblSumPrice = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        btnAmount = new spinner.Spinner();
        btnAdd = new button.Button();
        jLabel15 = new javax.swing.JLabel();
        cardcard = new javax.swing.JScrollPane();
        tblCardPro = new com.raven.swing.Table();

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setPreferredSize(new java.awt.Dimension(544, 610));

        cboSearch.setBorder(null);
        cboSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSearchItemStateChanged(evt);
            }
        });

        lblImage.setBackground(new java.awt.Color(255, 255, 255));
        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setText("IMG");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        lblNameProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNameProduct.setText("NAME PRODUCT");

        lblSumPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSumPrice.setText("Total : 999999");

        lblPrice.setText("Price");

        btnAmount.setBorder(null);
        btnAmount.setLabelText("Amount");
        btnAmount.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnAmountStateChanged(evt);
            }
        });

        btnAdd.setText("Add to cart");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/search.png"))); // NOI18N

        cardcard.setBackground(new java.awt.Color(255, 255, 255));

        tblCardPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Gender", "Age", "Email", "Tel", "Action"
            }
        ));
        tblCardPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCardProMouseClicked(evt);
            }
        });
        cardcard.setViewportView(tblCardPro);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cardcard)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel1Layout.createSequentialGroup()
                        .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNameProduct, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                                .addComponent(lblSumPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addComponent(btnAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 33, Short.MAX_VALUE))
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSumPrice))))))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cardcard)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSearchItemStateChanged
        // TODO add your handling code here:
        if (indexCbo != 0) {
            if (cboSearch.getSelectedIndex() > 0) {
                loadSP(cboSearch.getSelectedIndex());
                sumPrice((int) btnAmount.getValue());
            } else {
                clearSP();
            }
        }
        indexCbo++;
    }//GEN-LAST:event_cboSearchItemStateChanged

    private void btnAmountStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnAmountStateChanged
        // TODO add your handling code here:
        if (cboSearch.getSelectedIndex() > 0) {
            sumPrice((int) btnAmount.getValue());
        }
    }//GEN-LAST:event_btnAmountStateChanged

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if(cboSearch.getSelectedIndex()>0 && Integer.parseInt(lblSumPrice.getText().substring(7)) > 0)
            loadToTable();
        else {
            Notification panel = new Notification(Employee_Form.fr, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Information not enough !");
            panel.showNotification();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblCardProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCardProMouseClicked
        // TODO add your handling code here:
        loadSPFromTable(tblCardPro.getSelectedRow());
    }//GEN-LAST:event_tblCardProMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button btnAdd;
    private spinner.Spinner btnAmount;
    private javax.swing.JScrollPane cardcard;
    private combo_suggestion.ComboBoxSuggestion cboSearch;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblNameProduct;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblSumPrice;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel3;
    private com.raven.swing.Table tblCardPro;
    // End of variables declaration//GEN-END:variables

    private void init() {
        loadToCbo();
        DefaultComboBoxModel model = (DefaultComboBoxModel)invoice.getModel();
        model.removeAllElements();
        model.addElement("0");
        model.addElement("1");
        model.addElement("2");
        invoice.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                removeAllall();
            }
        });
    }

    private void loadToCbo() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboSearch.getModel();
        model.removeAllElements();
        model.addElement("");
        for (int i = 0; i < list.size(); i++) {
            model.addElement(list.get(i).getMaSP());
        }
        cboSearch.setModel(model);
    }
    
    private void loadSP(int index) {
        lblNameProduct.setText(list.get(index - 1).getTenSP());
        lblPrice.setText("Price: " + list.get(index - 1).getGiaBan());
        lblImage.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(("/com/raven/image/" + list.get(index - 1).getAnh()))).getImage().getScaledInstance(135, 164, Image.SCALE_DEFAULT)));
    }
    
    private void loadSPFromTable(int index){
        loadSP(index+1);
        btnAmount.setValue(card.get(index)[2]);
        lblSumPrice.setText(String.valueOf(Integer.parseInt(lblPrice.getText().substring(7))*(int)card.get(index)[2]));
        cboSearch.setSelectedItem(card.get(index)[0]);
    }

    public void clearSP() {
        lblNameProduct.setText("NAME PRODUCT");
        lblPrice.setText("Price ");
        lblImage.setIcon(null);
        lblImage.setText("IMG");
        lblSumPrice.setText("Total: 0");
    }
    
    public void removeCard(int x){
        if(card.size() >= 0)
            card.remove(x);
    }
    
    public void removeAllall(){
        if(card.size() >= 0)
            card.removeAll(card);
        DefaultTableModel model = (DefaultTableModel)tblCardPro.getModel();
        model.setRowCount(0);
        cboSearch.setSelectedIndex(0);
        clearSP();
    }

    private void sumPrice(int x) {
        if (x <= 0) {
            lblSumPrice.setText("Total: 0");
        } else {
            lblSumPrice.setText("Total: " + (Integer.parseInt(lblPrice.getText().substring(7)) * x));
        }
    }

    private void loadToTable() {
        boolean check = true;
        boolean checkUpdate = true;
        for (int i = 0; i < card.size(); i++) {
            if (list.get(cboSearch.getSelectedIndex() - 1).getMaSP().equals(card.get(i)[0])) {
                card.get(i)[2] = btnAmount.getValue();
                checkUpdate = false;
                break;
            }
        }
        if(check){
            SanPham sp = dao.selectById(list.get(cboSearch.getSelectedIndex() - 1).getMaSP());
            if(sp!=null){
                if(sp.getSoLuong()-(int)btnAmount.getValue()>=0)
                    check = true;
                else {
                    Notification panel = new Notification(Employee_Form.fr, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Amount isn't enough !");
                    panel.showNotification();
                    check = false;
                }
            }
            else check = false;
        }
        if (check) {
            if(checkUpdate){
                Object[] row = {list.get(cboSearch.getSelectedIndex() - 1).getMaSP(), list.get(cboSearch.getSelectedIndex() - 1).getTenSP(), btnAmount.getValue()};
                card.add(row);
            }
            DefaultTableModel model = (DefaultTableModel)tblCardPro.getModel();
            model.setRowCount(0);
            for (int i = 0; i < card.size(); i++) {
                tblCardPro.addRow(new ProductCard(card.get(i)[0].toString(), card.get(i)[1].toString(), Integer.parseInt(card.get(i)[2].toString())), false);
            }
        }

    }
}
