
package com.raven.DAO;

import com.raven.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ThongKeDAO {
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
}
