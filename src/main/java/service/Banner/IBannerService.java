package service.Banner;

import dao.IGeneralDao;
import model.Banner;
import service.IGeneralService;

import java.util.List;

public interface IBannerService extends IGeneralService<Banner> {
    List<Banner> getAll();
    boolean add(Banner banner);
    Banner finById(int id);
    List<Banner> findByName(String name);

}
