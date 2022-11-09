/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author duong
 */
public class HDNhap {
    private int soPhieu;
    private String ngayNhap;
    private String maNCC;
    private String maNV;

    public HDNhap() {
    }

    public HDNhap(String ngayNhap, String maNCC, String maNV) {
        this.ngayNhap = ngayNhap;
        this.maNCC = maNCC;
        this.maNV = maNV;
    }

    public HDNhap(int soPhieu, String ngayNhap, String maNCC, String maNV) {
        this.soPhieu = soPhieu;
        this.ngayNhap = ngayNhap;
        this.maNCC = maNCC;
        this.maNV = maNV;
    }
    
    
    
    @Override
    public String toString() {
        return soPhieu+", "+ngayNhap+", "+maNCC+", "+maNV;
    }

    public int getSoPhieu() {
        return soPhieu;
    }

    public void setSoPhieu(int soPhieu) {
        this.soPhieu = soPhieu;
    }
    
    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    
    
    
}
