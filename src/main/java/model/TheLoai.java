/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package model;

public class TheLoai {
    private int maloai;
    private String tenloai;

    public TheLoai() {
    }

    public TheLoai(int maloai, String tenloai) {
        this.maloai = maloai;
        this.tenloai = tenloai;
    }

    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    @Override
    public String toString() {
        return "TheLoai{" + "maloai=" + maloai + ", tenloai=" + tenloai + '}';
    }
    
    
    
}
