package com.raven.DAO;

import com.raven.connection.DatabaseConnection;
import com.raven.model.NhanVien;
import com.raven.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends ClothingStoreDAO<NhanVien, String> {

    @Override
    public void insert(NhanVien model) {
        String sql = "INSERT INTO NhanVien (MaNV, TenNV, SDT, Email) VALUES (?, ?, ?, ?)";
        XJdbc.executeUpdate(sql,
                model.getMaNV(),
                model.getHoten(),
                model.getSdt(),
                model.getEmail());
    }

    @Override
    public void update(NhanVien model) {
        String sql = "UPDATE NhanVien SET TenNV=?, SDT=?, Email=? WHERE MaNV=?";
        XJdbc.executeUpdate(sql,
                model.getHoten(),
                model.getSdt(),
                model.getEmail(),
                model.getMaNV());
    }

    @Override
    public void delete(String MaNV) {
        String sql = "DELETE FROM NhanVien WHERE MaNV=?";
        XJdbc.executeUpdate(sql, MaNV);
    }

    @Override
    public List<NhanVien> select() {
        String sql = "SELECT * FROM NhanVien";
        return select(sql);
    }

    public NhanVien selectByEmail(String email) {
        String sql = "SELECT NV.MANV , TenNV , SDT, Email, MatKhau, VaiTro FROM NhanVien NV JOIN Role RL ON NV.MANV = RL.MANV WHERE Email = ?";
        List<NhanVien> list = select(sql, email);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<NhanVien> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV like ?";
        return select(sql, "%" + keyword + "%");
    }

    @Override
    public NhanVien selectById(String manv) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV=?";
        List<NhanVien> list = select(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<NhanVien> select(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DatabaseConnection.exQu(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
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

    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setHoten(rs.getString("TenNV"));
        model.setSdt(rs.getString("SDT"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
//        model.setEmail(rs.getString("Email"));
//        model.setMatKhau(rs.getString("MatKhau"));
        return model;
    }

//    protected List<NhanVien> selectFull(String sql, Object... args) {
//        List<NhanVien> list = new ArrayList<>();
//        try {
//            ResultSet rs = null;
//            try {
//                rs = XJdbc.executeQuery(sql, args);
//                while (rs.next()) {
//                    NhanVien model = readFromResultSetFull(rs);
//                    list.add(model);
//                }
//            } finally {
//                rs.getStatement().getConnection().close();
//            }
//        } catch (SQLException ex) {
////            throw new RuntimeException(ex);
//        }
//        return list;
//    }
//
//    private static NhanVien readFromResultSetFull(ResultSet rs) throws SQLException {
//        NhanVien model = new NhanVien();
//        model.setMaNV(rs.getString("MaNV"));
//        model.setHoten(rs.getString("HoTen"));
//        model.setSdt(rs.getString("SDT"));
//        model.setVaiTro(rs.getBoolean("VaiTro"));
//        model.setEmail(rs.getString("Email"));
//        model.setMatKhau(rs.getString("MatKhau"));
//        return model;
//    }
}
