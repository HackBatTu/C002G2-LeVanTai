package reponsitory.impl;

import model.LoaiVanPhong;
import model.MatBang;
import model.TrangThai;
import reponsitory.DBConnect;
import reponsitory.IMatBangRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatBangRepository implements IMatBangRepository {

    private DBConnect dbConnect = new DBConnect();

    private static final String SELECT_MAT_BANG = " select mat_bang.* ,trang_thai.name_trang_thai,loai_van_phong.name_loai_van_phong from mat_bang " +
            " join trang_thai on mat_bang.id_trang_thai = trang_thai.id_trang_thai " +
            " join loai_van_phong on mat_bang.id_loai_van_phong = loai_van_phong.id_loai_van_phong where mat_bang.status = 0 order by mat_bang.dien_tich;";
    private static final String SELECT_TRANG_THAI = " select * from trang_thai where status =0;";
    private static final String SELECT_VAN_PHONG = " select * from loai_van_phong where status = 0;";
    private static final String DELETE_MAT_BANG = " update mat_bang set status=1 where ma_mat_bang=?;";
    private static final String INSERT_MAT_BANG = " insert into mat_bang(ma_mat_bang,dien_tich,mat_bang.id_trang_thai,tang,mat_bang.id_loai_van_phong,mo_ta,gia,ngay_bat_dau,ngay_ket_thuc) " +
            " value(?,?,?,?,?,?,?,?,?);";

    @Override
    public List<MatBang> getAllMatBang() {
        Connection connection = dbConnect.getConnection();
        List<MatBang> matBangList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MAT_BANG);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("ma_mat_bang");
                double area = resultSet.getDouble("dien_tich");
                int status = resultSet.getInt("id_trang_thai");
                String statusName = resultSet.getString("name_trang_thai");
                int numberOfFloor = resultSet.getInt("tang");
                int loaiVanPhong = resultSet.getInt("id_loai_van_phong");
                String loaiVanPhongName = resultSet.getString("name_loai_van_phong");
                String moTa = resultSet.getString("mo_ta");
                double prince = resultSet.getDouble("gia");

                String dateCheckIn = resultSet.getString("ngay_bat_dau");
                String dateCheckOut = resultSet.getString("ngay_ket_thuc");

                matBangList.add(new MatBang(id,area,new TrangThai(status,statusName),numberOfFloor,new LoaiVanPhong(loaiVanPhong,loaiVanPhongName),moTa,prince, dateCheckIn, dateCheckOut));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matBangList;
    }

    @Override
    public List<LoaiVanPhong> getAllLoaiVanPhong() {
        Connection connection = dbConnect.getConnection();
        List<LoaiVanPhong> loaiVanPhongList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VAN_PHONG);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_loai_van_phong");
                String name = resultSet.getString("name_loai_van_phong");
                loaiVanPhongList.add(new LoaiVanPhong(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loaiVanPhongList;
    }

    @Override
    public List<TrangThai> getAllTrangThai() {
        Connection connection = dbConnect.getConnection();
        List<TrangThai> trangThaiList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TRANG_THAI);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_trang_thai");
                String name = resultSet.getString("name_trang_thai");
                trangThaiList.add(new TrangThai(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trangThaiList;
    }

    @Override
    public void getCreateMatBang(MatBang matBang) {
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(INSERT_MAT_BANG);
            preparedStatement.setString(1,matBang.getId());
            preparedStatement.setDouble(2,matBang.getArea());
            preparedStatement.setInt(3,matBang.getStatus().getId());
            preparedStatement.setInt(4,matBang.getNumberOfFloor());
            preparedStatement.setInt(5,matBang.getLoaiVanPhong().getId());
            preparedStatement.setString(6,matBang.getMoTa());
            preparedStatement.setDouble(7,matBang.getPrince());
            preparedStatement.setString(8,matBang.getDateCheckIn());
            preparedStatement.setString(9,matBang.getDateCheckOut());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MAT_BANG);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
