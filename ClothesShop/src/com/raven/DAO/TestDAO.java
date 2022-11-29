/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

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
        SanPhamDAO dao = new SanPhamDAO();
        List<SanPham> list = dao.selectByIdNCC("");
        for(SanPham x: list) {
            System.out.println(x);
        }
    }
}
