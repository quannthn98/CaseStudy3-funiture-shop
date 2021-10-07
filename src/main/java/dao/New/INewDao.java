package dao.New;

import dao.IGeneralDao;
import model.Company;
import model.News;

import java.util.List;

public interface INewDao extends IGeneralDao<News> {
    boolean add(News news);
    List<News> findByName(String title);
}
