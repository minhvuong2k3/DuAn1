/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.NhaCungCap;
import com.raven.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duong
 */
public class NhaCungCapDAO extends ClothingStoreDAO<NhaCungCap, String>{
    
    @Override
    public void insert(NhaCungCap model) {
        String sql = "INSERT INTO NhaCungCap (MaNCC, HoTen, SDT, Email, DiaChi) VALUES (?, ?, ?, ?, ?)";
        XJdbc.executeUpdate(sql,
                model.getMaNCC(),
                model.getTenNCC(),
                model.getSdt(),
                model.getEmail(),
                model.getDiachi());
    }

    @Override
    public void update(NhaCungCap model) {
        String sql = "UPDATE NhaCungCap SET HoTen = ?, SDT = ?, Email = ?, DiaChi = ? WHERE MaNCC = ?";
        XJdbc.executeUpdate(sql,
                model.getTenNCC(),
                model.getSdt(),
                model.getEmail(),
                model.getDiachi(),
                model.getMaNCC());
    }

    @Override
    public void delete(String MaNCC) {
        String sql = "DELETE FROM NhaCungCap WHERE MaNCC = ?";
        XJdbc.executeUpdate(sql, MaNCC);
    }

    @Override
    public List<NhaCungCap> select() {
        String sql = "SELECT * FROM NhaCungCap";
        return select(sql);
    }

    public List<NhaCungCap> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM NhaCungCap WHERE MaNCC like ? OR HoTen = ?";
        return select(sql, "%" + keyword + "%" + "%" + keyword + "%");
    }

    @Override
    public NhaCungCap selectById(String MaNCC) {
        String sql = "SELECT * FROM NhaCungCap WHERE MaNCC = ?";
        List<NhaCungCap> list = select(sql, MaNCC);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<NhaCungCap> select(String sql, Object... args) {
        List<NhaCungCap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.executeQuery(sql, args);
                while (rs.next()) {
                    NhaCungCap model = readFromResultSet(rs);
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

    private NhaCungCap readFromResultSet(ResultSet rs) throws SQLException {
        NhaCungCap model = new NhaCungCap();
        model.setMaNCC(rs.getString("MaNCC"));
        model.setTenNCC(rs.getString("HoTen"));
        model.setSdt(rs.getString("SDT"));
        model.setEmail(rs.getString("Email"));
        model.setDiachi(rs.getString("DiaChi"));
        return model;
    }
}
