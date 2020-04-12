package model.user;

public interface UserDAO {
    User findUserByUsername(String username);
    void addUser(User user);
}
