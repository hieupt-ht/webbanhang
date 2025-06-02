/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author LE KHAC HIEU
 */
public class gioHang {
    private int maKH, maSp, maSize, soLuong;
    private double donGia;
    private double tongTien;
    private int maGH;

    public gioHang() {
    }

    public gioHang( int maGH, int maKH, int maSp, int maSize, int soLuong, double donGia, double tongTien) {
        this.maKH = maKH;
        this.maSp = maSp;
        this.maSize = maSize;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tongTien = tongTien;
        this.maGH = maGH;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }

    public int getMaSize() {
        return maSize;
    }

    public void setMaSize(int maSize) {
        this.maSize = maSize;
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

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getMaGH() {
        return maGH;
    }

    public void setMaGH(int maGH) {
        this.maGH = maGH;
    }

    @Override
    public String toString() {
        return "gioHang{" + "maKH=" + maKH + ", maSp=" + maSp + ", maSize=" + maSize + ", soLuong=" + soLuong + ", donGia=" + donGia + ", tongTien=" + tongTien + ", maGH=" + maGH + '}';
    }


    
}
