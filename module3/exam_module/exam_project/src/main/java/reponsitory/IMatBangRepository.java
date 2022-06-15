package reponsitory;

import model.LoaiVanPhong;
import model.MatBang;
import model.TrangThai;

import java.util.List;

public interface IMatBangRepository {
    List<MatBang> getAllMatBang();

    List<LoaiVanPhong> getAllLoaiVanPhong();

    List<TrangThai> getAllTrangThai();

    void getCreateMatBang(MatBang matBang);

    void delete(String id);
}
