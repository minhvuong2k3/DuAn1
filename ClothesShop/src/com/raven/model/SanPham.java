/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author duong
 */
public class SanPham {
    private String maSP;
    private String tenSP;
    private String anh;
    private int soLuong;
    private int giaBan;
    private String maLH;
    private int giamgia;
    private String maNCC;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String anh, int soLuong, int giaBan, String maLH, int giamgia, String maNCC) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.anh = anh;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.maLH = maLH;
        this.giamgia = giamgia;
        this.maNCC = maNCC;
    }
    
    @Override
    public String toString() {
        return maSP+", "+tenSP+", "+soLuong+", "+giaBan;
    }
    
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public int getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(int giamgia) {
        this.giamgia = giamgia;
    }

    public String getMaLH() {
        return maLH;
    }

    public void setMaLH(String maLH) {
        this.maLH = maLH;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
}
