/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.raven.DAO.CTHDNhapDAO;
import com.raven.DAO.HDNhapDAO;
import com.raven.model.CTHDNhap;
import com.raven.model.HDNhap;
import com.raven.swing.scrollbar.ScrollBarCustom;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javaswingdev.Notification;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AD MIN
 */
public class TableImport extends javax.swing.JPanel {

    HDNhapDAO dao = new HDNhapDAO();
    CTHDNhapDAO ctdao = new CTHDNhapDAO();
    int indexHD;
    int indexCT;
    static JComboBox cbo = new JComboBox();
    public TableImport() {
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

        scroll = new javax.swing.JScrollPane();
        tblHDNhap = new com.raven.swing.table.Table();
        roundPanel1 = new com.raven.swing.RoundPanel();
        scroll1 = new javax.swing.JScrollPane();
        roundPanel2 = new com.raven.swing.RoundPanel();
        lblTenNCC = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblSoPhieu = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblMaNV = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblNgayNhap = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        scroll2 = new javax.swing.JScrollPane();
        tblCTHDNhap = new com.raven.swing.table.Table();

        setBackground(new java.awt.Color(255, 255, 255));

        tblHDNhap.setBackground(new java.awt.Color(255, 255, 255));
        tblHDNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SoPhieu", "NgayNhap", "NCC", "MaNV"
            }
        ));
        tblHDNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHDNhapMouseClicked(evt);
            }
        });
        scroll.setViewportView(tblHDNhap);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        scroll1.setBackground(new java.awt.Color(255, 255, 255));
        scroll1.setBorder(null);

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblTenNCC.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTenNCC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenNCC.setText("NAME NCC");

        jLabel2.setText("Invoice No :");

        lblSoPhieu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSoPhieu.setText("HD041409");

        jLabel7.setText("Employe No :");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblMaNV.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMaNV.setText("Cus123");

        jLabel9.setText("Date :");

        lblNgayNhap.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNgayNhap.setText("25/11/2020");

        jLabel31.setText("Total");

        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("$999.99");

        tblCTHDNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Qty", "Price"
            }
        ));
        tblCTHDNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTHDNhapMouseClicked(evt);
            }
        });
        scroll2.setViewportView(tblCTHDNhap);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scroll2, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(roundPanel2Layout.createSequentialGroup()
                            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(roundPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblSoPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(roundPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMaNV)))
                            .addGap(14, 14, 14)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel9)
                            .addGap(29, 29, 29)
                            .addComponent(lblNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(roundPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel31)
                            .addGap(209, 209, 209)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator4))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(roundPanel2Layout.createSequentialGroup()
                            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(lblSoPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(lblMaNV)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(lblNgayNhap)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(lblTotal))
                .addGap(154, 154, 154))
        );

        scroll1.setViewportView(roundPanel2);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHDNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHDNhapMouseClicked
        if (evt.getClickCount() == 2) {
            this.indexHD = tblHDNhap.rowAtPoint(evt.getPoint());
            if (this.indexHD >= 0) {
                this.editHD();
            }
        }
    }//GEN-LAST:event_tblHDNhapMouseClicked

    private void tblCTHDNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTHDNhapMouseClicked
        // TODO add your handling code here:
//        if (evt.getClickCount() == 2) {
//            this.indexCT = tblCTHDNhap.rowAtPoint(evt.getPoint());
//            if (this.indexCT >= 0) {
//                this.editCT();
//            }
//        }
    }//GEN-LAST:event_tblCTHDNhapMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblNgayNhap;
    private javax.swing.JLabel lblSoPhieu;
    private javax.swing.JLabel lblTenNCC;
    private javax.swing.JLabel lblTotal;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JScrollPane scroll2;
    private com.raven.swing.table.Table tblCTHDNhap;
    private com.raven.swing.table.Table tblHDNhap;
    // End of variables declaration//GEN-END:variables

    public void init() {
        tblHDNhap.setDefaultEditor(Object.class, null);
        tblCTHDNhap.setDefaultEditor(Object.class, null);
        loadHD();
        DefaultComboBoxModel model = (DefaultComboBoxModel)cbo.getModel();
        model.addElement("0");
        model.addElement("1");
        model.addElement("2");
        cbo.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(cbo.getSelectedIndex()==1)
                    LoadHD2date(ManageInvoice.date1, ManageInvoice.date2);
                else if(cbo.getSelectedIndex()==2)
                    LoadHD1date(ManageInvoice.date1);
            }
        });
    }

    /**
     * Ham load tat ca hoa don len tbl
     */
    public void LoadHD2date(String dateFrom, String dateTo){
        DefaultTableModel model = (DefaultTableModel) tblHDNhap.getModel();
        model.setRowCount(0);
        try {
            List<HDNhap> list = dao.select2Date(dateFrom, dateTo);
            for (HDNhap hd : list) {
                Object[] row = {
                    hd.getSoPhieu(),
                    hd.getNgayNhap(),
                    hd.getMaNCC(),
                    hd.getMaNV()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            Notification panel = new Notification(Employee_Form.fr, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Error data query!");
            panel.showNotification();
            e.printStackTrace();
        }
    }
    
    public void LoadHD1date(String date){
        DefaultTableModel model = (DefaultTableModel) tblHDNhap.getModel();
        model.setRowCount(0);
        try {
            List<HDNhap> list = dao.select1Date(date);
            for (HDNhap hd : list) {
                Object[] row = {
                    hd.getSoPhieu(),
                    hd.getNgayNhap(),
                    hd.getMaNCC(),
                    hd.getMaNV()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            Notification panel = new Notification(Employee_Form.fr, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Error data query!");
            panel.showNotification();
            e.printStackTrace();
        }
    }
    
    private void loadHD() {
        DefaultTableModel model = (DefaultTableModel) tblHDNhap.getModel();
        model.setRowCount(0);
        try {
            List<HDNhap> list = dao.select();
            for (HDNhap hd : list) {
                Object[] row = {
                    hd.getSoPhieu(),
                    hd.getNgayNhap(),
                    hd.getMaNCC(),
                    hd.getMaNV()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            Notification panel = new Notification(Employee_Form.fr, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Error data query!");
            panel.showNotification();
            e.printStackTrace();
        }
    }

    /**
     * Ham load tat ca sp nam trong 1 hoa don
     * @param soPhieu la soPhieu trong hoa don
     */
    private void loadCT(String soPhieu) {
        DefaultTableModel model = (DefaultTableModel) tblCTHDNhap.getModel();
        model.setRowCount(0);
        try {
            List<CTHDNhap> list = ctdao.selectListById(soPhieu);
            for (CTHDNhap ct : list) {
                Object[] row = {
                    ct.getSoPhieu(),
                    ct.getSoLuong(),
                    ct.getGiaNhap()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            Notification panel = new Notification(Employee_Form.fr, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Error data query!");
            panel.showNotification();
            e.printStackTrace();
        }
    }

    /**
     * Ham tinh tong tien trong hoa don
     * @param model la hoa don can tinh
     * @return tong tien trong hd
     */
    public int getTotal(HDNhap model) {
        List<CTHDNhap> list = ctdao.selectListById(String.valueOf(model.getSoPhieu()));
        int sum = 0;
        for (CTHDNhap ct : list) {
            sum += ct.getGiaNhap();
        }
        return sum;
    }

    /**
     * Xu ly khi chon hd trong bang hoa don
     */
    private void editHD() {
        try {
            Integer soPhieu = (Integer) tblHDNhap.getValueAt(this.indexHD, 0);
            HDNhap model = dao.selectById(String.valueOf(soPhieu));
            if (model != null) {
                // Load tbl CT
                setModel(model); // Hien thong tin hao don
                loadCT(String.valueOf(soPhieu)); // Load cac sp trong hoa don 
            }
        } catch (Exception e) {
            Notification panel = new Notification(Employee_Form.fr, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Error data query!");
            panel.showNotification();
            e.printStackTrace();
        }
    }

    /**
     * Xy ly khi chon san pham trong bang ct hoa don
     */
//    private void editCT() {
//        try {
//            String soPhieu = (String) tblHDNhap.getValueAt(this.indexHD, 0);
//            String maSP = (String) tblCTHDNhap.getValueAt(this.indexCT, 0);
//            CTHDNhap model = ctdao.selectById(soPhieu, maSP);
//            if(model != null) {
//                // Code
//            }
//        } catch (Exception e) {
//        }
//    }
    
    /**
     * Hien thong tin hoa don len form
     * @param model la hoa don can show
     */
    private void setModel(HDNhap model) {
        lblTenNCC.setText(model.getMaNCC());
        lblSoPhieu.setText(model.getSoPhieu()+"");
        lblNgayNhap.setText(model.getNgayNhap());
        lblMaNV.setText(model.getMaNV());
        lblTotal.setText(getTotal(model)+"");
    }
    
    /**
     * Set scrtoll
     */
    private void setLayout() {
        scroll.setBorder(null);
        scroll.setViewportBorder(null);
        scroll.getViewport().setOpaque(false);
        scroll.setVerticalScrollBar(new ScrollBarCustom());

        scroll1.setBorder(null);
        scroll1.setViewportBorder(null);
        scroll1.getViewport().setOpaque(false);
        scroll1.setVerticalScrollBar(new ScrollBarCustom());
    }
}
