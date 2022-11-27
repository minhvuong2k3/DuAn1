/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.raven.DAO.SanPhamDAO;
import com.raven.DAO.ThongKeDAO;
import com.raven.model.SanPham;
import com.raven.model.ThongKeSP;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javaswingdev.chart.ModelChart;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author AD MIN
 */
public class TurnoverProduct_Form extends javax.swing.JPanel {

    /**
     * Creates new form ThongKeForm
     */
    ThongKeDAO dao = new ThongKeDAO();
    SanPhamDAO spdao = new SanPhamDAO();
    public TurnoverProduct_Form() {
        initComponents();
        init();
    }

    private void init() {
        Date date = new Date();
        List<Object[]> list = dao.getSanPhamTop3(date.getYear()+1900, date.getMonth()+1);
        chart1.addLegend((String) list.get(0)[0], new Color(12, 84, 175), new Color(0, 108, 247));
        chart1.addLegend((String) list.get(1)[0], new Color(54, 4, 143), new Color(104, 49, 200));
        chart1.addLegend((String) list.get(2)[0], new Color(5, 125, 0), new Color(95, 209, 69));
        
        SanPham sp1 = spdao.selectById((String) list.get(0)[0]);
        SanPham sp2 = spdao.selectById((String) list.get(1)[0]);
        SanPham sp3 = spdao.selectById((String) list.get(2)[0]);
        
        lblNameSP1.setText(sp1.getTenSP());
        lblNameSP2.setText(sp2.getTenSP());
        lblNameSP3.setText(sp3.getTenSP());
        lblMoneySP1.setText(list.get(0)[1].toString());
        lblMoneySP2.setText(list.get(1)[1].toString());
        lblMoneySP3.setText(list.get(2)[1].toString());
        lblImageSP1.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(("/com/raven/image/" + sp1.getAnh()))).getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
        lblImageSP2.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(("/com/raven/image/" + sp2.getAnh()))).getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
        lblImageSP3.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(("/com/raven/image/" + sp3.getAnh()))).getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
        lblImageSP1.setText("");
        lblImageSP2.setText("");
        lblImageSP3.setText("");
        
        List<Object[]> khachHang = dao.getKhachHangTop3();
        lblNameCus1.setText(khachHang.get(0)[0].toString());
        lblNameCus2.setText(khachHang.get(1)[0].toString());
        lblNameCus3.setText(khachHang.get(2)[0].toString());
        lblSdtCus1.setText(khachHang.get(0)[1].toString());
        lblSdtCus2.setText(khachHang.get(1)[1].toString());
        lblSdtCus3.setText(khachHang.get(2)[1].toString());
        lblAmountCus1.setText(khachHang.get(0)[2].toString());
        lblAmountCus2.setText(khachHang.get(1)[2].toString());
        lblAmountCus3.setText(khachHang.get(2)[2].toString());
        
        ArrayList<Object[]> giaTri = new ArrayList<>();
        
        int k = 0;
        for(int i=0; i<6;i++){
            Object[] a = new Object[3];
            List<Object[]> list1 = dao.getSanPhamThang(date.getYear()+1900, date.getMonth()+1-k, (String) list.get(0)[0]);
            List<Object[]> list2 = dao.getSanPhamThang(date.getYear()+1900, date.getMonth()+1-k, (String) list.get(1)[0]);
            List<Object[]> list3 = dao.getSanPhamThang(date.getYear()+1900, date.getMonth()+1-k, (String) list.get(2)[0]);
            if(list1.size()>0)
                a[0] = list1.get(0)[1];
            else 
                a[0] = 0;
            if(list2.size()>0)
                a[1] = list2.get(0)[1];
            else 
                a[1] = 0;
            if(list3.size()>0)
                a[2] = list3.get(0)[1];
            else 
                a[2] = 0;
            giaTri.add(a);
            k++;
        }
        chart1.addData(new com.raven.chart.ModelChart("June", new double[]{Double.valueOf(giaTri.get(5)[0].toString()), Double.valueOf(giaTri.get(5)[1].toString()), Double.valueOf(giaTri.get(5)[2].toString())}));
        chart1.addData(new com.raven.chart.ModelChart("July", new double[]{Double.valueOf(giaTri.get(4)[0].toString()), Double.valueOf(giaTri.get(4)[1].toString()), Double.valueOf(giaTri.get(4)[2].toString())}));
        chart1.addData(new com.raven.chart.ModelChart("August", new double[]{Double.valueOf(giaTri.get(3)[0].toString()), Double.valueOf(giaTri.get(3)[1].toString()), Double.valueOf(giaTri.get(3)[2].toString())}));
        chart1.addData(new com.raven.chart.ModelChart("September", new double[]{Double.valueOf(giaTri.get(2)[0].toString()), Double.valueOf(giaTri.get(2)[1].toString()), Double.valueOf(giaTri.get(2)[2].toString())}));
        chart1.addData(new com.raven.chart.ModelChart("October", new double[]{Double.valueOf(giaTri.get(1)[0].toString()), Double.valueOf(giaTri.get(1)[1].toString()), Double.valueOf(giaTri.get(1)[2].toString())}));
        chart1.addData(new com.raven.chart.ModelChart("November", new double[]{Double.valueOf(giaTri.get(0)[0].toString()), Double.valueOf(giaTri.get(0)[1].toString()), Double.valueOf(giaTri.get(0)[2].toString())}));
        chart1.start();
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
        jLabel2 = new javax.swing.JLabel();
        roundPanel7 = new com.raven.swing.RoundPanel();
        lblNameCus3 = new javax.swing.JLabel();
        lblAmountCus3 = new javax.swing.JLabel();
        lblIconCus3 = new javax.swing.JLabel();
        lblSdtCus3 = new javax.swing.JLabel();
        button5 = new button.Button();
        roundPanel11 = new com.raven.swing.RoundPanel();
        lblAmountCus1 = new javax.swing.JLabel();
        lblNameCus1 = new javax.swing.JLabel();
        lblSdtCus1 = new javax.swing.JLabel();
        button3 = new button.Button();
        lblIconCus1 = new javax.swing.JLabel();
        roundPanel12 = new com.raven.swing.RoundPanel();
        lblIconCus2 = new javax.swing.JLabel();
        lblNameCus2 = new javax.swing.JLabel();
        lblSdtCus2 = new javax.swing.JLabel();
        button4 = new button.Button();
        lblAmountCus2 = new javax.swing.JLabel();
        button1 = new button.Button();
        roundPanel2 = new com.raven.swing.RoundPanel();
        chart1 = new com.raven.chart.CurveChart();
        roundPanel3 = new com.raven.swing.RoundPanel();
        jLabel3 = new javax.swing.JLabel();
        roundPanel8 = new com.raven.swing.RoundPanel();
        lblNameSP2 = new javax.swing.JLabel();
        lblMoneySP2 = new javax.swing.JLabel();
        lblImageSP2 = new javax.swing.JLabel();
        button7 = new button.Button();
        roundPanel9 = new com.raven.swing.RoundPanel();
        lblNameSP1 = new javax.swing.JLabel();
        lblMoneySP1 = new javax.swing.JLabel();
        lblImageSP1 = new javax.swing.JLabel();
        button6 = new button.Button();
        roundPanel10 = new com.raven.swing.RoundPanel();
        lblImageSP3 = new javax.swing.JLabel();
        lblNameSP3 = new javax.swing.JLabel();
        lblMoneySP3 = new javax.swing.JLabel();
        button8 = new button.Button();
        button2 = new button.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        roundPanel1.setBackground(new java.awt.Color(207, 245, 231));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("TOP CUSTOMERS");

        roundPanel7.setBackground(new java.awt.Color(255, 255, 255));

        lblNameCus3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNameCus3.setText("Name");

        lblAmountCus3.setText("Total Amount");

        lblIconCus3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconCus3.setText("3");

        lblSdtCus3.setText("Type");

        button5.setBackground(new java.awt.Color(80, 87, 122));
        button5.setForeground(new java.awt.Color(255, 255, 255));
        button5.setText("View");

        javax.swing.GroupLayout roundPanel7Layout = new javax.swing.GroupLayout(roundPanel7);
        roundPanel7.setLayout(roundPanel7Layout);
        roundPanel7Layout.setHorizontalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIconCus3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNameCus3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSdtCus3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAmountCus3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel7Layout.setVerticalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIconCus3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(lblNameCus3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(lblSdtCus3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAmountCus3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );

        roundPanel11.setBackground(new java.awt.Color(255, 255, 255));

        lblAmountCus1.setText("Total Amount");

        lblNameCus1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNameCus1.setText("Name");

        lblSdtCus1.setText("Type");

        button3.setBackground(new java.awt.Color(80, 87, 122));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setText("View");

        lblIconCus1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconCus1.setText("1");

        javax.swing.GroupLayout roundPanel11Layout = new javax.swing.GroupLayout(roundPanel11);
        roundPanel11.setLayout(roundPanel11Layout);
        roundPanel11Layout.setHorizontalGroup(
            roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIconCus1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNameCus1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSdtCus1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(lblAmountCus1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel11Layout.setVerticalGroup(
            roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNameCus1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(lblSdtCus1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(lblAmountCus1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIconCus1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addContainerGap())
        );

        roundPanel12.setBackground(new java.awt.Color(255, 255, 255));

        lblIconCus2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconCus2.setText("2");

        lblNameCus2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNameCus2.setText("Name");

        lblSdtCus2.setText("Type");

        button4.setBackground(new java.awt.Color(80, 87, 122));
        button4.setForeground(new java.awt.Color(255, 255, 255));
        button4.setText("View");

        lblAmountCus2.setText("Total Amount");

        javax.swing.GroupLayout roundPanel12Layout = new javax.swing.GroupLayout(roundPanel12);
        roundPanel12.setLayout(roundPanel12Layout);
        roundPanel12Layout.setHorizontalGroup(
            roundPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIconCus2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNameCus2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSdtCus2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAmountCus2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel12Layout.setVerticalGroup(
            roundPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIconCus2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(lblNameCus2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(lblSdtCus2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(lblAmountCus2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        button1.setBackground(new java.awt.Color(80, 87, 122));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("View All");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roundPanel3.setBackground(new java.awt.Color(207, 245, 231));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("TOP PRODUCTS");

        roundPanel8.setBackground(new java.awt.Color(255, 255, 255));

        lblNameSP2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNameSP2.setText("Name");

        lblMoneySP2.setText("Money");

        lblImageSP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageSP2.setText("IMG");

        button7.setBackground(new java.awt.Color(80, 87, 122));
        button7.setForeground(new java.awt.Color(255, 255, 255));
        button7.setText("View");

        javax.swing.GroupLayout roundPanel8Layout = new javax.swing.GroupLayout(roundPanel8);
        roundPanel8.setLayout(roundPanel8Layout);
        roundPanel8Layout.setHorizontalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImageSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMoneySP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNameSP2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel8Layout.setVerticalGroup(
            roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblImageSP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel8Layout.createSequentialGroup()
                            .addComponent(lblNameSP2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblMoneySP2))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        roundPanel9.setBackground(new java.awt.Color(255, 255, 255));

        lblNameSP1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNameSP1.setText("Name");

        lblMoneySP1.setText("Money");

        lblImageSP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageSP1.setText("IMG");

        button6.setBackground(new java.awt.Color(80, 87, 122));
        button6.setForeground(new java.awt.Color(255, 255, 255));
        button6.setText("View");

        javax.swing.GroupLayout roundPanel9Layout = new javax.swing.GroupLayout(roundPanel9);
        roundPanel9.setLayout(roundPanel9Layout);
        roundPanel9Layout.setHorizontalGroup(
            roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImageSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMoneySP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNameSP1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel9Layout.setVerticalGroup(
            roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblImageSP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel9Layout.createSequentialGroup()
                            .addComponent(lblNameSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblMoneySP1))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        roundPanel10.setBackground(new java.awt.Color(255, 255, 255));

        lblImageSP3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageSP3.setText("IMG");

        lblNameSP3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNameSP3.setText("Name");

        lblMoneySP3.setText("Money");

        button8.setBackground(new java.awt.Color(80, 87, 122));
        button8.setForeground(new java.awt.Color(255, 255, 255));
        button8.setText("View");

        javax.swing.GroupLayout roundPanel10Layout = new javax.swing.GroupLayout(roundPanel10);
        roundPanel10.setLayout(roundPanel10Layout);
        roundPanel10Layout.setHorizontalGroup(
            roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImageSP3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMoneySP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNameSP3, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel10Layout.setVerticalGroup(
            roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel10Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblImageSP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundPanel10Layout.createSequentialGroup()
                            .addComponent(lblNameSP3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblMoneySP3))))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        button2.setBackground(new java.awt.Color(80, 87, 122));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("View all");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel3Layout.createSequentialGroup()
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(roundPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(roundPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button button1;
    private button.Button button2;
    private button.Button button3;
    private button.Button button4;
    private button.Button button5;
    private button.Button button6;
    private button.Button button7;
    private button.Button button8;
    private com.raven.chart.CurveChart chart1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblAmountCus1;
    private javax.swing.JLabel lblAmountCus2;
    private javax.swing.JLabel lblAmountCus3;
    private javax.swing.JLabel lblIconCus1;
    private javax.swing.JLabel lblIconCus2;
    private javax.swing.JLabel lblIconCus3;
    private javax.swing.JLabel lblImageSP1;
    private javax.swing.JLabel lblImageSP2;
    private javax.swing.JLabel lblImageSP3;
    private javax.swing.JLabel lblMoneySP1;
    private javax.swing.JLabel lblMoneySP2;
    private javax.swing.JLabel lblMoneySP3;
    private javax.swing.JLabel lblNameCus1;
    private javax.swing.JLabel lblNameCus2;
    private javax.swing.JLabel lblNameCus3;
    private javax.swing.JLabel lblNameSP1;
    private javax.swing.JLabel lblNameSP2;
    private javax.swing.JLabel lblNameSP3;
    private javax.swing.JLabel lblSdtCus1;
    private javax.swing.JLabel lblSdtCus2;
    private javax.swing.JLabel lblSdtCus3;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel10;
    private com.raven.swing.RoundPanel roundPanel11;
    private com.raven.swing.RoundPanel roundPanel12;
    private com.raven.swing.RoundPanel roundPanel2;
    private com.raven.swing.RoundPanel roundPanel3;
    private com.raven.swing.RoundPanel roundPanel7;
    private com.raven.swing.RoundPanel roundPanel8;
    private com.raven.swing.RoundPanel roundPanel9;
    // End of variables declaration//GEN-END:variables
}
