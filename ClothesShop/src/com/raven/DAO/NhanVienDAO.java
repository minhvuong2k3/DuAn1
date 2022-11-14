package com.raven.DAO;

import com.raven.model.NhanVien;
import com.raven.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends ClothingStoreDAO<NhanVien, String> {

    @Override
    public void insert(NhanVien model) {
        String sql = "INSERT INTO NhanVien (MaNV, TenNV, GioiTinh, NgaySinh, SDT, Email) VALUES (?, ?, ?, ?, ?, ?)";
        XJdbc.executeUpdate(sql,
                model.getMaNV(),
                model.getHoten(),
                model.getGioiTinh(),
                model.getNgaySinh(),
                model.getSdt(),
                model.getEmail());
    }

    @Override
    public void update(NhanVien model) {
        String sql = "UPDATE NhanVien SET TenNV=?, GioiTinh=?, NgaySinh=?, SDT=?, Email=? WHERE MaNV=?";
        XJdbc.executeUpdate(sql,
                model.getHoten(),
                model.getGioiTinh(),
                model.getNgaySinh(),
                model.getSdt(),
                model.getEmail(),
                model.getMaNV());
    }

    @Override
    public void delete(String MaNV) {
        String sql = "DELETE FROM NhanVien WHERE MaNV = ?";
        XJdbc.executeUpdate(sql, MaNV);
    }

    @Override
    public List<NhanVien> select() {
        String sql = "SELECT NV.MANV , TenNV , GioiTinh, NgaySinh, SDT, Email, MatKhau, VaiTro FROM NhanVien NV "
                + "LEFT JOIN Role RL ON NV.MANV = RL.MANV";
        return select(sql);
    }
    
    public NhanVien selectByEmail(String email) {
        String sql = "SELECT NV.MANV , TenNV , GioiTinh, NgaySinh, SDT, Email, MatKhau, VaiTro FROM NhanVien NV "
                + "LEFT JOIN Role RL ON NV.MANV = RL.MANV WHERE Email = ?";
        List<NhanVien> list = select(sql, email);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<NhanVien> selectByKeyword(String keyword) {
        String sql = "SELECT NV.MANV , TenNV , GioiTinh, NgaySinh, SDT, Email, MatKhau, VaiTro FROM NhanVien NV "
                + "LEFT JOIN Role RL ON NV.MANV = RL.MANV WHERE MaNV like ? OR  TenNV like ?";
        return select(sql, "%" + keyword + "%", "%" + keyword + "%");
    }

    @Override
    public NhanVien selectById(String manv) {
        String sql = "SELECT NV.MANV , TenNV , GioiTinh, NgaySinh, SDT, Email, MatKhau, VaiTro FROM NhanVien NV "
                + "LEFTJOIN Role RL ON NV.MANV = RL.MANV WHERE MaNV = ?";
        List<NhanVien> list = select(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<NhanVien> select(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setHoten(rs.getString("TenNV"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setNgaySinh(String.valueOf(rs.getDate("NgaySinh")));
        model.setSdt(rs.getString("SDT"));
        model.setEmail(rs.getString("Email"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        model.setMatKhau(rs.getString("MatKhau"));
        return model;
    }
}
