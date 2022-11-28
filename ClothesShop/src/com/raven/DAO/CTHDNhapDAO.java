/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.CTHDNhap;
import com.raven.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duong
 */
public class CTHDNhapDAO {

    public void insert(CTHDNhap model) {
        String sql = "INSERT INTO CTHDNhap (SoPhieu, MaSP, SoLuong, GiaNhap) VALUES (?, ?, ?, ?)";
        XJdbc.executeUpdate(sql,
                model.getSoPhieu(),
                model.getMaSP(),
                model.getSoLuong(),
                model.getGiaNhap());
    }

    public void update(CTHDNhap model) {
        String sql = "UPDATE CTHDNhap SET SoLuong =?, GiaNhap =? WHERE SoPhieu = ? AND MaSP = ?";
        XJdbc.executeUpdate(sql,
                model.getSoLuong(),
                model.getGiaNhap(),
                model.getSoPhieu(),
                model.getMaSP());
    }

    public void delete(String SoPhieu, String MaSP) {
        String sql = "DELETE FROM CTHDNhap WHERE SoPhieu = ? AND MaSP = ?";
        XJdbc.executeUpdate(sql, SoPhieu, MaSP);
    }

    public List<CTHDNhap> select() {
        String sql = "SELECT SoPhieu, MaSP, SoLuong, GiaNhap FROM CTHDNhap";
        return select(sql);
    }

    public List<CTHDNhap> selectByKeyword(String keyword) {
        String sql = "SELECT SoPhieu, MaSP, SoLuong, GiaNhap FROM CTHDNhap WHERE SoPhieu = ";
        return select(sql, keyword);
    }

    public CTHDNhap selectById(String SoPhieu) {
        String sql = "SELECT MaSP, SoLuong, GiaNhap FROM CTHDNhap WHERE SoPhieu = ?";
        List<CTHDNhap> list = select(sql, SoPhieu);
        return list.size() > 0 ? list.get(0) : null;
    }

    protected List<CTHDNhap> select(String sql, Object... args) {
        List<CTHDNhap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.executeQuery(sql, args);
                while (rs.next()) {
                    CTHDNhap model = readFromResultSet(rs);
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

    private CTHDNhap readFromResultSet(ResultSet rs) throws SQLException {
        CTHDNhap model = new CTHDNhap();
        model.setSoPhieu(rs.getInt("SoPhieu"));
        model.setMaSP(rs.getString("MaSP"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setGiaNhap(rs.getInt("GiaNhap"));
        return model;
    }
}
