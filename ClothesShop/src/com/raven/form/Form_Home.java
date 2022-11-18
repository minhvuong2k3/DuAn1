package com.raven.form;

import com.raven.DAO.NhanVienDAO;
import com.raven.dialog.Message;
import com.raven.main.Main;
import com.raven.model.ModelCard;
import com.raven.model.ModelStaff;
import com.raven.model.ModelStudent;
import com.raven.model.NhanVien;
import com.raven.swing.EventNavigationBar;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.noticeboard.ModelNoticeBoard;
import com.raven.swing.table.EventAction;
import com.raven.utils.XDialog;
import java.awt.Color;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javaswingdev.Notification;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class Form_Home extends javax.swing.JPanel {

    NhanVienDAO dao = new NhanVienDAO();
    List<NhanVien> list = dao.select();
    static Frame fr;

    public Form_Home(Frame frame) {
        initComponents();
        fr = frame;
        tblNhanVien.fixTable(jScrollPane1);
        setOpaque(false);
        initData();
        navigationBar1.addItem(new ImageIcon(getClass().getResource("/com/raven/swing/icon/item1.png")));
        navigationBar1.addItem(new ImageIcon(getClass().getResource("/com/raven/swing/icon/item2.png")));
        navigationBar1.addItem(new ImageIcon(getClass().getResource("/com/raven/swing/icon/item3.png")));
        navigationBar1.addEvent(new EventNavigationBar() {
            @Override
            public void beforeSelected(int index) {
                if (index == 0) {
                    //Tat ca
                    selectAll();
                } else if (index == 1) {
                    //Da co tai khoan
                    selectHave();
                } else if (index == 2) {
                    //Chua co tai khoan
                    selectYet();
                }
            }

            @Override

            public void afterSelected(int index) {

            }
        });
    }

    private void initData() {
        initCardData();
//        initNoticeBoard();
        initTableData();
    }

    private void initTableData() {
//        EventAction eventAction = new EventAction() {
//            @Override
//            public void delete(ModelStudent student) {
//                if (showMessage("Delete Student : " + student.getName())) {
//                    System.out.println("User click OK");
//                } else {
//                    System.out.println("User click Cancel");
//                }
//            }
//
//            @Override
//            public void update(ModelStudent student) {
////                if (showMessage("Update Student : " + student.getName())) {
////                    System.out.println("User click OK");
////                } else {
////                    System.out.println("User click Cancel");
////                }
//            }
//        };
        Date date = new Date();
        int day = date.getYear() + 1900;
        for (int i = 0; i < list.size(); i++) {
            tblNhanVien.addRow(new ModelStaff(list.get(i).getMaNV(), list.get(i).getHoten(), list.get(i).getGioiTinh() ? "Male" : "Female", (day - Integer.parseInt(list.get(i).getNgaySinh().substring(0, 4))), list.get(i).getEmail(), list.get(i).getSdt(), list.get(i).getMatKhau(), list.get(i).getVaiTro() ? "Admin" : "Employee").toTableRow());
        }

//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile.jpg")), "Jonh", "Male", "Java", 300).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile1.jpg")), "Dara", "Male", "C++", 300).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C", 300).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C", 300).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
//        table1.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
    }

    private void initCardData() {
//        Icon icon1 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.PEOPLE, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
//        card1.setData(new ModelCard("New Student", 5100, 20, icon1));
//        Icon icon2 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.MONETIZATION_ON, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
//        card2.setData(new ModelCard("Income", 2000, 60, icon2));
//        Icon icon3 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.SHOPPING_BASKET, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
//        card3.setData(new ModelCard("Expense", 3000, 80, icon3));
//        Icon icon4 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.BUSINESS_CENTER, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
//        card4.setData(new ModelCard("Other Income", 550, 95, icon4));
    }

    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.raven.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new com.raven.swing.table.Table();
        navigationBar1 = new com.raven.swing.NavigationBar();
        roundPanel2 = new com.raven.swing.RoundPanel();
        txtFullname = new textfield.TextField();
        txtID = new textfield.TextField();
        txtEmail = new textfield.TextField();
        btnDelete = new button.Button();
        btnReform = new button.Button();
        txtName3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtName4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new textfield.TextField();
        txtBirthday = new textfield.TextField();
        txtName1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        swbtnGender = new javaswingdev.SwitchButton();
        txtName5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblRender = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        swbtnRole = new javaswingdev.SwitchButton();
        txtName9 = new javax.swing.JLabel();
        txtName10 = new javax.swing.JLabel();
        txtPhone = new textfield.TextField();
        btnAdd = new button.Button();

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Gender", "Birthday", "Email", "Phone", "Password", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);
        if (tblNhanVien.getColumnModel().getColumnCount() > 0) {
            tblNhanVien.getColumnModel().getColumn(0).setPreferredWidth(100);
        }

        javax.swing.GroupLayout navigationBar1Layout = new javax.swing.GroupLayout(navigationBar1);
        navigationBar1.setLayout(navigationBar1Layout);
        navigationBar1Layout.setHorizontalGroup(
            navigationBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 766, Short.MAX_VALUE)
        );
        navigationBar1Layout.setVerticalGroup(
            navigationBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(navigationBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(roundPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(navigationBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(136, 136, 136)))
        );

        roundPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtFullname.setLabelText("");

        txtID.setLabelText("");
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtEmail.setLabelText("");

        btnDelete.setBackground(new java.awt.Color(255, 0, 51));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("DELETE");
        btnDelete.setEnabled(false);
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReform.setBackground(new java.awt.Color(219, 200, 172));
        btnReform.setForeground(new java.awt.Color(255, 255, 255));
        btnReform.setText("REFORM");
        btnReform.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReformActionPerformed(evt);
            }
        });

        txtName3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName3.setForeground(new java.awt.Color(102, 102, 102));
        txtName3.setText("ID");

        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("*");

        txtName4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName4.setForeground(new java.awt.Color(102, 102, 102));
        txtName4.setText("Full Name");

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("*");

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(102, 102, 102));
        txtName.setText("Email");

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*");

        txtName2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName2.setForeground(new java.awt.Color(102, 102, 102));
        txtName2.setText("Day Of Birth");

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");

        txtName6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName6.setForeground(new java.awt.Color(102, 102, 102));
        txtName6.setText("Phone");

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");

        txtPassword.setLabelText("");

        txtBirthday.setLabelText("yyyy-mm-dd");

        txtName1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName1.setForeground(new java.awt.Color(102, 102, 102));
        txtName1.setText("Gender");

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        swbtnGender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                swbtnGenderMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(swbtnGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(swbtnGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        txtName5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName5.setForeground(new java.awt.Color(102, 102, 102));
        txtName5.setText("Role");

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*");

        lblRender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRender.setForeground(new java.awt.Color(102, 102, 102));
        lblRender.setText("Female");

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");

        lblRole.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRole.setForeground(new java.awt.Color(102, 102, 102));
        lblRole.setText("Employee");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        swbtnRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                swbtnRoleMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(swbtnRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(swbtnRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        txtName9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName9.setForeground(new java.awt.Color(102, 102, 102));
        txtName9.setText("Password");

        txtName10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtName10.setText("EMPLOYEE");

        txtPhone.setLabelText("");

        btnAdd.setText("ADD");
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addComponent(txtName4)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel2))
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addComponent(txtName3)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel6))
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addComponent(txtName)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel4))
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addComponent(txtName2)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel3))
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addComponent(txtName6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel5))
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel7))
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addComponent(txtName5)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel8))
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addComponent(txtName9)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel9)))
                                .addGap(18, 18, 18)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(lblRender, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtFullname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtName10, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReform, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txtName10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtName3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName2)
                    .addComponent(jLabel3)
                    .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName6)
                    .addComponent(jLabel5))
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtName1)))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRender, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtName5)
                                .addComponent(jLabel8))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtName9)))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            NhanVien nv = list.get(tblNhanVien.rowAtPoint(evt.getPoint()));
            txtID.setText(nv.getMaNV());
            txtFullname.setText(nv.getHoten());
            txtEmail.setText(nv.getEmail());
            txtBirthday.setText(nv.getNgaySinh());
            txtPhone.setText(nv.getSdt());
            if (nv.getMatKhau() != null) {
                txtPassword.setText(nv.getMatKhau());
            }
            lblRender.setText(nv.getGioiTinh() ? "Male" : "Female");
            lblRole.setText(nv.getVaiTro() ? "Admin" : "Employee");
            if (nv.getGioiTinh()) {
                swbtnGender.setSelected(true);
            } else {
                swbtnGender.setSelected(false);
            }
            if (nv.getVaiTro()) {
                swbtnRole.setSelected(true);
            } else {
                swbtnRole.setSelected(false);
            }
            txtID.setEditable(false);
            btnAdd.setText("UPDATE");
            btnDelete.setEnabled(true);
        }
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void swbtnGenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_swbtnGenderMouseClicked
        // TODO add your handling code here:
        if (swbtnGender.isSelected())
            lblRender.setText("Male");
        else
            lblRender.setText("Female");
    }//GEN-LAST:event_swbtnGenderMouseClicked

    private void swbtnRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_swbtnRoleMouseClicked
        // TODO add your handling code here:
        if (swbtnRole.isSelected())
            lblRender.setText("Admin");
        else
            lblRender.setText("Employee");
    }//GEN-LAST:event_swbtnRoleMouseClicked

    private void btnReformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReformActionPerformed
        // TODO add your handling code here:
        reform();
    }//GEN-LAST:event_btnReformActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if (btnAdd.getText().equals("ADD")) {
            if (txtPassword.getText().trim().equals("")) {
                if (ValidateInsert(0)) {
                    NhanVien model = new NhanVien();
                    model.setMaNV(txtID.getText().trim());
                    model.setHoten(txtFullname.getText().trim());
                    model.setEmail(txtEmail.getText().trim());
                    model.setNgaySinh(txtBirthday.getText().trim());
                    model.setSdt(txtPhone.getText().trim());
                    model.setGioiTinh(lblRender.getText().equals("Male"));
                    dao.insertNV(model);
                    list = dao.select();
                    DefaultTableModel modelTable = (DefaultTableModel) tblNhanVien.getModel();
                    modelTable.setRowCount(0);
                    tblNhanVien.revalidate();
                    initTableData();
                    notification(fr, "Insert success !", true);
                }
            } else {
                if (ValidateInsert(0)) {
                    NhanVien model = new NhanVien();
                    model.setMaNV(txtID.getText().trim());
                    model.setHoten(txtFullname.getText().trim());
                    model.setEmail(txtEmail.getText().trim());
                    model.setNgaySinh(txtBirthday.getText().trim());
                    model.setSdt(txtPhone.getText().trim());
                    model.setGioiTinh(lblRender.getText().equals("Male"));
                    model.setVaiTro(lblRole.getText().equals("Admin"));
                    model.setMatKhau(txtPassword.getText());
                    dao.insert(model);
                    list = dao.select();
                    DefaultTableModel modelTable = (DefaultTableModel) tblNhanVien.getModel();
                    modelTable.setRowCount(0);
                    tblNhanVien.revalidate();
                    initTableData();
                    notification(fr, "Insert success !", true);
                }
            }
        } else {
            if (ValidateUpdate()) {
                NhanVien model = new NhanVien();
                model.setMaNV(txtID.getText().trim());
                model.setHoten(txtFullname.getText().trim());
                model.setEmail(txtEmail.getText().trim());
                model.setNgaySinh(txtBirthday.getText().trim());
                model.setSdt(txtPhone.getText().trim());
                model.setGioiTinh(lblRender.getText().equals("Male"));
                model.setVaiTro(lblRole.getText().equals("Admin"));
                model.setMatKhau(txtPassword.getText());
                dao.update(model);
                list = dao.select();
                DefaultTableModel modelTable = (DefaultTableModel) tblNhanVien.getModel();
                modelTable.setRowCount(0);
                tblNhanVien.revalidate();
                initTableData();
                notification(fr, "Update success !", true);
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if(XDialog.delete(this, "Delete ?")){
            dao.delete(txtID.getText());
            list = dao.select();
            DefaultTableModel modelTable = (DefaultTableModel) tblNhanVien.getModel();
            modelTable.setRowCount(0);
            tblNhanVien.revalidate();
            initTableData();
            reform();
            notification(fr, "Delete success !", true);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.Button btnAdd;
    private button.Button btnDelete;
    private button.Button btnReform;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRender;
    private javax.swing.JLabel lblRole;
    private com.raven.swing.NavigationBar navigationBar1;
    private com.raven.swing.RoundPanel roundPanel1;
    private com.raven.swing.RoundPanel roundPanel2;
    private javaswingdev.SwitchButton swbtnGender;
    private javaswingdev.SwitchButton swbtnRole;
    private com.raven.swing.table.Table tblNhanVien;
    private textfield.TextField txtBirthday;
    private textfield.TextField txtEmail;
    private textfield.TextField txtFullname;
    private textfield.TextField txtID;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtName1;
    private javax.swing.JLabel txtName10;
    private javax.swing.JLabel txtName2;
    private javax.swing.JLabel txtName3;
    private javax.swing.JLabel txtName4;
    private javax.swing.JLabel txtName5;
    private javax.swing.JLabel txtName6;
    private javax.swing.JLabel txtName9;
    private textfield.TextField txtPassword;
    private textfield.TextField txtPhone;
    // End of variables declaration//GEN-END:variables

    private boolean ValidateInsert(int x) {
        if (txtID.getText().trim().equals("") || txtID.getText().trim().length() != 5) {
            txtID.requestFocus();
            notification(fr, "ID invalid !", false);
            return false;
        }
        if(x==0)
            for (int i = 0; i < list.size(); i++) {
                if (txtID.getText().trim().equals(list.get(i).getMaNV())) {
                    txtID.requestFocus();
                    notification(fr, "ID invalid !", false);
                    return false;
                }
            }
        if (txtName.getText().trim().equals("")) {
            txtName.requestFocus();
            notification(fr, "Fullname invalid !", false);
            return false;
        }
        if (txtEmail.getText().trim().equals("")) {
            txtEmail.requestFocus();
            notification(fr, "Email invalid !", false);
            return false;
        }
        String mauEmail = "\\w+@\\w+(\\.\\w+){1,2}";
        if (!(txtEmail.getText().trim().matches(mauEmail))) {
            txtEmail.requestFocus();
            notification(fr, "Email invalid !", false);
            return false;
        }
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(txtBirthday.getText());
            txtBirthday.setText(new SimpleDateFormat("yyyy-MM-dd").format(date));
        } catch (Exception e) {
            txtBirthday.requestFocus();
            notification(fr, "Birthday invalid !", false);
            return false;
        }
        if (txtPhone.getText().trim().equals("")) {
            txtPhone.requestFocus();
            notification(fr, "Phone invalid !", false);
            return false;
        }
        if (!txtPhone.getText().matches("\\d{9,10}")) {
            txtPhone.requestFocus();
            notification(fr, "Phone invalid !", false);
            return false;
        }
        return true;
    }

    public boolean ValidateUpdate() {
        if (ValidateInsert(1)) {
            if (txtPassword.getText().trim().equals("")) {
                txtPassword.requestFocus();
                notification(fr, "Password invalid !", false);
                return false;
            }
            else 
                return true;
        }
        return false;
    }
    
    public void reform(){
        txtID.setText("");
        txtFullname.setText("");
        txtEmail.setText("");
        txtBirthday.setText("");
        txtPhone.setText("");
        txtPassword.setText("");
        lblRender.setText("Female");
        lblRole.setText("Employee");
        swbtnGender.setSelected(false);
        swbtnRole.setSelected(false);
        txtID.setEditable(true);
        btnAdd.setText("ADD");
        btnDelete.setEnabled(false);
    }
    
    public void selectAll(){
        Date date = new Date();
        int day = date.getYear() + 1900;
        DefaultTableModel modelTable = (DefaultTableModel) tblNhanVien.getModel();
        modelTable.setRowCount(0);
        tblNhanVien.revalidate();
        for (int i = 0; i < list.size(); i++) {
            tblNhanVien.addRow(new ModelStaff(list.get(i).getMaNV(), list.get(i).getHoten(), list.get(i).getGioiTinh() ? "Male" : "Female", (day - Integer.parseInt(list.get(i).getNgaySinh().substring(0, 4))), list.get(i).getEmail(), list.get(i).getSdt(), list.get(i).getMatKhau(), list.get(i).getVaiTro() ? "Admin" : "Employee").toTableRow());
        }
    }
    
    public void selectHave(){
        List<NhanVien> haveList = dao.selectHave();
        Date date = new Date();
        int day = date.getYear() + 1900;
        DefaultTableModel modelTable = (DefaultTableModel) tblNhanVien.getModel();
        modelTable.setRowCount(0);
        tblNhanVien.revalidate();
        for (int i = 0; i < haveList.size(); i++) {
            tblNhanVien.addRow(new ModelStaff(haveList.get(i).getMaNV(), haveList.get(i).getHoten(), haveList.get(i).getGioiTinh() ? "Male" : "Female", (day - Integer.parseInt(haveList.get(i).getNgaySinh().substring(0, 4))), haveList.get(i).getEmail(), haveList.get(i).getSdt(), haveList.get(i).getMatKhau(), haveList.get(i).getVaiTro() ? "Admin" : "Employee").toTableRow());
        }
    }
    
    public void selectYet(){
        List<NhanVien> yetList = dao.selectYet();
        Date date = new Date();
        int day = date.getYear() + 1900;
        DefaultTableModel modelTable = (DefaultTableModel) tblNhanVien.getModel();
        modelTable.setRowCount(0);
        tblNhanVien.revalidate();
        for (int i = 0; i < yetList.size(); i++) {
            tblNhanVien.addRow(new ModelStaff(yetList.get(i).getMaNV(), yetList.get(i).getHoten(), yetList.get(i).getGioiTinh() ? "Male" : "Female", (day - Integer.parseInt(yetList.get(i).getNgaySinh().substring(0, 4))), yetList.get(i).getEmail(), yetList.get(i).getSdt(), yetList.get(i).getMatKhau(), yetList.get(i).getVaiTro() ? "Admin" : "Employee").toTableRow());
        }
    }
    
    public void notification(Frame frame, String text, boolean x){
        if(!x){
            Notification panel = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_CENTER, text);
            panel.showNotification();
        }
        else {
            Notification panel = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, text);
            panel.showNotification();
        }
        
    }
}
