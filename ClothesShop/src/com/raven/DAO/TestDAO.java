/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.CTHDNhap;
import com.raven.model.CTHDXuat;
import com.raven.model.NhaCungCap;
import com.raven.model.NhanVien;
import com.raven.model.SanPham;
import java.util.List;

/**
 *
 * @author duong 
 */
public class TestDAO {
    public static void main(String[] args) {
        CTHDNhapDAO dao = new CTHDNhapDAO();
        List<CTHDNhap> list = dao.select();
        for(CTHDNhap x: list) {
            System.out.println(x.getSoPhieu()+", "+x.getMaSP());
        }
        System.out.println("=============");
        System.out.println(dao.selectListById("1"));
        System.out.println("=============");
        System.out.println(dao.selectById("1", "SP001"));
    }
}
