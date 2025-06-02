/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CONTEXT.DatabaseConnection;
import ENTITY.donDatHangHoaDon;
import java.beans.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author LE KHAC HIEU
 */
public class DaoDonDatHangHoaDon {
    Connection c;
    CallableStatement stmt;
    ResultSet rs;

    public DaoDonDatHangHoaDon() {
        this.c = null;
        this.stmt = null;
        this.rs = null;
    }
    
    public void DeleteDDHHD (int maDH) {
        String sql = "delete from DonDatHang_HoaDon\n" +
                        "where maDH = ?";
        
        try {
           c = CONTEXT.DatabaseConnection.getConnection();
           stmt = c.prepareCall(sql);
           stmt.setInt(1, maDH);
           rs = stmt.executeQuery();
        } catch (Exception e) {
            
        }
    }

    public void insertDonDatHangHoaDon(int maKH, String diaChi, String email, String sdt, String nguoiNhan) {
        String sql = "INSERT INTO DonDatHang_HoaDon (KHno, ngayTaoDH, diaChi, email, SDT, nguoiNhan) VALUES (?, ?, ? ,?, ?, ?)";
        LocalDate nowdate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(nowdate);
        
        try {
            java.sql.Connection con = CONTEXT.DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, maKH);
            stmt.setDate(2, sqlDate);
            stmt.setString(3, diaChi);
            stmt.setString(4, email);
            stmt.setString(5, sdt);
            stmt.setString(6, nguoiNhan);
            stmt.executeUpdate();
        } catch (Exception e) {
        }      
    }
    public List<donDatHangHoaDon> getAllDonDatHangHoaDon_byIdACcc(int maAcc){
        String sql = "SELECT \n" +
                    "    d.maDH, \n" +
                    "    k.tenKH, \n" +
                    "    d.ngayTaoDH, \n" +
                    "    SUM(c.soLuongDat * c.donGia) AS tongTien, \n" +
                    "    d.trangThai\n" +
                    "FROM DonDatHang_HoaDon d\n" +
                    "JOIN KhachHang k ON d.KHno = k.maKH\n" +
                    "JOIN ChiTietDonHang c ON d.maDH = c.maDH\n" +
                    "JOIN Account a ON a.email = k.email\n" +
                    "WHERE a.maAcc = ?\n" +
                    "GROUP BY d.maDH, k.tenKH, d.ngayTaoDH, d.trangThai;";
        List<donDatHangHoaDon> list = new ArrayList<>();
        try {
            Connection con = CONTEXT.DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, maAcc);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int maDH = rs.getInt("maDH");
                String tenKH = rs.getString("tenKH");
                Date ngayTao = rs.getDate("ngayTaoDH");
                double tongTien = rs.getDouble("tongTien");
                String trangThai = rs.getString("trangThai");
                donDatHangHoaDon hd = new donDatHangHoaDon(maDH, tenKH, ngayTao, tongTien, trangThai, "", "");
                list.add(hd);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public int getNewMaDH(){
        String sql = "select top 1 maDH from DonDatHang_HoaDon order by maDH desc";
        int maDH = 0;
        try {
            Connection con = CONTEXT.DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                maDH = rs.getInt("maDH");
            }
        } catch (Exception e) {
        }
        return maDH;
    }
//    public int insertDonDatHangHoaDon(int maKH, String address, String email, String phone, String fullName) {
//    int maDH = -1;
//    String sql = "INSERT INTO DonDatHang (KHno, ngayTaoDH, diaChi, email, SDT, nguoiNhan) VALUES (?, GETDATE(), ?, ?, ?, ?)";
//
//    try (Connection conn = Database.getConnection();
//         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//
//        ps.setInt(1, maKH);
//        ps.setString(2, address);
//        ps.setString(3, email);
//        ps.setString(4, phone);
//        ps.setString(5, fullName);
//
//        ps.executeUpdate();
//
//        // Lấy mã đơn hàng vừa insert
//        ResultSet rs = ps.getGeneratedKeys();
//        if (rs.next()) {
//            maDH = rs.getInt(1);
//        }
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//
//    return maDH;
//}
    public static void main(String[] args) {
            DaoDonDatHangHoaDon dh = new DaoDonDatHangHoaDon();
            List<donDatHangHoaDon> list = dh.getAllDonDatHangHoaDon_byIdACcc(1);
            for(donDatHangHoaDon o : list) {
                System.out.println(o);
            }
        }
}
