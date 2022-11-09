/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author duong
 */
public class HDXuat {
    private int soPhieu;
    private String maNV;
    private String maKH;
    private int thanhTien;
    private String ngayXuat;

    public HDXuat() {
    }

    public HDXuat(String maNV, String maKH, int thanhTien, String ngayXuat) {
        this.maNV = maNV;
        this.maKH = maKH;
        this.thanhTien = thanhTien;
        this.ngayXuat = ngayXuat;
    }

    public HDXuat(int soPhieu, String maNV, String maKH, int thanhTien, String ngayXuat) {
        this.soPhieu = soPhieu;
        this.maNV = maNV;
        this.maKH = maKH;
        this.thanhTien = thanhTien;
        this.ngayXuat = ngayXuat;
    }
    
    @Override
    public String toString() {
        return soPhieu+", "+maKH+", "+thanhTien+", "+ngayXuat;
    }

    public int getSoPhieu() {
        return soPhieu;
    }

    public void setSoPhieu(int soPhieu) {
        this.soPhieu = soPhieu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }
    
    
}
