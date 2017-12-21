package ua.com.delivery.persistence.dao;

import ua.com.delivery.persistence.entity.User;

import java.util.List;
/**
 * This interface represents a contract for a DAO for the {@link User} model.
 *
 */
public interface IUserDao {
    //create new user
    void createUser(User user);

    //will return us list all users
    List<User> getListUsers();

    //will return us one user by field
    User getById(Long id);

    //will return us one user by username
    User getUserByUsername(String username);

    //this part will be update our user
    User updateUser(User user);

    //this method will be delete one user
    void deleteUserByUsername(String username);
}
