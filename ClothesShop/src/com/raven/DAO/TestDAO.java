/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.CTHDXuat;
import java.util.List;

/**
 *
 * @author duong 
 */
public class TestDAO {
    public static void main(String[] args) {
        CTHDXuatDAO dao = new CTHDXuatDAO();
        List<CTHDXuat> list = dao.select();
        for(CTHDXuat x: list) {
            System.out.println(x.toString());
        }
        System.out.println(dao.selectByKeyword("2"));
    }
}
