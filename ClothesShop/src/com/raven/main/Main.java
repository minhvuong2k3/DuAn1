package com.raven.main;

import com.raven.event.EventColorChange;
import com.raven.form.DoanhThu2_Form;
//import com.raven.form.FormHomeStaff;
import com.raven.form.Form_Home;
import com.raven.form.Home_Form;
import com.raven.form.Home;
import com.raven.form.Order;
import com.raven.form.P_Form;
import com.raven.form.Setting_Form;
import com.raven.form.DoanhThuForm;
import com.raven.menu.EventMenu;
import com.raven.menu.Menu;
import com.raven.properties.SystemProperties;
import com.raven.theme.SystemTheme;
import com.raven.theme.ThemeColor;
import com.raven.theme.ThemeColorChange;
import com.raven.utils.Auth;
import com.raven.utils.XShare;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaswingdev.message.MessageDialog;
import javax.swing.Timer;

public class Main extends javax.swing.JFrame {

    private Setting_Form settingForm;
    private P_Form productForm;
    private Form_Home empForm;
    private Order OrderForm;
    private DoanhThuForm dashboardForm;
    private DoanhThu2_Form doanhthuForm;
    static int i = 0;

    public Main() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        init();
        setIconImage(XShare.APP_ICON);
//        if(!Auth.isManager())
//            menu.removeMenu("Employee", "3", 2);
    }

    private void init() {
        MessageDialog me = new MessageDialog(this);
        header.initMoving(this);
        header.initEvent(this);
//        if(Auth.isManager())
            menu.addEventMenu(new EventMenu() {
                @Override
                public void selectedMenu(int index) {
                    switch (index) {
                        case 0:
                            mainBody.displayForm(new Home_Form());
                            break;
                        case 1:
                            mainBody.displayForm(productForm, "Product");
                            break;
                        case 2:
                            mainBody.displayForm(empForm, "Employee");
                            break;
                        case 3:
                            mainBody.displayForm(OrderForm, "Order");
                            break;
                        case 4:
                            mainBody.displayForm(dashboardForm, "Order");
                            break;
                        case 5:
                            mainBody.displayForm(doanhthuForm, "Doanh Thu");
                            break;
                        case 6:
                            mainBody.displayForm(settingForm, "Setting");
                            break;
                        case 9:
                            me.showMessage("", "Do you want to logout?");
                            if (me.getMessageType() == MessageDialog.MessageType.OK) {
                                setVisible(false);
                                Auth.user = null;
                                Login lg = new Login();
                                lg.setVisible(true);
                            } else {
                                index = 0;
                                mainBody.displayForm(new Home_Form());
                                menu.setSelectedIndex(0);
                                menu.setSelectedLocation(151);
                                menu.clearSelected();
                                menu.show();
                            }
                            break;
                        default:
                            break;
                    }
                }
            });
//        else 
//            menu.addEventMenu(new EventMenu() {
//                @Override
//                public void selectedMenu(int index) {
//                    switch (index) {
//                        case 0:
//                            mainBody.displayForm(new Home_Form());
//                            break;
//                        case 1:
//                            mainBody.displayForm(productForm, "Product");
//                            break;
//                        case 2:
//                            mainBody.displayForm(OrderForm, "Order");
//                            break;
//                        case 3:
//                            mainBody.displayForm(dashboardForm, "Order");
//                            break;
//                        case 4:
//                            mainBody.displayForm(doanhthuForm, "Doanh Thu");
//                            break;
//                        case 5:
//                            mainBody.displayForm(settingForm, "Setting");
//                            break;
//                        case 8:
//                            me.showMessage("", "Do you want to logout?");
//                            if (me.getMessageType() == MessageDialog.MessageType.OK) {
//                                setVisible(false);
//                                Auth.user = null;
//                                Login lg = new Login();
//                                lg.setVisible(true);
//                            } else {
//                                index = 0;
//                                mainBody.displayForm(new Home_Form());
//                                menu.setSelectedIndex(0);
//                                menu.setSelectedLocation(151);
//                                menu.clearSelected();
//                                menu.show();
//                            }
//                            break;
//                        default:
//                            break;
//                    }
//                }
//            });
        ThemeColorChange.getInstance().addThemes(new ThemeColor(new Color(34, 34, 34), Color.WHITE) {
            @Override
            public void onColorChange(Color color) {
                panelBackground1.setBackground(color);
            }
        });
        ThemeColorChange.getInstance().addThemes(new ThemeColor(Color.WHITE, new Color(80, 80, 80)) {
            @Override
            public void onColorChange(Color color) {
                mainBody.changeColor(color);
            }
        });
        ThemeColorChange.getInstance().initBackground(panelBackground1);
        SystemProperties pro = new SystemProperties();
        pro.loadFromFile();
        if (!pro.isDarkMode()) {
            ThemeColorChange.getInstance().setMode(ThemeColorChange.Mode.LIGHT);
            panelBackground1.setBackground(Color.WHITE);
            mainBody.changeColor(new Color(80, 80, 80));
        }
        if (pro.getBackgroundImage() != null) {
            ThemeColorChange.getInstance().changeBackgroundImage(pro.getBackgroundImage());
        }
        SystemTheme.mainColor = pro.getColor();
        settingForm = new Setting_Form();
        settingForm.setEventColorChange(new EventColorChange() {
            @Override
            public void colorChange(Color color) {
                SystemTheme.mainColor = color;
                ThemeColorChange.getInstance().ruenEventColorChange(color);
                repaint();
                pro.save("theme_color", color.getRGB() + "");
            }
        });
        settingForm.setSelectedThemeColor(pro.getColor());
        settingForm.setDarkMode(pro.isDarkMode());
        settingForm.initBackgroundImage(pro.getBackgroundImage());
        mainBody.displayForm(new Home_Form());
        productForm = new P_Form();
        empForm = new Form_Home(this);
        OrderForm = new Order();
        dashboardForm = new DoanhThuForm();
        doanhthuForm = new DoanhThu2_Form();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground1 = new com.raven.swing.PanelBackground();
        header = new com.raven.component.Header();
        menu = new com.raven.menu.Menu();
        mainBody = new com.raven.component.MainBody();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBackground1.setBackground(new java.awt.Color(34, 34, 34));

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainBody, javax.swing.GroupLayout.DEFAULT_SIZE, 1126, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                    .addComponent(mainBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Thread() {
                    @Override
                    public void run() {
                        if (i == 0) {
                            new Loading().setVisible(true);
                            new Main().setVisible(true);
                        }
                        i++;
                    }
                }.start();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Header header;
    private com.raven.component.MainBody mainBody;
    private com.raven.menu.Menu menu;
    private com.raven.swing.PanelBackground panelBackground1;
    // End of variables declaration//GEN-END:variables
}
