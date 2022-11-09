/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.CTHDXuat;
import com.raven.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duong
 */
public class CTHDXuatDAO{
    
    public void insert(CTHDXuat model) {
        String sql = "INSERT INTO CTHDXuat (SoPhieu, MaSP, SoLuong, GiamGia) VALUES (?, ?, ?, ?)";
        XJdbc.executeUpdate(sql,
                model.getSoPhieu(),
                model.getMaSP(),
                model.getSoLuong(),
                model.getGiamGia());
    }

    public void update(CTHDXuat model) {
        String sql = "UPDATE CTHDXuat SET SoLuong =?, GiamGia =? WHERE SoPhieu = ? AND MaSP =?";
        XJdbc.executeUpdate(sql,
                model.getSoLuong(),
                model.getGiamGia(),
                model.getSoPhieu(),
                model.getMaSP());
    }

    public void delete(String SoPhieu, String MaSP) {
        String sql = "DELETE FROM CTHDXuat WHERE SoPhieu = ? AND MaSP =?";
        XJdbc.executeUpdate(sql, SoPhieu, MaSP);
    }

    public List<CTHDXuat> select() {
        String sql = "SELECT SoPhieu, MASP, SoLuong, GiamGia FROM CTHDXuat";
        return select(sql);
    }

    public List<CTHDXuat> selectByKeyword(String keyword) {
        String sql = "SELECT SoPhieu, MASP, SoLuong, GiamGia FROM CTHDXuat WHERE SoPhieu like ?";
        return select(sql, "%" + keyword + "%");
    }
    
    public CTHDXuat selectById(String SoPhieu) {
        String sql = "SELECT * FROM CTHDXuat WHERE SoPhieu = ?";
        List<CTHDXuat> list = select(sql, SoPhieu);
        return list.size() > 0 ? list.get(0) : null;
    }

    protected List<CTHDXuat> select(String sql, Object... args) {
        List<CTHDXuat> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.executeQuery(sql, args);
                while (rs.next()) {
                    CTHDXuat model = readFromResultSet(rs);
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

    private CTHDXuat readFromResultSet(ResultSet rs) throws SQLException {
        CTHDXuat model = new CTHDXuat();
        model.setSoPhieu(rs.getInt("SoPhieu"));
        model.setMaSP(rs.getString("MaSP"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setGiamGia(rs.getInt("GiamGia"));
        return model;
    }
}
