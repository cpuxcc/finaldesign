package fd.service;

import fd.dao.IUserDao;
import fd.entity.GameAbstract;
import fd.entity.User;
public interface INavigationService {
    /**
     * 登录
     * @param user
     * @return 1成功 0密码错误 -1账号不存在
     */
    int Login(User user);


}
