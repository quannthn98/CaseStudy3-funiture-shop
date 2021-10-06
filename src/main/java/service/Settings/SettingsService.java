package service.Settings;

import dao.Settings.ISettingsDao;
import dao.Settings.SettingsDao;
import model.Company;
import model.Settings;

import java.util.List;

public class SettingsService implements ISettingsService{
private ISettingsDao settingsDao = new SettingsDao();
    @Override
    public List<Settings> selectAll() {
        return null;
    }

    @Override
    public Settings findById(int id) {
        return settingsDao.findById(id);
    }

    @Override
    public boolean save(Settings settings) {
        return settingsDao.add(settings);
    }

    @Override
    public boolean update(int id, Settings settings) {
        return settingsDao.update(id,settings);
    }

    @Override
    public boolean delete(int id) {
        return settingsDao.delete(id);
    }

    @Override
    public List<Settings> getAll() {
        return settingsDao.getAll();
    }

    @Override
    public boolean add(Settings settings) {
        return settingsDao.add(settings);
    }
}
