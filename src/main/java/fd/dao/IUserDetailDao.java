package fd.dao;

import fd.entity.UserDetail;

import java.util.List;

/**
 * Created by DELL on 2019/1/23.
 */
public interface IUserDetailDao {
    void save(UserDetail userDetail);
    UserDetail selectById(Integer id);
    List<UserDetail> findAll();
    List<UserDetail> findAllBy(Integer id);

}
