/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author duong
 */
public class Role {
    private String maNV;
    private boolean vaiTro;
    private String matKhau;

    public Role() {
    }

    public Role(String maNV, boolean vaiTro, String matKhau) {
        this.maNV = maNV;
        this.vaiTro = vaiTro;
        this.matKhau = matKhau;
    }
    
    @Override
    public String toString() {
        return maNV+", "+vaiTro+", "+matKhau;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public boolean getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    
}
