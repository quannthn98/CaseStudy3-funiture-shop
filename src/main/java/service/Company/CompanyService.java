package service.Company;

import dao.Company.CompanyDao;
import dao.Company.ICompanyDao;
import model.Company;

import java.util.List;

public class CompanyService implements ICompanyService{
    private ICompanyDao companyDao = new CompanyDao();
    @Override
    public List<Company> getAll() {
        return companyDao.getAll();
    }

    @Override
    public boolean add(Company company) {
        return companyDao.add(company);
    }

    @Override
    public List<Company> findByName(String name) {
        return companyDao.findByName(name);
    }

    @Override
    public List<Company> selectAll() {
        return null;
    }

    @Override
    public Company findById(int id) {
        return companyDao.findById(id);
    }

    @Override
    public boolean save(Company company) {
        return false;
    }

    @Override
    public boolean update(int id, Company company) {
        return companyDao.update(id,company);
    }

    @Override
    public boolean delete(int id) {
        return companyDao.delete(id);
    }
}
