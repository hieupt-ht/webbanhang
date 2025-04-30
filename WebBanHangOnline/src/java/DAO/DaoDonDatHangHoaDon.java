/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CONTEXT.DatabaseConnection;
import java.sql.Connection;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import java.sql.PreparedStatement;
/**
 *
 * @author LE KHAC HIEU
 */
public class DaoDonDatHangHoaDon {

    public void insertDonDatHangHoaDon(int maKH, String diaChi) {
        String sql = "INSERT INTO DonDatHang_HoaDon (KHno, ngayTaoDH, diaChi) VALUES (?, ?, ?)";
        LocalDate nowdate = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(nowdate);
        
        try {
            java.sql.Connection con = CONTEXT.DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, maKH);
            stmt.setDate(2, sqlDate);
            stmt.setString(3, diaChi);
        } catch (Exception e) {
        }
    }
}
