/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import ENTITY.SanPham;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author ThankPad
 */
public class DAO {
    Connection c;
    CallableStatement stmt;
    ResultSet rs;

    public DAO() {
        this.c = null;
        this.stmt = null;
        this.rs = null;
    }
    
    public List<SanPham> getAllSanPham() {
       List<SanPham> list = new ArrayList<SanPham>();
       String sql = "{call sp_SanPham_GetAll}";
       try {
           c = CONTEXT.DatabaseConnection.getConnection();
           stmt = c.prepareCall(sql);
           rs = stmt.executeQuery();
           
           while(rs.next()) {
               SanPham sp = new SanPham(
                       rs.getString("maSP"),
                       rs.getString("tenSp"),
                       rs.getDouble("donGiaBan"),
                       rs.getInt("soLuongHienCon"),
                       rs.getString("linkAnh")
               );
               list.add(sp);
           }
       } catch( Exception e) {
           e.printStackTrace();
       }
       return list;
    }
    
    public static void main(String[] args) {
        DAO dao = new DAO();
        List<SanPham> list = dao.getAllSanPham();
        
        for(SanPham sp : list) {
            System.out.println(sp);
        }
    }
}
