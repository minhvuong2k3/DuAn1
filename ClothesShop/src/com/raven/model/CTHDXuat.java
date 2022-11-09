/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author duong
 */
public class CTHDXuat {
    private int soPhieu;
    private String maSP;
    private int soLuong;
    private int giamGia;

    public CTHDXuat() {
    }

    public CTHDXuat(String maSP, int soLuong, int giamGia) {
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.giamGia = giamGia;
    }

    public CTHDXuat(int soPhieu, String maSP, int soLuong, int giamGia) {
        this.soPhieu = soPhieu;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.giamGia = giamGia;
    }
    
    @Override
    public String toString() {
        return soPhieu+", "+maSP+", "+soLuong+", "+giamGia;
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

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }
    
    
}
