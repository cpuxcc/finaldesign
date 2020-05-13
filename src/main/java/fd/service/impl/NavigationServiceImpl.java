package fd.service.impl;

import fd.service.INavigationService;
import fd.dao.IGameAbstractDao;
import fd.dao.IUserDao;
import fd.dao.impl.GameAbstractImpl;
import fd.dao.impl.UserDaoImpl;
import fd.entity.GameAbstract;
import fd.entity.User;
import java.util.ArrayList;
import java.util.List;

public class NavigationServiceImpl implements INavigationService {
    private IUserDao iUserDao=new UserDaoImpl();
    private IGameAbstractDao iGameAbstractDao=new GameAbstractImpl();
    @Override
    public int Login(User user) {
        System.err.println(user);
        if(null==user){
            return -1;
        }
        User u=iUserDao.selectByUserName(user.getUserName());
        System.err.println(u);
        if(null==u){
            return -1;
        }
        else{
            if(u.getPassWord().equals(user.getPassWord())){
                return 1;
            }
            else {
                return 0;
            }
        }
    }

}
