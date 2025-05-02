/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author LE KHAC HIEU
 */
public class khachHang {
    private int maKH;
    private int tenKH;
    private String SDT, Email;
    private double soDuTaiKhoan;
    private String diaChi;
    private String gioiTinh;

    public khachHang(int maKH, int tenKH, String SDT, String Email, double soDuTaiKhoan, String diaChi, String gioiTinh) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.SDT = SDT;
        this.Email = Email;
        this.soDuTaiKhoan = soDuTaiKhoan;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
    }

    public khachHang() {
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getTenKH() {
        return tenKH;
    }

    public void setTenKH(int tenKH) {
        this.tenKH = tenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public double getSoDuTaiKhoan() {
        return soDuTaiKhoan;
    }

    public void setSoDuTaiKhoan(double soDuTaiKhoan) {
        this.soDuTaiKhoan = soDuTaiKhoan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
}
