package ua.com.delivery.persistence.dao;

import ua.com.delivery.persistence.entity.User;

import java.util.List;

public interface IUserDao {
    //create new user
    void createUser(User user);

    //will return us list all users
    List<User> getListUsers();

    //will return us one user by field
    User getById(Long id);

    //this part will be update our user
    void updateUser(User user);

    //this method will be delete one user
    void deleteUser(User user);
}
