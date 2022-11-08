/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author duong
 */
public class NhaCungCap {
    private String maNCC;
    private String tenNCC;
    private String sdt;
    private String email;
    private String diachi;

    public NhaCungCap() {
    }

    public NhaCungCap(String maNCC, String tenNCC, String sdt, String email, String diachi) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.sdt = sdt;
        this.email = email;
        this.diachi = diachi;
    }
    
    @Override
    public String toString() {
        return maNCC +", "+tenNCC+", "+sdt+", "+email+", "+diachi;
    }
    
    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
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

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    
    
}
