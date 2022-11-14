/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author duong
 */
public class NhanVien {
    private String maNV;
    private String hoten;
    private Boolean GioiTinh;
    private String NgaySinh;
    private String sdt;
    private String email;
    private Boolean vaiTro;
    private String matKhau;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoten, Boolean GioiTinh, String NgaySinh, String sdt, String email) {
        this.maNV = maNV;
        this.hoten = hoten;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.sdt = sdt;
        this.email = email;
    }
    
    public NhanVien(String maNV, String hoten, Boolean GioiTinh, String NgaySinh, String sdt, String email, Boolean vaiTro, String matKhau) {
        this.maNV = maNV;
        this.hoten = hoten;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.sdt = sdt;
        this.email = email;
        this.vaiTro = vaiTro;
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return maNV+", "+hoten+", "+vaiTro+", "+matKhau;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Boolean getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(Boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
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

    public Boolean getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(Boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    
}
