/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author duong
 */
public class CTHDNhap {
    private int soPhieu;
    private String maSP;
    private int soLuong;
    private int giaNhap;

    public CTHDNhap() {
    }

    public CTHDNhap(int soPhieu, String maSP, int soLuong, int giaNhap) {
        this.soPhieu = soPhieu;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
    }
    
    @Override
    public String toString() {
        return soPhieu+", "+maSP+", "+soLuong+", "+giaNhap;
    }
    
    public int getSoPhieu() {
        return soPhieu;
    }

    public void setSoPhieu(int soPhieu) {
        this.soPhieu = soPhieu;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }
}
