package service.Company;

import model.Banner;
import model.Company;
import service.IGeneralService;

import java.util.List;

public interface ICompanyService extends IGeneralService<Company> {
    List<Company> getAll();
    boolean add(Company company);
    List<Company> findByName(String name);
}
