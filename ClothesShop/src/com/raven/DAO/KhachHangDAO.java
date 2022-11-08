/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.KhachHang;
import com.raven.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duong
 */
public class KhachHangDAO extends ClothingStoreDAO<KhachHang, String>{
    
    @Override
    public void insert(KhachHang model) {
        String sql = "INSERT INTO KhachHang (MaKH, TenKH, SDT, Email) VALUES (?, ?, ?, ?)";
        XJdbc.executeUpdate(sql,
                model.getMaKH(),
                model.getTen(),
                model.getSdt(),
                model.getEmail());
    }

    @Override
    public void update(KhachHang model) {
        String sql = "UPDATE KhachHang SET TenKH = ?, SDT =?, Email =? WHERE MaKH =?";
        XJdbc.executeUpdate(sql,
                model.getTen(),
                model.getSdt(),
                model.getEmail(),
                model.getMaKH());
    }

    @Override
    public void delete(String MaKH) {
        String sql = "DELETE FROM KhachHang WHERE MaKH = ?";
        XJdbc.executeUpdate(sql, MaKH);
    }

    @Override
    public List<KhachHang> select() {
        String sql = "SELECT MaKH, TenKH, SDT, Email FROM KhachHang";
        return select(sql);
    }

    public List<KhachHang> selectByKeyword(String keyword) {
        String sql = "SELECT MaKH, TenKH, SDT, Email FROM KhachHang WHERE MaKH like ? OR TenKH like ?";
        return select(sql, "%" + keyword + "%", "%" + keyword + "%");
    }

    @Override
    public KhachHang selectById(String MaKH) {
        String sql = "SELECT MaKH, TenKH, SDT, Email FROM KhachHang WHERE MaKH = ?";
        List<KhachHang> list = select(sql, MaKH);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<KhachHang> select(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.executeQuery(sql, args);
                while (rs.next()) {
                    KhachHang model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private KhachHang readFromResultSet(ResultSet rs) throws SQLException {
        KhachHang model = new KhachHang();
        model.setMaKH(rs.getString("MaKH"));
        model.setTen(rs.getString("TenKH"));
        model.setSdt(rs.getString("SDT"));
        model.setEmail(rs.getString("Email"));
        return model;
    }
}
