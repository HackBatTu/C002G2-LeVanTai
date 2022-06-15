package service.impl;

import model.LoaiVanPhong;
import model.MatBang;
import model.TrangThai;
import reponsitory.IMatBangRepository;
import reponsitory.impl.MatBangRepository;
import service.IMatBangService;

import java.util.List;
import java.util.Map;

public class MatBangService implements IMatBangService {
    private IMatBangRepository iMatBangRepository = new MatBangRepository();

    @Override
    public List<MatBang> getAllMatBang() {
        return iMatBangRepository.getAllMatBang();
    }

    @Override
    public List<TrangThai> getAllTrangThai() {
        return iMatBangRepository.getAllTrangThai();
    }

    @Override
    public List<LoaiVanPhong> getAllLoaiVanPhong() {
        return iMatBangRepository.getAllLoaiVanPhong();
    }

    @Override
    public Map<String, String> getCreateMatBang(MatBang matBang) {
        iMatBangRepository.getCreateMatBang(matBang);
        return null;
    }

    @Override
    public void delete(String id) {
        iMatBangRepository.delete(id);

    }
}
