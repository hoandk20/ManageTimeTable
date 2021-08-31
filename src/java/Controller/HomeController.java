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
import java.time.LocalDate;
import static java.time.LocalDate.from;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;
import model.teacher;

/**
 *
 * @author hoandk
 */
public class HomeController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String mess = "";
        LocalDate today = LocalDate.now();
        LocalDate monday = today.with(previousOrSame(MONDAY));
        LocalDate sunday = today.with(nextOrSame(SUNDAY));
        teacherDAO tDAO = new teacherDAO();
        Date from = Date.valueOf(monday);
        Date to = Date.valueOf(sunday);
        ArrayList<teacher> list = tDAO.getTeacher(from, to);
        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.setAttribute("mess", mess);
        request.setAttribute("list", list);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
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
        String mess = "";
        Date from = Date.valueOf(request.getParameter("from"));
        Date to = Date.valueOf(request.getParameter("to"));
        if (from.compareTo(to) > 0) {
            mess = "From Date must before To Date";
            LocalDate today = LocalDate.now();
            LocalDate monday = today.with(previousOrSame(MONDAY));
            LocalDate sunday = today.with(nextOrSame(SUNDAY));
            teacherDAO tDAO = new teacherDAO();
            from = Date.valueOf(monday);
            to = Date.valueOf(sunday);
        }
        teacherDAO tDAO = new teacherDAO();
        ArrayList<teacher> list = tDAO.getTeacher(from, to);
        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.setAttribute("mess", mess);
        request.setAttribute("list", list);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
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
