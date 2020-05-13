package fd.dao;
import fd.entity.User;
import java.util.List;


public interface IUserDao {
    void save(User user);
    User selectByUserName(String username);
    List<User> findAll();
    List<User> findAllBy(String user);

}
