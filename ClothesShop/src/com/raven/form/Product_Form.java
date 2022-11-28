package com.raven.form;

import com.raven.DAO.LoaiHangDAO;
import com.raven.DAO.NhaCungCapDAO;
import com.raven.DAO.SanPhamDAO;
import com.raven.component.Item;
import com.raven.event.EventItem;
import com.raven.model.LoaiHang;
import com.raven.model.ModelItem;
import com.raven.model.NhaCungCap;
import com.raven.model.SanPham;
import com.raven.swing.ScrollBar;
import com.raven.utils.Auth;
import com.raven.utils.XDialog;
import com.raven.utils.XShare;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

public class Product_Form extends javax.swing.JPanel {
    private EventItem event;
    SanPhamDAO dao = new SanPhamDAO();
    LoaiHangDAO lhdao = new LoaiHangDAO();
    NhaCungCapDAO nccdao = new NhaCungCapDAO();

    public Product_Form() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        panelItem = new com.raven.swing.PanelItem();
        jPanel1 = new javax.swing.JPanel();
        roundPanel1 = new com.raven.swing.RoundPanel();
        txtGiamGia = new textfield.TextField();
        txtGia = new textfield.TextField();
        txtTenSP = new textfield.TextField();
        txtMaSP = new textfield.TextField();
        btnSave = new button.Button();
        btnDelete = new button.Button();
        txtAnh = new textfield.TextField();
        btnAnh = new button.Button();
        lbBrand1 = new javax.swing.JLabel();
        lbBrand = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cboLoaiHang = new combo_suggestion.ComboBoxSuggestion();
        btnClear = new button.Button();
        cboNCC = new combo_suggestion.ComboBoxSuggestion();

        setOpaque(false);

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setViewportView(panelItem);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtGiamGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGiamGia.setLabelText("Sale");
        txtGiamGia.setMargin(new java.awt.Insets(0, 6, 0, 6));
        txtGiamGia.setRound(0);

        txtGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGia.setLabelText("Price ");
        txtGia.setMargin(new java.awt.Insets(0, 6, 0, 6));
        txtGia.setRound(0);

        txtTenSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenSP.setLabelText("Product's Name");
        txtTenSP.setMargin(new java.awt.Insets(0, 6, 0, 6));
        txtTenSP.setRound(0);

        txtMaSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaSP.setLabelText("Product's ID");
        txtMaSP.setMargin(new java.awt.Insets(0, 6, 0, 6));
        txtMaSP.setRound(0);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtAnh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAnh.setLabelText("");
        txtAnh.setMargin(new java.awt.Insets(0, 6, 0, 6));
        txtAnh.setRound(0);

        btnAnh.setText("Choose Image");
        btnAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnhActionPerformed(evt);
            }
        });

        lbBrand1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbBrand1.setForeground(new java.awt.Color(76, 76, 76));
        lbBrand1.setText("Product");

        lbBrand.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbBrand.setForeground(new java.awt.Color(76, 76, 76));
        lbBrand.setText("  Type ");

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cboNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboLoaiHang, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbBrand)
                            .addComponent(lbBrand1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                                .addComponent(txtAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1))))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        roundPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnClear, btnDelete, btnSave});

        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBrand1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbBrand)
                .addGap(12, 12, 12)
                .addComponent(cboLoaiHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        roundPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClear, btnDelete, btnSave});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(btnSave.getText().equals("Add")) {
            insert();
        }else if (btnSave.getText().equals("Save")) {
            update();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnhActionPerformed
        // TODO add your handling code here:
        selectImage();
    }//GEN-LAST:event_btnAnhActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button btnAnh;
    private button.Button btnClear;
    private button.Button btnDelete;
    private button.Button btnSave;
    private combo_suggestion.ComboBoxSuggestion cboLoaiHang;
    private combo_suggestion.ComboBoxSuggestion cboNCC;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbBrand;
    private javax.swing.JLabel lbBrand1;
    private com.raven.swing.PanelItem panelItem;
    private com.raven.swing.RoundPanel roundPanel1;
    private javax.swing.JScrollPane scroll;
    private textfield.TextField txtAnh;
    private textfield.TextField txtGia;
    private textfield.TextField txtGiamGia;
    private textfield.TextField txtMaSP;
    private textfield.TextField txtTenSP;
    // End of variables declaration//GEN-END:variables

    private void init() {
        fillcboLoaiHang();
        fillcboNhaCungCap();
        load();
        clear();
        setStatus(true);
        testData();
        scroll.setVerticalScrollBar(new ScrollBar());
    }
    
    private void testData() {
        setEvent(new EventItem() {
            @Override
            public void itemClick(Component com, ModelItem item) {
                edit(item.getItemID());
            }
        });
        
    }
    
    private void load() {
        panelItem.removeAll();
        
        List<SanPham> list = dao.select();
        for (int i = 0; i < 11; i++) {
            addItem(new ModelItem(list.get(i).getMaSP(), list.get(i).getTenSP(), list.get(i).getMaNCC(), list.get(i).getGiaBan(), list.get(i).getMaLH(), new ImageIcon(getClass().getResource(("/com/raven/image/" + list.get(i).getAnh())))));
        }
    }

    private Point getLocationOf(Component com) {
        Point p = getPanelItemLocation();
        int x = p.x;
        int y = p.y;
        int itemX = com.getX();
        int itemY = com.getY();
        int left = 10;
        int top = 35;
        return new Point(x + itemX + left, y + itemY + top);
    }

    public void setEvent(EventItem event) {
        this.event = event;
    }
    
    public void addItem(ModelItem data) {
        Item item = new Item();
        item.setData(data);
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    event.itemClick(item, data);
                }
            }
        });
        panelItem.add(item);
        panelItem.repaint();
        panelItem.revalidate();
    }

    public void setSelected(Component item) {
        for (Component com : panelItem.getComponents()) {
            Item i = (Item) com;
            if (i.isSelected()) {
                i.setSelected(false);
            }
        }
        ((Item) item).setSelected(true);
    }

    public void showItem(ModelItem data) {
//        lbItemName.setText(data.getItemName());
//        txtDescription.setText(data.getDescription());
//        lbBrand.setText(data.getBrandName());
//        DecimalFormat df = new DecimalFormat("$#,##0.00");
//        lbPrice.setText(df.format(data.getPrice()));
    }

    public Point getPanelItemLocation() {
        Point p = scroll.getLocation();
        return new Point(p.x, p.y - scroll.getViewport().getViewPosition().y);
    }
    
    private boolean isValidate() {
        if(txtMaSP.getText().equals("")) {
            XDialog.alert(this, "Your ID isn't null");
            return false;
        }
        if(txtMaSP.getText().length()>5) {
            XDialog.alert(this, "Your ID isn't > 5");
            return false;
        }
        if(txtTenSP.getText().equals("")) {
            XDialog.alert(this, "Your name isn't null");
            return false;
        }
        
        try {
            Integer gia = Integer.parseInt(txtGia.getText());
            if(gia < 0) {
                XDialog.alert(this, "Price can't be < 0");
                return false;
            }
        } catch (Exception e) {
            XDialog.alert(this, "Price is number");
            return false;
        }
        
        try {
            Integer giamGia = Integer.parseInt(txtGiamGia.getText());
            if(giamGia < 0) {
                XDialog.alert(this, "Salse can't be < 0");
                return false;
            }
        } catch (Exception e) {
            XDialog.alert(this, "Sale is number");
            return false;
        }
        return true;
    }
    
    private void insert() {
        SanPham model = getModel();
        if(!isValidate())
            return;
        try {
            dao.insert(model);
            load();
            clear();
            XDialog.alert(this, "Add successful");
        } catch (Exception e) {
            XDialog.alert(this, "Add fail");
        }
    }
    
    private void update() {
        SanPham model = getModel();
        try {
            dao.update(model);
            load();
            clear();
            XDialog.alert(this, "Update successful");
        } catch (Exception e) {
            XDialog.alert(this, "Update fail");
        }
    }
    
    private void delete() {
        if(!Auth.isManager())
            XDialog.alert(this, "You do not have permission to delete");
        else {
            if(XDialog.confirm(this, "Are you sure to delete")) {
                String maSP = txtMaSP.getText();
                try {
                    dao.delete(maSP);
                    load();
                    clear();
                    XDialog.alert(this, "Delete successful");
                } catch (Exception e) {
                    XDialog.alert(this, "Delete fail");
                }
            }
        }
    }
    
    private void clear() {
        cboLoaiHang.setSelectedIndex(0);
        cboNCC.setSelectedIndex(0);
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtGia.setText("0");
        txtGiamGia.setText("0");
        txtAnh.setText("");
        setStatus(true);
    }
    
    private void edit(String maSP) {
        try {
            SanPham model = dao.selectById(maSP);
            if (model != null) {
                this.setModel(model);
                this.setStatus(false);
            }
        } catch (Exception e) {
            XDialog.alert(this, "Error data query!");
            System.out.println(e);
        }
    }
    
    private void setModel(SanPham model) {
        cboLoaiHang.setSelectedItem(lhdao.selectById(model.getMaLH()));
        cboNCC.setSelectedItem(nccdao.selectById(model.getMaNCC()));
        txtMaSP.setText(model.getMaSP());
        txtTenSP.setText(model.getTenSP());
        txtGia.setText(String.valueOf(model.getGiaBan()));
        txtGiamGia.setText(String.valueOf(model.getGiamgia()));
        txtAnh.setText(model.getAnh());
    }
    
    private SanPham getModel() {
        SanPham model = new SanPham();
        LoaiHang loaihang = (LoaiHang) cboLoaiHang.getSelectedItem();
        NhaCungCap ncc = (NhaCungCap) cboNCC.getSelectedItem();
        model.setMaSP(txtMaSP.getText());
        model.setTenSP(txtTenSP.getText());
        model.setGiaBan(Integer.parseInt(txtGia.getText()));
        model.setGiamgia(Integer.parseInt(txtGiamGia.getText()));
        model.setMaLH(loaihang.getMaLoai());
        model.setMaNCC(ncc.getMaNCC());
        model.setAnh(txtAnh.getText());
        return model;
    }
    
    private void setStatus(boolean insertable) {
        if(insertable)
            btnSave.setText("Add");
        else
            btnSave.setText("Save");
        
        btnDelete.setEnabled(!insertable);
        txtMaSP.setEditable(insertable);
    }
    
    private void fillcboLoaiHang() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboLoaiHang.getModel();
        model.removeAllElements();
        try {
            List<LoaiHang> list = lhdao.select();
            for (LoaiHang cd : list) {
                model.addElement(cd);
            }
        } catch (Exception e) {
            XDialog.alert(this, "Error data query!");
        }
    }
    
    private void fillcboNhaCungCap() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboNCC.getModel();
        model.removeAllElements();
        try {
            List<NhaCungCap> list = nccdao.select();
            for (NhaCungCap ncc : list) {
                model.addElement(ncc);
            }
        } catch (Exception e) {
            XDialog.alert(this, "Error data query!");
        }
    }
    
    private void selectImage() {
        try {
            JFileChooser f = new JFileChooser("src\\com\\raven\\image");
            f.showOpenDialog(this);
            
            File file = f.getSelectedFile();
            if (XShare.saveLogo(file)) {
                // Hiển thị hình lên form
                txtAnh.setText(file.getName());
            }
        } catch (HeadlessException ex) {
            System.out.println("Chua chon anh");
        }
    }
}
