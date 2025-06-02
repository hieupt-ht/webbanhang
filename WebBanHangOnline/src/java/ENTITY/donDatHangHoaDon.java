/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

import java.util.Date;

/**
 *
 * @author LE KHAC HIEU
 */
public class donDatHangHoaDon {
    private int maDH;
    private String tenKH;
    private Date ngayTaoDH;
    private double tongTien;
    private String trangThai;
    private String diaChi;
    private String nguoiNhan;

    public donDatHangHoaDon() {
    }

    public donDatHangHoaDon(int maDH, String tenKH, Date ngayTaoDH, double tongTien, String trangThai, String diaChi, String nguoiNhan) {
        this.maDH = maDH;
        this.tenKH = tenKH;
        this.ngayTaoDH = ngayTaoDH;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.diaChi = diaChi;
        this.nguoiNhan = nguoiNhan;
    }

    public int getMaDH() {
        return maDH;
    }

    public void setMaDH(int maDH) {
        this.maDH = maDH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Date getNgayTaoDH() {
        return ngayTaoDH;
    }

    public void setNgayTaoDH(Date ngayTaoDH) {
        this.ngayTaoDH = ngayTaoDH;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    
}
