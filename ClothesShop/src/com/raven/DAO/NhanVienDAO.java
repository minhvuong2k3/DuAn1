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
        String sql = "INSERT INTO ThongTinNhanVien (IDNhanVien, HoTen, SDT, Email) VALUES (?, ?, ?, ?)";
        XJdbc.executeUpdate(sql,
                model.getMaNV(),
                model.getHoten(),
                model.getSdt(),
                model.getEmail());
    }

    @Override
    public void update(NhanVien model) {
        String sql = "UPDATE ThongTinNhanVien SET HoTen=?, SDT=?, Email=? WHERE IDNhanVien=?";
        XJdbc.executeUpdate(sql,
                model.getHoten(),
                model.getSdt(),
                model.getEmail(),
                model.getMaNV());
    }

    @Override
    public void delete(String MaNV) {
        String sql = "DELETE FROM ThongTinNhanVien WHERE IDNhanVien=?";
        XJdbc.executeUpdate(sql, MaNV);
    }

    @Override
    public List<NhanVien> select() {
        String sql = "SELECT * FROM ThongTinNhanVien";
        return select(sql);
    }

    public List<NhanVien> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM ThongTinNhanVien WHERE IDNhanVien like ?";
        return select(sql, "%" + keyword + "%");
    }

    @Override
    public NhanVien selectById(String manv) {
        String sql = "SELECT * FROM ThongTinNhanVien WHERE IDNhanVien=?";
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
            throw new RuntimeException(ex);
        }
        return list;
    }

    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("IDNhanVien"));
        model.setHoten(rs.getString("HoTen"));
        model.setSdt(rs.getString("SDT"));
        model.setEmail(rs.getString("Email"));
        return model;
    }

}
