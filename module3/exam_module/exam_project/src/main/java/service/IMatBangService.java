package service;

import model.LoaiVanPhong;
import model.MatBang;
import model.TrangThai;

import java.util.List;
import java.util.Map;

public interface IMatBangService {
    List<MatBang> getAllMatBang();

    List<TrangThai> getAllTrangThai();

    List<LoaiVanPhong> getAllLoaiVanPhong();

    Map<String, String> getCreateMatBang(MatBang matBang);

    void delete(String id);
}
