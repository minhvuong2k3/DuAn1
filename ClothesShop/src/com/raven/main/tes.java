/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.main;

import com.raven.DAO.CTHDNhapDAO;
import com.raven.DAO.HDNhapDAO;
import com.raven.model.CTHDNhap;
import com.raven.model.HDNhap;
import com.raven.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AD MIN
 */
public class tes {

    private static CTHDNhapDAO daoCT = new CTHDNhapDAO();
    private static HDNhapDAO dao = new HDNhapDAO();
    private static List<HDNhap> list = new ArrayList<HDNhap>();

    public static void main(String[] args) {
        int index = 1;
        list = dao.select();
        selectByKeyword(1);
    }

    public static List<CTHDNhap> selectByKeyword(int keyword) {
        String sql = "SELECT SoPhieu, MaSP, SoLuong, GiaNhap FROM CTHDNhap WHERE SoPhieu = ?";
        return select(sql, keyword);
    }

    protected static List<CTHDNhap> select(String sql, Object... args) {
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
//            throw new RuntimeException(ex);
        }
        return list;
    }

    private static CTHDNhap readFromResultSet(ResultSet rs) throws SQLException {
        CTHDNhap model = new CTHDNhap();
        model.setSoPhieu(rs.getInt("SoPhieu"));
        model.setMaSP(rs.getString("MaSP"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setGiaNhap(rs.getInt("GiaNhap"));
        return model;
    }

}
