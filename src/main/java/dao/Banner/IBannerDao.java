package dao.Banner;

import dao.IGeneralDao;
import model.Banner;

import java.util.List;

public interface IBannerDao extends IGeneralDao<Banner> {
 boolean add(Banner banner);
 Banner finById(int id);
 List<Banner> findByName(String name);
 }
