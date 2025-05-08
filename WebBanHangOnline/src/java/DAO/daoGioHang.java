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
public class daoGioHang {
    public void insertGioHang(int maKH, int maSP, int soLuong, double donGia){
        String sql = "insert into GIOHANG values(?, ?, ?, ?)";
        try {
            Connection con = CONTEXT.DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, maKH);
            stmt.setInt(2, maSP);
            stmt.setInt(3, soLuong);
            stmt.setDouble(4, donGia);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }
    public List<gioHang> getAllGioHang(int maKH){
        String sql = "select * from GIOHANG";
        List<gioHang> listGioHang = new ArrayList<>();
        try {
            Connection con = CONTEXT.DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int maKhachHang = rs.getInt("maKH");
                int maSP = rs.getInt("maSP");
                int soLuong = rs.getInt("soLuong");
                double donGia = rs.getDouble("donGia");
                gioHang gh= new gioHang(maKH, maSP, soLuong, donGia, soLuong*donGia);
                listGioHang.add(gh);
            }
        } catch (Exception e) {
        }
        return listGioHang;
    }
    public void deleteSP(int maKH, int maSP){
        String sql = "delete from GIOHANG where maKH = ? and maSP = ?";
        try {
            Connection con = CONTEXT.DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, maKH);
            stmt.setInt(2, maSP);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void updateGioHang(int maKH, int maSP, int soLuong, double donGia)
    {
        String sql = "update DONGIA set soLuong = ?, donGia = ? where maKH = ? and maSP = ?";
        try {
            Connection con = CONTEXT.DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, soLuong);
            stmt.setDouble(2, donGia);
            stmt.setInt(3, maKH);
            stmt.setInt(4, maSP);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        daoGioHang gh = new daoGioHang();
        gh.insertGioHang(3, 4, 1, 1929199);
    }
}
