/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.teacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Classes;
import model.room;
import model.slot;

/**
 *
 * @author hoandk
 */
public class AddController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        teacherDAO tDAO = new teacherDAO();
        ArrayList<room> listR = tDAO.getRooms();
        ArrayList<Classes> listC = tDAO.getClasses();
        ArrayList<slot> listS = tDAO.getSlots();

        request.setAttribute("listR", listR);
        request.setAttribute("listC", listC);
        request.setAttribute("listS", listS);
        request.getRequestDispatcher("Add.jsp").forward(request, response);
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
        teacherDAO tDAO = new teacherDAO();
        ArrayList<room> listR = tDAO.getRooms();
        ArrayList<Classes> listC = tDAO.getClasses();
        ArrayList<slot> listS = tDAO.getSlots();

        request.setAttribute("listR", listR);
        request.setAttribute("listC", listC);
        request.setAttribute("listS", listS);
        
        String mess="";
        Date d = Date.valueOf(request.getParameter("date"));
        int slot = Integer.parseInt(request.getParameter("slot"));
        int room = Integer.parseInt(request.getParameter("room"));
        String name = request.getParameter("teacher").trim();
        //if input with empty name
        if(name.isEmpty()){
            mess="Name of teacher can not be blank";
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("Add.jsp").forward(request, response);
            return;
        }
        //if input lang more than 30 character
        if(name.length()>=30){
            mess="Name of teacher can not more than 31 chars";
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("Add.jsp").forward(request, response);
            return;
        }
        int classid = Integer.parseInt(request.getParameter("class"));
        tDAO.Insert(d, slot, room, name, classid);        
        response.sendRedirect("Home");
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
