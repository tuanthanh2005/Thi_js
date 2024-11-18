/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.SanPham;

/**
 *
 * @author ADMIN
 */
public class SanPhamDao {

    // Lấy danh sách 6 sản phẩm đầu tiên
    public ArrayList<SanPham> getTop6() {
        ArrayList<SanPham> ds = new ArrayList<>();
        String sql = "select top 6 * from SanPham order by masp desc";

        try (Connection conn = new DbContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ds.add(new SanPham(rs.getInt(1), rs.getString(2), rs.getInt(3),
                                   rs.getString(4), rs.getInt(5), rs.getBoolean(6)));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return ds;
    }

    // Lấy sản phẩm theo mã loại
    public ArrayList<SanPham> laySanPhamTheoCD(int MaLoai) {
        ArrayList<SanPham> ds = new ArrayList<>();
        String sql = "select * from sanpham where maloai=?";

        try (Connection conn = new DbContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, MaLoai);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ds.add(new SanPham(rs.getInt(1), rs.getString(2), rs.getInt(3),
                                       rs.getString(4), rs.getInt(5), rs.getBoolean(6)));
                }
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());
        }
        return ds;
    }

    // Phương thức main để kiểm tra
    public static void main(String[] args) {
        SanPhamDao sDao = new SanPhamDao();
        for (SanPham sp : sDao.getTop6()) {
            System.out.println(sp);
        }
    }
}