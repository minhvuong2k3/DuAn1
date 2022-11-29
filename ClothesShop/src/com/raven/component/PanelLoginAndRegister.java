package com.raven.component;

import com.raven.DAO.NhanVienDAO;
import com.raven.main.Login;
import com.raven.main.Main;
import com.raven.main.testUser;
import com.raven.model.NhanVien;
import button.Button;
import com.raven.swing.MyPasswordField;
import com.raven.swing.MyTextField;
import com.raven.utils.Auth;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.raven.component.Message;
import com.raven.main.Loading;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javaswingdev.Notification;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import net.miginfocom.swing.MigLayout;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    private List<NhanVien> list = new ArrayList<>();
    private NhanVienDAO dao = new NhanVienDAO();
    private NhanVien model;
    private static int codeSend;
    MimeMultipart mimeMultipart = new MimeMultipart();
    MimeBodyPart mimeBodyPart = new MimeBodyPart();
    Message ms = new Message();
    static int i = 0;

    public PanelLoginAndRegister(Frame frame) {
        initComponents();
        initRegister(frame);
        initLogin(frame);
        login.setVisible(false);
        register.setVisible(true);
        fillDataToList();
    }
//rgb[219, 163, 154]

    private void initRegister(Frame frame) {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Forgot Password");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(125, 110, 131));
        register.add(label);
       
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/mail.png")));
        txtEmail.setHint("Email");
        register.add(txtEmail, "w 60%");

        MyTextField txtOTP = new MyTextField();
        txtOTP.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/mail.png")));
        txtOTP.setHint("OTP");

        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/pass.png")));
        txtPass.setHint("Password");

        MyPasswordField txtCheckPass = new MyPasswordField();
        txtCheckPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/pass.png")));
        txtCheckPass.setHint("Check Password");

        Button cmd = new Button();
        cmd.setBackground(new Color(125, 110, 131));
        cmd.setForeground(new Color(254, 252, 243));
        button.Button btn = new button.Button();
        cmd.setText("Send verifycode to Email");
        register.add(cmd, "w 40%, h 40");

        Button cmdCheckOTP = new Button();
        cmdCheckOTP.setBackground(new Color(125, 110, 131));
        cmdCheckOTP.setForeground(new Color(254, 252, 243));
        cmdCheckOTP.setText("Check OTP ");

        Button cmdCheckPass = new Button();
        cmdCheckPass.setBackground(new Color(125, 110, 131));
        cmdCheckPass.setForeground(new Color(254, 252, 243));
        cmdCheckPass.setText("Submit");

        cmd.addActionListener((ActionEvent e) -> {
            if (checkEmail(txtEmail.getText())) {
                model = dao.selectByEmail(txtEmail.getText());
                if (sendCodeToEmail(txtEmail.getText())) {
                    Notification panel = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Verifycode was send ");
                    panel.showNotification();
                    register.remove(txtEmail);
                    register.remove(cmd);
                    register.add(txtOTP, "w 60%");
                    register.add(cmdCheckOTP, "w 40%, h 40");
                } else {
                    Notification panel = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Verifycode didn't send ");
                    panel.showNotification();
                }
            } else {
                Notification panel = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Email not have account");
                panel.showNotification();
            }
        });
        cmdCheckOTP.addActionListener((ActionEvent e) -> {
            if (checkOTP(txtOTP.getText())) {
                Notification panel = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "OTP true ");
                panel.showNotification();
                register.remove(cmdCheckOTP);
                register.remove(txtOTP);
                register.add(txtPass, "w 60%");
                register.add(txtCheckPass, "w 60%");
                register.add(cmdCheckPass, "w 40%, h 40");
            } else {
                Notification panel = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "OTP false ");
                panel.showNotification();
            }
        });
        cmdCheckPass.addActionListener((ActionEvent e) -> {
            if (checkPass(txtPass.getText(), txtCheckPass.getText())) {
                Notification panel = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Password was saved ");
                panel.showNotification();
                testUser.update(txtPass.getText(), model.getMaNV());
                frame.setVisible(false);
                Login lg = new Login();
                lg.setVisible(true);
            } else {
                Notification panel = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Password wasn't save ");
                panel.showNotification();
            }
        });

    }

    private boolean checkPass(String pass, String passCheck) {
        return pass.equals(passCheck);
    }

    private void initLogin(Frame frame) {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(125, 110, 131));
        label.setBackground(new Color(254, 252, 243));
        login.add(label);
//rgb(125, 110, 131)
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/mail.png")));
        txtEmail.setHint("Email");
        login.add(txtEmail, "w 60%");

        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/pass.png")));
        txtPass.setHint("Password");
        login.add(txtPass, "w 60%");

//        JButton cmdForget = new JButton("Forgot your password ?");
//        cmdForget.setForeground(new Color(100, 100, 100));
//        cmdForget.setFont(new Font("sansserif", 1, 12));
//        cmdForget.setContentAreaFilled(false);
//        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        login.add(cmdForget);
        Button cmd = new Button();
        cmd.setBackground(new Color(125, 110, 131));
        cmd.setForeground(new Color(254, 252, 243));
        cmd.setText("SIGN IN");
        login.add(cmd, "w 40%, h 40");
        txtEmail.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login(txtPass.getText(), txtEmail.getText(), frame);
                }
            }
        });
        txtPass.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login(txtPass.getText(), txtEmail.getText(), frame);
                }
            }
        });
        cmd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login(txtPass.getText(), txtEmail.getText(), frame);
                }
            }
        });
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login(txtPass.getText(), txtEmail.getText(), frame);
            }
        });
    }
//vyltps22007@fpt.edu.vn

    public void fillDataToList() {
        list = testUser.select();
    }

    public void login(String pass, String email, Frame frame) {
        if (!checkExistEmail(email)) {
            Notification panel = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Email not have account");
            panel.showNotification();
            return;
        }
        model = testUser.selectByEmail(email);
        if (pass.equals(model.getMatKhau())) {
            Notification panel = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Login succesfull");
            panel.showNotification();
            Auth.user = model;
            frame.setVisible(false);
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
        } else {
            Notification panel = new Notification(frame, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Password not succesfull");
            panel.showNotification();
        }
    }

    public boolean checkExistEmail(String email) {
        int count = 0;
        for (NhanVien nhanVien : list) {
            if (nhanVien.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkOTP(String code) {
        return String.valueOf(codeSend).equals(code);
    }

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }

    public int RandomCode() {
        codeSend = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
        return codeSend;
    }

    public boolean checkEmail(String email) {
        NhanVien alist = dao.selectByEmail(email);
        return alist != null ? true : false;
    }

    public boolean sendCodeToEmail(String email) {
        try {
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", 587);
            Session s = Session.getDefaultInstance(p, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("vominhvuong15112003@gmail.com", "btvjcztsvsusxevl");
                }
            });
            javax.mail.Message msg = new MimeMessage(s);
            msg.setFrom(new InternetAddress("vominhvuong15112003@gmail.com"));
            msg.setRecipients(javax.mail.Message.RecipientType.CC, InternetAddress.parse(email));
            msg.setSubject("Code");
            String content = "Code to change password: " + RandomCode();
            mimeBodyPart.setContent(content, "text/html; charset=utf-8");
            mimeMultipart.addBodyPart(mimeBodyPart);
            msg.setContent(mimeMultipart);
            Transport.send(msg);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
