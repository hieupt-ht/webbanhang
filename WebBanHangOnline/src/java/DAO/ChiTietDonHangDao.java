/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ENTITY.ChiTietDonHang;
/**
 *
 * @author Windowns 10
 */
public class ChiTietDonHangDao {
    Connection c;
    CallableStatement stmt;
    ResultSet rs;

    public ChiTietDonHangDao() {
        this.c = null;
        this.stmt = null;
        this.rs = null;
    }

    public List<ChiTietDonHang> getAllCTDH(int maAcc){
        List<ChiTietDonHang> list = new ArrayList<ChiTietDonHang>();
        String sql = "SELECT \n" +
                    "    CT.maDH,\n" +
                    "    CT.maSP,\n" +
                    "    SP.tenSP,\n" +
                    "    CT.soLuongDat,\n" +
                    "    CT.donGia,\n" +
                    "    DH.ngayTaoDH,\n" +
                    "    DH.diaChi,\n" +
                    "    DH.SDT,\n" +
                    "    DH.nguoiNhan, \n" +
                    "    S.Size\n" +
                    "FROM Account A\n" +
                    "JOIN KhachHang KH ON A.Email = KH.Email\n" +
                    "JOIN DonDatHang_HoaDon DH ON KH.maKH = DH.KHno\n" +
                    "JOIN ChiTietDonHang CT ON DH.maDH = CT.maDH\n" +
                    "JOIN SanPham SP ON CT.maSP = SP.maSP\n" +
                    "JOIN tbSize S ON CT.Sizeno = S.idSize\n" +
                    "WHERE A.maAcc = ?;";
        try {
            c = CONTEXT.DatabaseConnection.getConnection();
            stmt = c.prepareCall(sql);
            stmt.setInt(1, maAcc);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ChiTietDonHang ctdh = new ChiTietDonHang(
                        rs.getString("maDH"),
                        rs.getString("tenSP"),
                        rs.getInt("soLuongDat"),
                        rs.getDouble("donGia"),
                        rs.getString("Size")
                );
                list.add(ctdh);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<ChiTietDonHang> getCTDHByIdDh(int maDH){
        List<ChiTietDonHang> list = new ArrayList<ChiTietDonHang>();
        String sql = "select \n" +
                    "	c.maDH,\n" +
                    "	sp.tenSP,\n" +
                    "	c.soLuongDat,\n" +
                    "	c.donGia,\n" +
                    "	s.Size\n" +
                    "from\n" +
                    "	ChiTietDonHang c\n" +
                    "join DonDatHang_HoaDon d on c.maDH = d.maDH\n" +
                    "join tbSize s on s.idSize = c.Sizeno\n" +
                    "join SanPham sp on sp.maSP = c.maSP\n" +
                    "where c.maDH = ?";
        try {
            c = CONTEXT.DatabaseConnection.getConnection();
            stmt = c.prepareCall(sql);
            stmt.setInt(1, maDH);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ChiTietDonHang ctdh = new ChiTietDonHang(
                        rs.getString("maDH"),
                        rs.getString("tenSP"),
                        rs.getInt("soLuongDat"),
                        rs.getDouble("donGia"),
                        rs.getString("Size")
                );
                list.add(ctdh);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static void main(String[] args) {
        ChiTietDonHangDao ct = new ChiTietDonHangDao();
        List<ChiTietDonHang> list = ct.getCTDHByIdDh(2);
        for(ChiTietDonHang o : list) {
            System.out.println(o);
        }
    }
}
