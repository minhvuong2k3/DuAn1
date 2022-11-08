/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author duong
 */
public class KhachHang {
    private String maKH;
    private String ten;
    private String sdt;
    private String email;

    public KhachHang() {
    }

    public KhachHang(String maKH, String ten, String sdt, String email) {
        this.maKH = maKH;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
    }
    
    @Override
    public String toString() {
        return maKH+", "+ten+", "+sdt+", "+email;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
