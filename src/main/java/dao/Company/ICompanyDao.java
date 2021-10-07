package dao.Company;

import dao.IGeneralDao;
import model.Banner;
import model.Company;

import java.util.List;

public interface ICompanyDao extends IGeneralDao<Company> {
    boolean add(Company company);
    List<Company> findByName(String name);
}
