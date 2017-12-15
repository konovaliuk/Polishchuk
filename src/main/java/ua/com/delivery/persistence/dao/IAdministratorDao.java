package ua.com.delivery.persistence.dao;

import ua.com.delivery.persistence.entity.Administrator;

import java.util.List;

/**
 * This interface represents a contract for a DAO for the {@link Administrator} model.
 */
public interface IAdministratorDao {

    /**
     * Update the given administrator in the database.
     *
     * @param administrator The user to be updated in the database.
     */
    void createAdministrator(Administrator administrator);


    /**
     * Returns a list of all administators from the database ordered by user ID.
     * The list is never null and is empty when the database does not contain any administrator.
     *
     * @return A list of all users from the database ordered by user ID.
     */
    List<Administrator> getListAdministrators();


    //will return us one administrator by field
    Administrator getById(Long id);


    /**
     * Update the given administrator in the database. The user ID must not be null
     *
     * @param administrator The administrator to be updated in the database.
     */
    void updateAdministrator(Administrator administrator);


    /**
     * Delete the given administrator from the database by username.
     *
     * @param username The administrator with this username to be deleted from the database.
     */
    //this method will be delete one administrator by name
    void deleteAdministratorByUsername(String username);
}
