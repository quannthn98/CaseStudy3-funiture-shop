package service.New;

import model.Company;
import model.News;
import service.IGeneralService;

import java.util.List;

public interface INewService extends IGeneralService<News> {
    List<News> getAll();
    boolean add(News news);
    List<News> findByName(String title);
}
