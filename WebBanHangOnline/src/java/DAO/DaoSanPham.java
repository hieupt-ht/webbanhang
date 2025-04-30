/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import CONTEXT.DatabaseConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import ENTITY.SanPham;
import ENTITY.cartProduct;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ThankPad
 */
public class DaoSanPham {

    Connection c;
    CallableStatement stmt;
    ResultSet rs;

    public DaoSanPham() {
        this.c = null;
        this.stmt = null;
        this.rs = null;
    }

    public List<SanPham> getAllSanPham() {
        List<SanPham> list = new ArrayList<SanPham>();
        String sql = "select * from SanPham";
        try {
            c = CONTEXT.DatabaseConnection.getConnection();
            stmt = c.prepareCall(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                SanPham sp = new SanPham(
                        rs.getString("maSP"),
                        rs.getString("tenSp"),
                        rs.getDouble("donGiaBan"),
                        rs.getInt("soLuongHienCon"),
                        rs.getString("linkAnh"),
                        rs.getString("DMno")
                );
                list.add(sp);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public SanPham getSpbyId(String idSpAdd) {
        String sql = "select * from SanPham where maSP = ?";
        SanPham newSp = null;
        try {
            Connection con = CONTEXT.DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, idSpAdd);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String masp = rs.getString("maSp");
                String tensp = rs.getString("tenSP");
                double dongiaban = rs.getDouble("donGiaBan");
                int soluonghienco = rs.getInt("soLuongHienCon");
                String dmno = rs.getString("DMno");
                String linkanh = rs.getString("linkAnh");
                String DMno = rs.getString("DMno");
                newSp = new SanPham(masp, tensp, dongiaban, soluonghienco, linkanh,DMno);
            }
        } catch (Exception e) {
        }
        return newSp;
    }

    public boolean checkIdSp(String id, ArrayList<SanPham> listSp) {
        for (SanPham sp : listSp) {
            if (sp.getMaSP().equals(id)) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<SanPham> removeSpById(String id, ArrayList<SanPham> listSp) {
        for (int i = 0; i <= listSp.size() - 1; i++) {
            if (id.equals(listSp.get(i).getMaSP())) {
                listSp.remove(i);
                break;
            }
        }
        return listSp;
    }

    
    public ArrayList<SanPham> getListspmoi() {
        String sql = "SELECT TOP 10 *\n"
                + "FROM SanPham\n"
                + "ORDER BY MaSP DESC;";
        ArrayList<SanPham> listnewsp = new ArrayList<SanPham>();
        SanPham newSp;
        try {
            Connection con = CONTEXT.DatabaseConnection.getConnection();
            PreparedStatement stmt = con.prepareCall(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String masp = rs.getString("maSp");
                String tensp = rs.getString("tenSP");
                double dongiaban = rs.getDouble("donGiaBan");
                int soluonghienco = rs.getInt("soLuongHienCon");
                String dmno = rs.getString("DMno");
                String linkanh = rs.getString("linkAnh");
                String DMno = rs.getString("DMno");
                newSp = new SanPham(masp, tensp, dongiaban, soluonghienco, linkanh,DMno);
                listnewsp.add(newSp);
            }
        } catch (Exception e) {
        }
        return listnewsp;
    }
    
    public List<SanPham> getSanPhamByDM(String maDM) {
        List<SanPham> list = new ArrayList<SanPham>();
        String sql = "select * from SanPham\n" +
                        "where DMno = ?";
        try {
            c = CONTEXT.DatabaseConnection.getConnection();
            stmt = c.prepareCall(sql);
            stmt.setString(1, maDM);
            rs = stmt.executeQuery();

            while (rs.next()) {
                SanPham sp = new SanPham(
                        rs.getString("maSP"),
                        rs.getString("tenSp"),
                        rs.getDouble("donGiaBan"),
                        rs.getInt("soLuongHienCon"),
                        rs.getString("linkAnh"),
                        rs.getString("DMno")
                );
                list.add(sp);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public List<SanPham> searchSP(String text) {
        List<SanPham> list = new ArrayList<SanPham>();
        String sql = "select * from SanPham\n" +
                        "where tenSP like ?";
        try {
            c = CONTEXT.DatabaseConnection.getConnection();
            stmt = c.prepareCall(sql);
            stmt.setString(1,"%" + text + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                SanPham sp = new SanPham(
                        rs.getString("maSP"),
                        rs.getString("tenSp"),
                        rs.getDouble("donGiaBan"),
                        rs.getInt("soLuongHienCon"),
                        rs.getString("linkAnh"),
                        rs.getString("DMno")
                );
                list.add(sp);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public static void main(String[] args) {
        DaoSanPham dao = new DaoSanPham();
        List<SanPham> list = dao.searchSP("Gucci");

        for (SanPham sp : list) {
            System.out.println(sp);
        }
    }
}
