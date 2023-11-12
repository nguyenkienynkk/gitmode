/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HÙNG
 */
public class SinhVien {

    private String id;
    private String tenSV;
    private String phong;
    private Double toan;
    private Double ly;
    private Double hoa;

    public SinhVien() {
    }

    public SinhVien(String tenSV, String phong, Double toan, Double ly, Double hoa) {
        this.tenSV = tenSV;
        this.phong = phong;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }

    public SinhVien(String id, String tenSV, String phong, Double toan, Double ly, Double hoa) {
        this.id = id;
        this.tenSV = tenSV;
        this.phong = phong;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public Double getToan() {
        return toan;
    }

    public void setToan(Double toan) {
        this.toan = toan;
    }

    public Double getLy() {
        return ly;
    }

    public void setLy(Double ly) {
        this.ly = ly;
    }

    public Double getHoa() {
        return hoa;
    }

    public void setHoa(Double hoa) {
        this.hoa = hoa;
    }

    public Double getDiemTB() {
        return (toan + ly + hoa) / 3;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "tenSV=" + tenSV + ", phong=" + phong + ", toan=" + toan + ", ly=" + ly + ", hoa=" + hoa + getDiemTB() + '}';
    }

}
