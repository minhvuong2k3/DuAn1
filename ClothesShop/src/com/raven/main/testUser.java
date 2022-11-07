/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.main;

import com.raven.DAO.NhanVienDAO;
import com.raven.model.NhanVien;
import com.raven.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author AD MIN
 */
public class testUser {

    private static List<NhanVien> list = new ArrayList<>();
    private static NhanVienDAO dao = new NhanVienDAO();
    private static NhanVien model;
    private static String email;

    public static void main(String[] args) {
//        list = dao.select();
//        for (NhanVien nv : list) {
//            System.out.println(nv.getEmail());
//        }
//        Scanner sc = new Scanner(System.in);
//        email = sc.nextLine();
//        model = selectByEmail(email);
//        System.out.println(model.getEmail() + " " + model.getMatKhau());
        int i = new Random().nextInt(900000) + 100000;
        System.out.println(i);
    }

    public static List<NhanVien> select() {
        String sql = "SELECT * FROM NhanVien";
        return select(sql);
    }

    public static NhanVien selectByEmail(String email) {
        String sql = "SELECT NV.MANV , HoTen , SDT, Email, MatKhau, VaiTro FROM NhanVien NV JOIN Role RL ON NV.MANV = RL.MANV WHERE Email = ?";
        List<NhanVien> list = selectFull(sql, email);
        return list.size() > 0 ? list.get(0) : null;
    }

    protected static List<NhanVien> selectFull(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.executeQuery(sql, args);
                while (rs.next()) {
                    model = readFromResultSetFull(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
        }
        return list;
    }

    protected static List<NhanVien> select(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.executeQuery(sql, args);
                while (rs.next()) {
                    model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
        }
        return list;
    }

    private static NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setHoten(rs.getString("HoTen"));
        model.setSdt(rs.getString("SDT"));
        model.setEmail(rs.getString("Email"));
        return model;
    }

    private static NhanVien readFromResultSetFull(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setHoten(rs.getString("HoTen"));
        model.setSdt(rs.getString("SDT"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        model.setEmail(rs.getString("Email"));
        model.setMatKhau(rs.getString("MatKhau"));
        return model;
    }
}
