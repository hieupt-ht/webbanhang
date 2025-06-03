/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CONTROL;

import DAO.DaoKhachHang;
import DAO.DaoSanPham;
import DAO.Daowishlist;
import ENTITY.Account;
import ENTITY.SanPham;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletResponse;
import ENTITY.cartProduct;
import java.util.AbstractList;
import javax.servlet.ServletResponse;
import ENTITY.wishlist;

/**
 *
 * @author LE KHAC HIEU
 */
@WebServlet(name = "addWishList", urlPatterns = {"/wishlistcontrol"})
public class wishlistcontroll extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        ArrayList<SanPham> wishList = (ArrayList<SanPham>) session.getAttribute("wishlist");
        if (wishList == null) {
            wishList = new ArrayList<>();
        }
        int idwishlist = Integer.parseInt(request.getParameter("idwishlist"));
        System.out.println(idwishlist);
        DAO.DaoSanPham daosp = new DaoSanPham();
        SanPham sp = daosp.getSpbyId(idwishlist);
        Daowishlist daowishlist = new Daowishlist();
        Account account = (Account) session.getAttribute("acc");
        String email = account.getEmail();
        DaoKhachHang kh = new DaoKhachHang();
        int maKH = kh.selectmaKH(email);
        // add vào database
        if (sp.getDMno() == 2) {
            daowishlist.insertWishlist(maKH, sp.getMaSP(), 4, 1, sp.getDonGia());
        } else {
            daowishlist.insertWishlist(maKH, sp.getMaSP(), 2, 1, sp.getDonGia());
        }

        // tao 1 list mới để lấy các sản phẩn wilist từ database
        Daowishlist daoWishlist = new Daowishlist();
        List<wishlist> list_wilist = daowishlist.getAllWishlist(maKH);
      
        wishList = new ArrayList<>();
        for(wishlist w : list_wilist){
            SanPham s = daosp.getSpbyId(w.getMaSp());
            System.out.println(s);
            wishList.add(s);
            
        }
        session.setAttribute("wishlist", wishList);
        response.sendRedirect("wishlist.jsp");
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
