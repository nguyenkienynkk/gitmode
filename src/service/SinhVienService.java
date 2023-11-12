/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.SinhVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HÙNG
 */
public class SinhVienService {

    public List<SinhVien> getAll() {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT id, ten_sinh_vien, ten_phong_hoc, diem_toan, diem_ly, diem_hoa FROM SinhVien";
        try (Connection con = DBConect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getDouble(4), rs.getDouble(5),
                        rs.getDouble(6));
                list.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public SinhVien getOne(String id) {
        String sql = "SELECT id, ten_sinh_vien, ten_phong_hoc, diem_toan, "
                + "diem_ly, diem_hoa FROM SinhVien WHERE id = ?";
        try (Connection con = DBConect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new SinhVien(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getDouble(4), rs.getDouble(5),
                        rs.getDouble(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean insert(SinhVien o) {
        if (o == null) {
            return false;
        }
        Integer check = 0;
        String sql = "INSERT SinhVien (id, ten_sinh_vien, ten_phong_hoc, "
                + "diem_toan, diem_ly, diem_hoa) VALUES (NEWID(),?,?,?,?,?)";
        try (Connection con = DBConect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, o.getTenSV());
            ps.setObject(2, o.getPhong());
            ps.setObject(3, o.getToan());
            ps.setObject(4, o.getLy());
            ps.setObject(5, o.getHoa());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public Boolean delete(String id) {
        Integer check = 0;
        String sql = "DELETE SinhVien WHERE id = ?";
        try (Connection con = DBConect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public List<SinhVien> getSearch(Double min, Double max) {
        List<SinhVien> list = new ArrayList<>();
        String sql = """
                     SELECT id, ten_sinh_vien, ten_phong_hoc, diem_toan, diem_ly, diem_hoa, AVG(diem_hoa+diem_ly+diem_toan)/3 AS 'TB' 
                     FROM SinhVien GROUP BY id, ten_sinh_vien, ten_phong_hoc, diem_toan, diem_ly, diem_hoa HAVING AVG(diem_hoa+diem_ly+diem_toan)/3 BETWEEN ? AND ?
                     """;
        try (Connection con = DBConect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, min);
            ps.setObject(2, max);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getDouble(4), rs.getDouble(5),
                        rs.getDouble(6));
                list.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<SinhVien> sortByToan() {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT id, ten_sinh_vien, ten_phong_hoc, diem_toan, diem_ly, diem_hoa FROM SinhVien ORDER BY diem_toan";
        try (Connection con = DBConect.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getDouble(4), rs.getDouble(5),
                        rs.getDouble(6));
                list.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        SinhVienService s = new SinhVienService();
//        List<SinhVien> list = s.getSearch(5.0, 8.0);
//        for (SinhVien o : list) {
//            System.out.println(o);
//        }
        SinhVien sv = s.getOne("30096408-546E-4445-8B7D-1B7DA3D6314B");
        System.out.println(sv);
    }
}
