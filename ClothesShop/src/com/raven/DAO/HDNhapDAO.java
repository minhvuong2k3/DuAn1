/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.HDNhap;
import com.raven.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duong
 */
public class HDNhapDAO extends ClothingStoreDAO<HDNhap, String> {

    @Override
    public void insert(HDNhap model) {
        String sql = "INSERT INTO HDNhap (NgayNhap, MaNCC, MaNV) VALUES (?, ?, ?)";
        XJdbc.executeUpdate(sql,
                model.getNgayNhap(),
                model.getMaNCC(),
                model.getMaNV());
    }

    @Override
    public void update(HDNhap model) {
        String sql = "UPDATE HDNhap SET NgayNhap = ?, MaNCC = ?, MaNV = ? WHERE SoPhieu = ?";
        XJdbc.executeUpdate(sql,
                model.getNgayNhap(),
                model.getMaNCC(),
                model.getMaNV(),
                model.getSoPhieu());
    }

    @Override
    public void delete(String SoPhieu) {
        String sql = "DELETE FROM HDNhap WHERE SoPhieu = ?";
        XJdbc.executeUpdate(sql, SoPhieu);
    }

    @Override
    public List<HDNhap> select() {
        String sql = "SELECT SoPhieu, NgayNhap, MaNCC, MaNV FROM HDNhap";
        return select(sql);
    }

    public List<HDNhap> selectByKeyword(int keyword) {
        String sql = "SELECT SoPhieu, NgayNhap, MaNCC, MaNV FROM HDNhap WHERE SoPhieu = ?";
        return select(sql, keyword);
    }

    @Override
    public HDNhap selectById(String SoPhieu) {
        String sql = "SELECT SoPhieu, NgayNhap, MaNCC, MaNV FROM HDNhap WHERE SoPhieu = ?";
        List<HDNhap> list = select(sql, SoPhieu);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public List<HDNhap> selectByDate(String from, String to) {
        String sql = "SELECT SoPhieu, NgayNhap, MaNCC, MaNV FROM HDNhap WHERE NgayNhap BETWEEN ? AND ?";
        List<HDNhap> list = select(sql, from, to);
        return list;
    }

    @Override
    protected List<HDNhap> select(String sql, Object... args) {
        List<HDNhap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.executeQuery(sql, args);
                while (rs.next()) {
                    HDNhap model = readFromResultSet(rs);
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

    private HDNhap readFromResultSet(ResultSet rs) throws SQLException {
        HDNhap model = new HDNhap();
        model.setSoPhieu(rs.getInt("SoPhieu"));
        model.setNgayNhap(rs.getString("NgayNhap"));
        model.setMaNCC(rs.getString("MaNCC"));
        model.setMaNV(rs.getString("MaNV"));
        return model;
    }
}
