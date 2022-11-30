/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.raven.DAO.SanPhamDAO;
import com.raven.cell.CellAction;
import static com.raven.form.ImportProduct_Form.manccString;
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AD MIN
 */
public class AddImported_Form extends javax.swing.JPanel {

    SanPhamDAO dao = new SanPhamDAO();
    List<SanPham> list = dao.select();
    static List<SanPham> card = new ArrayList<>(); // Luu du lieu cac sp cap nhat
    List<SanPham> cardcardcard = new ArrayList<>();
    int index = 0; // Vi tri select trong table
    static int ok = 6;
    static int indexModelTable = -1;
    static JComboBox cbo = new JComboBox();
    static JComboBox cbo3 = new JComboBox();
    static void isNew() {
//        fillcboSanPham("");
    }

    /**
     * Creates new form AddProducts
     */
    public AddImported_Form() {
        initComponents();
        setLayout();
        init();
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
        lblAmount = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        btnAmount = new spinner.Spinner();
        btnAdd = new button.Button();
        jLabel15 = new javax.swing.JLabel();
        cardcard = new javax.swing.JScrollPane();
        tblCardPro = new com.raven.swing.Table();

        setBackground(new java.awt.Color(255, 255, 255));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblNameProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNameProduct.setText("NAME PRODUCT");

        lblAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAmount.setText("Amout now:");

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
                "ID", "Name", "Amount", "Action"
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
                                .addComponent(lblAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAmount))))))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cardcard, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
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
        if (cboSearch.getSelectedIndex() > 0) {
            SanPham model = (SanPham) cboSearch.getSelectedItem();
            setModel(model);
        }
    }//GEN-LAST:event_cboSearchItemStateChanged

    private void btnAmountStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnAmountStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_btnAmountStateChanged

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (cboSearch.getSelectedIndex() > 0 && (int)btnAmount.getValue()>0) {
            loadToTable();
            clear();
        } else {
            Notification panel = new Notification(Employee_Form.fr, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Information not enough !");
            panel.showNotification();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblCardProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCardProMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.index = tblCardPro.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit();
            }
        }
    }//GEN-LAST:event_tblCardProMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button btnAdd;
    private spinner.Spinner btnAmount;
    private javax.swing.JScrollPane cardcard;
    private combo_suggestion.ComboBoxSuggestion cboSearch;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblNameProduct;
    private javax.swing.JLabel lblPrice;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel3;
    private com.raven.swing.Table tblCardPro;
    // End of variables declaration//GEN-END:variables

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

    private void setLayout() {
        setOpaque(false);
        tblCardPro.addTableStyle(cardcard);
        cardcard.setBorder(null);
        cardcard.setViewportBorder(null);
        cardcard.getViewport().setOpaque(false);
        cardcard.setVerticalScrollBar(new ScrollBarCustom());
        tblCardPro.addTableCell(new CellAction(), 3);
    }

    private void init() {
        tblCardPro.setDefaultEditor(Object.class, null); // Khong cho edit tren table
        fillcboSanPham(""); // Load tat ca sp len form
        DefaultComboBoxModel model = (DefaultComboBoxModel)cbo.getModel();
        model.addElement("0");
        model.addElement("1");
        cbo.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                fillcboSanPham(ImportProduct_Form.manccString);
            }
        });
        DefaultComboBoxModel model3 = (DefaultComboBoxModel)cbo3.getModel();
        model3.addElement("0");
        model3.addElement("1");
        cbo3.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                removeALLCard();
            }
        });
        DefaultTableModel modelTable = (DefaultTableModel) tblCardPro.getModel();
        modelTable.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (modelTable.getRowCount() < card.size()) {
                    if (modelTable.getRowCount() >= 0) {
                        cardcardcard.removeAll(cardcardcard);
                        for (int i = 0; i < modelTable.getRowCount(); i++) {
                            SanPham sp = new SanPham();
                            for(int a=0;a<list.size();a++){
                                if(list.get(a).getMaSP().equals(modelTable.getValueAt(i, 0))){
                                    sp=list.get(a);
                                    break;
                                }
                            }
                            cardcardcard.add(sp);
                        }
                        for(int i=0;i<card.size();i++){
                            if(i > (cardcardcard.size()-1)){
                                indexModelTable--;
                                card.remove(i);
                                break;
                            }
                            if(!card.get(i).getMaSP().equals(cardcardcard.get(i).getMaSP())){
                                indexModelTable--;
                                card.remove(i);
                                break;
                            }
                        }
                                
                    }
                }
            }
        });
    }
    
    public void removeALLCard(){
        card.removeAll(card);
        DefaultTableModel model = (DefaultTableModel)tblCardPro.getModel();
        model.setRowCount(0);
    }

    /**
     * Load du lieu tu sp tbl len tble
     */
//    private void load() {
//        DefaultTableModel model = (DefaultTableModel) tblCardPro.getModel();
//        model.setRowCount(0);
//
//        try {
//            for (SanPham sp : card) {
//                tblCardPro.addRow(new ProductCard(sp.getMaSP(), sp.getTenSP(), sp.getSoLuong()), false);
//            }
//        } catch (Exception e) {
//            XDialog.alert(this, "Load table fail");
//        }
//    }
    
    private void loadToTable() {
        boolean checkUpdate = true;
        for (int i = 0; i < card.size(); i++) {
            if (list.get(cboSearch.getSelectedIndex() - 1).getMaSP().equals(card.get(i).getMaSP())) {
                card.get(i).setSoLuong(card.get(i).getSoLuong()+(int) btnAmount.getValue());
                tblCardPro.setValueAt(card.get(i).getSoLuong(), i, 2);
                checkUpdate = false;
                break;
            }
        }
        if (card.size()>0) {
            if (checkUpdate) {
                SanPham sp = list.get(cboSearch.getSelectedIndex() - 1);
                sp.setSoLuong(list.get(cboSearch.getSelectedIndex() - 1).getSoLuong()+(int)btnAmount.getValue());
                card.add(sp);
                indexModelTable++;
                tblCardPro.addRow(new ProductCard(card.get(indexModelTable).getMaSP(), card.get(indexModelTable).getTenSP(), Integer.parseInt(card.get(indexModelTable).getSoLuong()+"")), false);
            }
        }
        if(card.size()<=0){
            SanPham sp = list.get(cboSearch.getSelectedIndex() - 1);
            sp.setSoLuong(list.get(cboSearch.getSelectedIndex() - 1).getSoLuong()+(int)btnAmount.getValue());
            card.add(sp);
            indexModelTable++;
            tblCardPro.addRow(new ProductCard(card.get(indexModelTable).getMaSP(), card.get(indexModelTable).getTenSP(), Integer.parseInt(card.get(indexModelTable).getSoLuong()+"")), false);
        }
    }

    private void delete() {
        if (!card.isEmpty()) {
            card.removeAll(card);
        }
    }

    /**
     * Show thong tin sp len form
     *
     * @param model la san pham can show
     */
    private void setModel(SanPham model) {
        lblNameProduct.setText(model.getTenSP());
        lblPrice.setText("Price: " + model.getGiaBan());
        lblImage.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(("/com/raven/image/" + model.getAnh()))).getImage().getScaledInstance(135, 164, Image.SCALE_DEFAULT)));
        lblAmount.setText("Amount in warehouse: " + model.getSoLuong());
    }

    /**
     * Hien thong tin sp trong table
     */
    private void edit() {
        try {
            String masp = (String) tblCardPro.getValueAt(this.index, 0);
            System.out.println(masp);
            SanPham model = dao.selectById(masp);
            if (model != null) {
                this.setModel(model);
                btnAmount.setValue(card.get(index).getSoLuong());
                cboSearch.setSelectedItem(card.get(index));
            }
        } catch (Exception e) {
            Notification panel = new Notification(Employee_Form.fr, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Error data query!");
            panel.showNotification();
            e.printStackTrace();
        }
    }

    private void clear() {
        lblNameProduct.setText("NAME PRODUCT");
        lblPrice.setText("Price ");
        lblImage.setIcon(null);
        lblImage.setText("IMG");
        lblAmount.setText("Total: 0");
        btnAmount.setValue(0);
        cboSearch.setSelectedIndex(0);
    }

    /**
     * Ham tinh tong tien- > show len lblSum
     *
     * @param x la so luong san pham
     */
    /**
     * Ham load du lieu len cbo san pham
     *
     * @param maNCC
     */
    public void fillcboSanPham(String maNCC) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboSearch.getModel();
        model.removeAllElements();

        // Add empty to 
        model.addElement("");
        try {
            List<SanPham> list = dao.selectByIdNCC(maNCC);
            for (SanPham sp : list) {
                model.addElement(sp);
            }
        } catch (Exception e) {
            Notification panel = new Notification(Employee_Form.fr, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Error data query!");
            panel.showNotification();
        }
    }
}
