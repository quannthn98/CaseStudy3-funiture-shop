package service.New;

import dao.New.INewDao;
import dao.New.NewDao;
import model.News;

import java.util.List;

public class NewService implements INewService{
    private INewDao newDao = new NewDao();
    @Override
    public List<News> selectAll() {
        return newDao.getAll();
    }

    @Override
    public News findById(int id) {
        return newDao.findById(id);
    }

    @Override
    public boolean save(News news) {
        return newDao.add(news);
    }

    @Override
    public boolean update(int id, News news) {
        return newDao.update(id,news);
    }

    @Override
    public boolean delete(int id) {
        return newDao.delete(id);
    }

    @Override
    public List<News> getAll() {
        return newDao.getAll();
    }

    @Override
    public boolean add(News news) {
        return newDao.add(news);
    }

    @Override
    public List<News> findByName(String title) {
        return newDao.findByName(title);
    }
}
