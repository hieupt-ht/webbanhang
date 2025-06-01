/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ENTITY.wishlist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LE KHAC HIEU
 */
public class Daowishlist {
    public List<wishlist> getAllWishlist(int maKH){
        String sql = "select * from WISHLIST where maKH = ?";
        List<wishlist> list = new ArrayList<>();
        try {
             Connection con = CONTEXT.DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
              stmt.setInt(1, maKH);
            ResultSet rs = stmt.executeQuery();
                  while (rs.next()) {
                int maKhachHang = rs.getInt("maKH");
                int maSP = rs.getInt("maSP");
                int maSize = rs.getInt("Sizeno");
                int soLuong = rs.getInt("soLuong");
                double donGia = rs.getDouble("donGia");
                wishlist wl = new wishlist(maKH, maSP, maSize, soLuong, donGia, soLuong*donGia);
                list.add(wl);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public void insertWishlist(int maKH, int maSP, int maSize, int soLuong, double donGia){
        String sql = "insert into WISHLIST values(?, ?, ?, ?, ?)";
          try {
            Connection con = CONTEXT.DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, maKH);
            stmt.setInt(2, maSP);
            stmt.setInt(3, maSize);
            stmt.setInt(4, soLuong);
            stmt.setDouble(5, donGia);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void removeWishlist(int maKH, int maSP){
            String sql = "delete from WISHLIST where maKH = ? and maSP = ?";
        try {
            Connection con = CONTEXT.DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, maKH);
            stmt.setInt(2, maSP);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        Daowishlist d = new Daowishlist();
        List<wishlist> list = d.getAllWishlist(1);
        for(wishlist w : list){
            System.out.println(w);
        }
    }
}
