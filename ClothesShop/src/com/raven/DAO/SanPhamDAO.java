/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.SanPham;
import com.raven.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duong
 */
public class SanPhamDAO extends ClothingStoreDAO<SanPham, String>{
    
    @Override
    public void insert(SanPham model) {
        String sql = "INSERT INTO SanPham (MaSP, MaLH, TenSP, Anh, GiaBan, GiamGia, MaNCC) VALUES (?, ?, ?, ?, ?, ?, ?)";
        XJdbc.executeUpdate(sql,
                model.getMaSP(),
                model.getMaLH(),
                model.getTenSP(),
                model.getAnh(),
                model.getGiaBan(),
                model.getGiamgia(),
                model.getMaNCC());
    }

    @Override
    public void update(SanPham model) {
        String sql = "UPDATE SanPham SET MaLH = ?, TenSP= ?, Anh = ?, GiaBan = ?, GiamGia = ?, MaNCC = ? WHERE MaSP = ?";
        XJdbc.executeUpdate(sql,
                model.getMaLH(),
                model.getTenSP(),
                model.getAnh(),
                model.getGiaBan(),
                model.getGiamgia(),
                model.getMaNCC(),
                model.getMaSP());
    }

    @Override
    public void delete(String MaSP) {
        String sql = "DELETE FROM SanPham WHERE MaSP = ?";
        XJdbc.executeUpdate(sql, MaSP);
    }

    @Override
    public List<SanPham> select() {
        String sql = "SELECT * FROM SanPham";
        return select(sql);
    }

    public List<SanPham> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM SanPham WHERE MaSP like ? OR TenSP = ?";
        return select(sql, "%" + keyword + "%", "%" + keyword + "%");
    }
    
    @Override
    public SanPham selectById(String MaNCC) {
        String sql = "SELECT * FROM SanPham WHERE MaSP = ?";
        List<SanPham> list = select(sql, MaNCC);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<SanPham> select(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.executeQuery(sql, args);
                while (rs.next()) {
                    SanPham model = readFromResultSet(rs);
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

    private SanPham readFromResultSet(ResultSet rs) throws SQLException {
        SanPham model = new SanPham();
        model.setMaSP(rs.getString("MaSP"));
        model.setMaLH(rs.getString("MaLH"));
        model.setTenSP(rs.getString("TenSP"));
        model.setAnh(rs.getString("Anh"));
        model.setGiaBan(rs.getString("GiaBan"));
        model.setGiamgia(rs.getInt("GiamGia"));
        model.setMaNCC(rs.getString("NhaNCC"));
        return model;
    }
}
