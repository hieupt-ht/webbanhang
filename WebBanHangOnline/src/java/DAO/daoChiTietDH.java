/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.gioHang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import ENTITY.gioHang;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LE KHAC HIEU
 */
public class daoChiTietDH {

    public void insertChiTietDH(int maDH, int maSP, int maSize, int soLuong, double donGia) {
        String sql = "insert into GIOHANG values(?, ?, ?, ?, ?)";
        try {
            Connection con = CONTEXT.DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, maDH);
            stmt.setInt(2, maSP);
            stmt.setInt(3, maSize);
            stmt.setInt(4, soLuong);
            stmt.setDouble(5, donGia);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }
}
