package com.raven.main;

import com.raven.DAO.NhanVienDAO;
import com.raven.component.Message;
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
    private static Message ms = new Message();
    
    public static void main(String[] args) {
//        list = dao.select();
//        for (NhanVien nv : list) {
//            System.out.println(nv.getEmail());
//        }
//        Scanner sc = new Scanner(System.in);
//        email = sc.nextLine();
//        model = selectByEmail(email);
//        System.out.println(model.getEmail() + " " + model.getMatKhau());
//        update("123","NV003");        
    }
    
    public static void update(String matkhau, String manv) {
        String sql = "UPDATE Role SET MatKhau=? WHERE MaNV=?";
        XJdbc.executeUpdate(sql, matkhau, manv);
    }
    
    public static List<NhanVien> select() {
        String sql = "SELECT * FROM NhanVien";
        return select(sql);
    }
    
    public static NhanVien selectByEmail(String email) {
        String sql = "SELECT NV.MANV , TenNV , SDT, Email, MatKhau, VaiTro FROM NhanVien NV JOIN Role RL ON NV.MANV = RL.MANV WHERE Email = ?";
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
        model.setHoten(rs.getString("TenNV"));
        model.setSdt(rs.getString("SDT"));
        model.setEmail(rs.getString("Email"));
        return model;
    }
    
    private static NhanVien readFromResultSetFull(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setHoten(rs.getString("TenNV"));
        model.setSdt(rs.getString("SDT"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        model.setEmail(rs.getString("Email"));
        model.setMatKhau(rs.getString("MatKhau"));
        return model;
    }
}