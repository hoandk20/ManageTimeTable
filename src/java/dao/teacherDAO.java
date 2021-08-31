/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Classes;
import model.room;
import model.slot;
import model.teacher;

/**
 *
 * @author hoandk
 */
public class teacherDAO extends DBContext {

    //get time table of teacher from date to date
    public ArrayList<teacher> getTeacher(Date from, Date to) {
        try {
            ArrayList<teacher> list = new ArrayList<>();
            String sql = "SELECT t.id,t.name,t.slot,t.date,c.name as className,r.RoomName,s.time \n"
                    + "FROM tblTeacher t \n"
                    + "JOIN tblClass c on t.classid=c.id \n"
                    + "JOIN tblRoom r on t.roomid=r.id \n"
                    + "JOIN tblSlot s on t.slot=s.slot\n"
                    + "WHERE t.date BETWEEN ? AND ?\n"
                    + "ORDER by t.date ASC";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, from);
            stm.setDate(2, to);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                teacher t = new teacher();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                t.setDate(rs.getDate("date"));
                t.setSlot(rs.getInt("slot"));
                t.setTime(rs.getString("time"));
                t.setClassName(rs.getString("className"));
                t.setRoom(rs.getString("RoomName"));
                list.add(t);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//get all slot

    public ArrayList<slot> getSlots() {
        try {
            ArrayList<slot> list = new ArrayList<>();
            String sql = "SELECT * FROM tblSlot";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                slot a = new slot();
                a.setSlot(rs.getInt("slot"));
                a.setTime(rs.getString("time"));
                list.add(a);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//get all rooms

    public ArrayList<room> getRooms() {
        try {
            ArrayList<room> list = new ArrayList<>();
            String sql = "SELECT * FROM tblRoom";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                room a = new room();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("RoomName"));
                list.add(a);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//get all classes

    public ArrayList<Classes> getClasses() {
        try {
            ArrayList<Classes> list = new ArrayList<>();
            String sql = "SELECT * FROM tblClass";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Classes a = new Classes();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                list.add(a);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void Insert(Date date, int slot, int room, String name, int classid) {
        try {
            String sql = "INSERT INTO [dbo].[tblTeacher]\n"
                    + "           ([name]\n"
                    + "           ,[slot]\n"
                    + "           ,[classid]\n"
                    + "           ,[roomid]\n"
                    + "           ,[date])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            stm.setInt(2, slot);
            stm.setInt(3, classid);
            stm.setInt(4, room);
            stm.setDate(5, date);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        teacherDAO tDAO = new teacherDAO();
//        Date from = Date.valueOf("2021-07-10");
//        Date to = new Date(2021, 07, 15);
//        ArrayList<teacher> getTeacher = tDAO.getTeacher(from, to);
//        System.out.println(getTeacher.size());

//        ArrayList<Classes> list = tDAO.getClasses();
//        System.out.println(list.size());
        LocalDate today = LocalDate.now();
        LocalDate monday = today.with(previousOrSame(MONDAY));
        LocalDate sunday = today.with(nextOrSame(SUNDAY));
        System.out.println(monday+" "+sunday);
    }

}
