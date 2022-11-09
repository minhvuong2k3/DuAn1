/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.Role;
import com.raven.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duong
 */
public class RoleDAO extends ClothingStoreDAO<Role, String>{
    
    @Override
    public void insert(Role model) {
        String sql = "INSERT INTO Role (MaNV, VaiTro, MatKhau) VALUES (?, ?, ?)";
        XJdbc.executeUpdate(sql,
                model.getMaNV(),
                model.getVaiTro(),
                model.getMatKhau());
    }

    @Override
    public void update(Role model) {
        String sql = "UPDATE Role SET VaiTro =?, MatKhau =? WHERE MaNV = ?";
        XJdbc.executeUpdate(sql,
                model.getVaiTro(),
                model.getMatKhau(),
                model.getMaNV());
    }

    @Override
    public void delete(String MaNV) {
        String sql = "DELETE FROM Role WHERE MaNV = ?";
        XJdbc.executeUpdate(sql, MaNV);
    }

    @Override
    public List<Role> select() {
        String sql = "SELECT MaNV, VaiTro, MatKhau FROM Role";
        return select(sql);
    }

    public List<Role> selectByKeyword(String keyword) {
        String sql = "SELECT MaNV, VaiTro, MatKhau FROM Role WHERE MaNV like ?";
        return select(sql, "%" + keyword + "%");
    }

    @Override
    public Role selectById(String MaNV) {
        String sql = "SELECT MaNV, VaiTro, MatKhau FROM Role WHERE MaNV = ?";
        List<Role> list = select(sql, MaNV);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<Role> select(String sql, Object... args) {
        List<Role> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.executeQuery(sql, args);
                while (rs.next()) {
                    Role model = readFromResultSet(rs);
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

    private Role readFromResultSet(ResultSet rs) throws SQLException {
        Role model = new Role();
        model.setMaNV(rs.getString("MaNV"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        model.setMatKhau(rs.getString("MatKhau"));
        return model;
    }
}
