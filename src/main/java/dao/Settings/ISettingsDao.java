package dao.Settings;


import dao.IGeneralDao;
import model.Company;
import model.Settings;

import java.util.List;

public interface ISettingsDao extends IGeneralDao<Settings> {
    boolean add(Settings company);
}
