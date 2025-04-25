/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CONTROL;

import DAO.DaoSanPham;
import DAO.Daocartproduct;
import ENTITY.cartProduct;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "updatecart", urlPatterns = {"/updatecart"})
public class updatecart extends HttpServlet {

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
        String action = request.getParameter("action");
        if (action.equals("update")) {
            HttpSession session = request.getSession();
            ArrayList<cartProduct> listcart = (ArrayList<cartProduct>) session.getAttribute("gioHang");
            if (listcart == null) {
                listcart = new ArrayList<cartProduct>();
            }
            Daocartproduct dao = new Daocartproduct();
            String ids[] = request.getParameterValues("maSP");
            String soluongs[] = request.getParameterValues("soluong");
            if(ids != null && soluongs != null){
                for(int i = 0; i<= ids.length-1; i++){
                    String idsp = ids[i];
                    cartProduct cartproduct = dao.getCartproductByid(idsp, listcart);
                    cartproduct.setSoLuong(Integer.parseInt(soluongs[i]));
                    cartproduct.setTongTien(Integer.parseInt(soluongs[i])*cartproduct.getDonGia());
                }
            }
            session.setAttribute("gioHang", listcart);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }
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
