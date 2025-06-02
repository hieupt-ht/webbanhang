/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CONTROL;

import DAO.DaoDonDatHangHoaDon;
import DAO.DaoKhachHang;
import ENTITY.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LE KHAC HIEU
 */
@WebServlet(name = "paysanphamonline", urlPatterns = {"/paysanphamonline"})
public class paysanphamonline extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        // Check if session is valid
        if (session == null) {
            System.out.println("Session is null");
            return;
        }

        // Check if idthanhtoan is set
        Integer idthanhtoan = (Integer) session.getAttribute("idthanhtoan");
        if (idthanhtoan == null) {
            System.out.println("idthanhtoan is null");
            return; // Handle the error case
        }

        System.out.println("thanh toan: " + idthanhtoan);

        // Check if account is set
        Account account = (Account) session.getAttribute("acc");
        if (account == null) {
            System.out.println("Account is null");
            return; // Handle the error case
        }

        String email = account.getEmail();
        DaoKhachHang kh = new DaoKhachHang();
        int maKH = kh.selectmaKH(email);
        System.out.println("ma kh: " + maKH);

        DAO.DaoDonDatHangHoaDon dao = new DaoDonDatHangHoaDon();
        dao.updateTrangThai(maKH, idthanhtoan);
        session.removeAttribute("idthanhtoan");
        session.removeAttribute("sum");
        request.setAttribute("result", 1);
        System.out.println("xin chao ban");
        request.getRequestDispatcher("myaccount.jsp").forward(request, response);
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
