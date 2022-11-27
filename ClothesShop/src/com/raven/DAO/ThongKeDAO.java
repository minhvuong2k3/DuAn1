
package com.raven.DAO;

import com.raven.utils.XJdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ThongKeDAO {
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost:1433;database=ClothesShop;encrypt=true;trustServerCertificate=true";
    private static String username = "sa";
    private static String password = "123";
    private ArrayList<Object[]> getListOfArray(String sql, String[] cols, Object...args){
        try {
            ArrayList<Object[]> list = new ArrayList<>();
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while(rs.next()){
                Object[] vals = new Object[cols.length];
                for(int i=0;i<cols.length;i++){
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList<Object[]> getSanPhamTop3(int nam, int thang){
        String sql = "{CALL sp_SanPhamTong(?, ?)}";
        String[] cols = {"MaSP", "Tien"};
        return this.getListOfArray(sql, cols, nam, thang);
    }
    
    public ArrayList<Object[]> getSanPhamThang(int nam, int thang, String maSP){
        String sql = "{CALL sp_SanPhamThang(?, ?, ?)}";
        String[] cols = {"MaSP", "Tien"};
        return this.getListOfArray(sql, cols, nam, thang, maSP);
    }
    
    public ArrayList<Object[]> getKhachHangTop3(){
        String sql = "{CALL sp_KhachHangTop3()}";
        String[] cols = {"TenKH", "SDT", "luot mua"};
        return this.getListOfArray(sql, cols);
    }
    
    public List<Object[]> getSPSellMonth(Object...args){
        String sql = "select MaSP, SoLuong from HDXuat inner join CTHDXuat on HDXuat.SoPhieu = CTHDXuat.SoPhieu where month(NgayXuat) = ? and year(NgayXuat) = ?";
        ArrayList<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while(rs.next()){
                Object[] vals = new Object[]{
                    rs.getString("MaSP"),
                    rs.getInt("soLuong")
                };
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
        }
        return list;
    }
    
    public int getIncomeMonth(Object...args){
        String sql = "select SUM(thanhTien) as 'sumPrice' from HDXuat where MONTH(NgayXuat) = ? and year(NgayXuat) = ? group by MONTH(NgayXuat)";
        int a = 0;
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while(rs.next()){
                a = rs.getInt("sumPrice");
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
        }
        return a;
    }
    public int getSpendingMonth(Object...args){
        String sql = "select sum(GiaNhap) as 'sumSpending' from HDNhap inner join CTHDNhap on HDNhap.SoPhieu = CTHDNhap.SoPhieu where MONTH(NgayNhap) = ? and year(NgayNhap) = ? group by  MONTH(NgayNhap)";
        int a = 0;
        try {
            ResultSet rs = XJdbc.executeQuery(sql, args);
            while(rs.next()){
                a = rs.getInt("sumSpending");
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
        }
        return a;
    }
    
    public int getLoiNhuan(String maSP, int soLuong) throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(dburl, username, password);
        CallableStatement cs = connection.prepareCall("{? = CALL sp_LoiNhuanSP(?,?)}");  
        cs.registerOutParameter(1, java.sql.Types.INTEGER);
        cs.setString(2, maSP);
        cs.setInt(3, soLuong);
        cs.execute();
        return cs.getInt(1);
    }
}
