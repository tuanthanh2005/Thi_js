/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package dao;

import context.DbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.TheLoai;

public class TheLoaiDao {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public ArrayList<TheLoai> getAll()
    {
        ArrayList<TheLoai> ds = new ArrayList<>();
        String sql = "select * from theloai";
        conn =new DbContext().getConnection();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ds.add(new TheLoai(rs.getInt(1),rs.getString(2)));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return ds;    
    }
     public static void main(String[] args) {
         TheLoaiDao cDAO = new TheLoaiDao();
         for(TheLoai c: cDAO.getAll())
         {
             System.out.println(c);
         }
    }
}

