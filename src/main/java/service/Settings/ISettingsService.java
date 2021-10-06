package service.Settings;


import model.Company;
import model.Settings;
import service.IGeneralService;

import java.util.List;

public interface ISettingsService extends IGeneralService<Settings> {
    List<Settings> getAll();
    boolean add(Settings settings);
}
