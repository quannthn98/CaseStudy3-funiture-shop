package service.Banner;



import dao.Banner.BannerDao;
import dao.Banner.IBannerDao;
import model.Banner;

import java.util.List;

public class BannerService implements IBannerService{
    private IBannerDao bannerDao = new BannerDao();
    @Override
    public List<Banner> getAll() {
        return bannerDao.getAll();
    }

    @Override
    public boolean add(Banner banner) {
        return bannerDao.add(banner);
    }

    @Override
    public List<Banner> selectAll() {
        return null;
    }

    @Override
    public Banner findById(int id) {
        return null;
    }

    @Override
    public boolean save(Banner banner) {
        return false;
    }

    @Override
    public boolean update(int id, Banner banner) {
        return bannerDao.update(id,banner);
    }

    @Override
    public boolean delete(int id) {
        return bannerDao.delete(id);
    }

    @Override
    public Banner finById(int id) {
        return bannerDao.finById(id);
    }

    @Override
    public List<Banner> findByName(String name) {
        return bannerDao.findByName(name);
    }
}
