/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.HDXuat;
import com.raven.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duong
 */
public class HDXuatDAO extends ClothingStoreDAO<HDXuat, String>{
        
    @Override
    public void insert(HDXuat model) {
        String sql = "INSERT INTO HDXuat (MaNV, MaKH, ThanhTien, NgayXuat) VALUES (?, ?, ?, ?)";
        XJdbc.executeUpdate(sql,
                model.getMaNV(),
                model.getMaKH(),
                model.getThanhTien(),
                model.getNgayXuat());
    }

    @Override
    public void update(HDXuat model) {
        String sql = "UPDATE HDXuat SET MaNV = ?, MaKH =?, ThanhTien = ?, NgayXuat = ? WHERE SoPhieu = ?";
        XJdbc.executeUpdate(sql,
                model.getMaNV(),
                model.getMaKH(),
                model.getThanhTien(),
                model.getNgayXuat(),
                model.getSoPhieu());
    }

    @Override
    public void delete(String SoPhieu) {
        String sql = "DELETE FROM HDXuat WHERE SoPhieu = ?";
        XJdbc.executeUpdate(sql, SoPhieu);
    }

    @Override
    public List<HDXuat> select() {
        String sql = "SELECT * FROM HDXuat";
        return select(sql);
    }

    public List<HDXuat> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM HDXuat WHERE SoPhieu like ? OR MaNV like = ?";
        return select(sql, "%" + keyword + "%", "%" + keyword + "%");
    }
    
    @Override
    public HDXuat selectById(String SoPhieu) {
        String sql = "SELECT * FROM HDXuat WHERE SoPhieu = ?";
        List<HDXuat> list = select(sql, SoPhieu);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<HDXuat> select(String sql, Object... args) {
        List<HDXuat> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.executeQuery(sql, args);
                while (rs.next()) {
                    HDXuat model = readFromResultSet(rs);
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

    private HDXuat readFromResultSet(ResultSet rs) throws SQLException {
        HDXuat model = new HDXuat();
        model.setSoPhieu(rs.getString("SoPhieu"));
        model.setMaNV(rs.getString("MaKH"));
        model.setMaKH(rs.getString("MaNV"));
        model.setThanhTien(rs.getInt("ThanhTien"));
        model.setNgayXuat(rs.getString("NgayXuat"));
        return model;
    }
}
