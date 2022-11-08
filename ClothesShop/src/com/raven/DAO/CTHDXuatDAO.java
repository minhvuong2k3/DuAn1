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
public class CTHDXuatDAO extends ClothingStoreDAO<CTHDXuat, String>{
    
    @Override
    public void insert(CTHDXuat model) {
        String sql = "INSERT INTO CTHDXuat (SoPhieu, MaSP, SoLuong, Giam) VALUES (?, ?, ?, ?)";
        XJdbc.executeUpdate(sql,
                model.getSoPhieu(),
                model.getMaSP(),
                model.getSoLuong(),
                model.getGiamGia());
    }

    @Override
    public void update(CTHDXuat model) {
        String sql = "UPDATE CTHDXuat SET MaSP =?, SoLuong =?, GiamGia =? WHERE SoPhieu = ?";
        XJdbc.executeUpdate(sql,
                model.getMaSP(),
                model.getSoLuong(),
                model.getGiamGia(),
                model.getSoPhieu());
    }

    @Override
    public void delete(String SoPhieu) {
        String sql = "DELETE FROM CTHDXuat WHERE SoPhieu = ?";
        XJdbc.executeUpdate(sql, SoPhieu);
    }

    @Override
    public List<CTHDXuat> select() {
        String sql = "SELECT SoPhieu, MASP, SoLuong, GiamGia FROM CTHDXuat";
        return select(sql);
    }

    public List<CTHDXuat> selectByKeyword(String keyword) {
        String sql = "SELECT SoPhieu, MASP, SoLuong, GiamGia FROM CTHDXuat WHERE SoPhieu like ?";
        return select(sql, "%" + keyword + "%");
    }
    
    @Override
    public CTHDXuat selectById(String SoPhieu) {
        String sql = "SELECT * FROM CTHDXuat WHERE SoPhieu = ?";
        List<CTHDXuat> list = select(sql, SoPhieu);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
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
        model.setSoPhieu(rs.getString("SoPhieu"));
        model.setSoPhieu(rs.getString("MaSP"));
        model.setSoPhieu(rs.getString("SoLuong"));
        model.setSoPhieu(rs.getString("GiamGia"));
        return model;
    }
}
