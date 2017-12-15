package ua.com.delivery.persistence.dao;

import ua.com.delivery.persistence.entity.Administrator;

import java.util.List;

public interface IAdministratorDao {
    //create new administrator
    void createAdministrator(Administrator administrator);

    //will return us list all administrators
    List<Administrator> getListAdministrators();

    //will return us one administrator by field
    Administrator getById(Long id);

    //this part will be update our administrator
    void updateAdministrator(Administrator administrator);

    //this method will be delete one administrator by name
    void deleteAdministratorByUsername(String username);
}
