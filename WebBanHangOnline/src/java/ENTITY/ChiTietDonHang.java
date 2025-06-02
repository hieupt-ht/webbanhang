/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author Windowns 10
 */
public class ChiTietDonHang {
    private String maDH;
    private String tenSP;
    private int soLuong;
    private double donGia;
    private String size;

    public ChiTietDonHang() {
    }

    public ChiTietDonHang(String maDH, String tenSP, int soLuong, double donGia, String size) {
        this.maDH = maDH;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.size = size;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ChiTietDonHang{" + "maDH=" + maDH + ", tenSP=" + tenSP + ", soLuong=" + soLuong + ", donGia=" + donGia + ", size=" + size + '}';
    }

    
}
