/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.main;

import com.raven.DAO.KhachHangDAO;
import com.raven.DAO.RoleDAO;
import com.raven.model.KhachHang;
import java.util.List;

public class NewClass {

    static KhachHangDAO dao = new KhachHangDAO();
    static RoleDAO roleDao = new RoleDAO();
    static KhachHang list = dao.selectTop1();
    static KhachHang last = dao.selectTop1();

    public static void main(String[] args) {
        System.out.println(String.valueOf(Integer.parseInt("1")));
        int a = Integer.parseInt(last.getMaKH().substring(2))+1;
    }
}
