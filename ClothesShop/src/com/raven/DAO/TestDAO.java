/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.CTHDXuat;
import com.raven.model.NhanVien;
import java.util.List;

/**
 *
 * @author duong 
 */
public class TestDAO {
    public static void main(String[] args) {
        NhanVienDAO dao = new NhanVienDAO();
        List<NhanVien> list = dao.select();
        for(NhanVien x: list) {
            System.out.println(x.toString());
        }
    }
}
