/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.LoaiHang;
import com.raven.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duong
 */
public class LoaiHangDAO extends ClothingStoreDAO<LoaiHang, String>{
    @Override
    public void insert(LoaiHang model) {
        String sql = "INSERT INTO LoaiHang (MaLH, TenLH) VALUES (?, ?)";
        XJdbc.executeUpdate(sql,
                model.getMaLoai(),
                model.getTenLoai());
    }

    @Override
    public void update(LoaiHang model) {
        String sql = "UPDATE LoaiHang SET TenLH = ? WHERE MaLH = ?";
        XJdbc.executeUpdate(sql,
                model.getTenLoai(),
                model.getMaLoai());
    }

    @Override
    public void delete(String MaLH) {
        String sql = "DELETE FROM LoaiHang WHERE MaLH = ?";
        XJdbc.executeUpdate(sql, MaLH);
    }

    @Override
    public List<LoaiHang> select() {
        String sql = "SELECT MaLH, TenLH FROM LoaiHang";
        return select(sql);
    }

    public List<LoaiHang> selectByKeyword(String keyword) {
        String sql = "SELECT MaLH, TenLH FROM LoaiHang WHERE MaLH like ? OR TenLH like ?";
        return select(sql, "%" + keyword + "%", "%" + keyword + "%");
    }
    
    @Override
    public LoaiHang selectById(String MaLH) {
        String sql = "SELECT MaLH, TenLH FROM LoaiHang WHERE MaLH = ?";
        List<LoaiHang> list = select(sql, MaLH);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<LoaiHang> select(String sql, Object... args) {
        List<LoaiHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.executeQuery(sql, args);
                while (rs.next()) {
                    LoaiHang model = readFromResultSet(rs);
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

    private LoaiHang readFromResultSet(ResultSet rs) throws SQLException {
        LoaiHang model = new LoaiHang();
        model.setMaLoai(rs.getString("MaLH"));
        model.setTenLoai(rs.getString("TenLH"));
        return model;
    }
}
