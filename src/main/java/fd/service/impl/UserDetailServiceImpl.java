package fd.service.impl;

import fd.dao.IUserDetailDao;
import fd.dao.impl.UserDetailDaoImpl;
import fd.entity.UserDetail;
import fd.service.IUserDetailService;

import java.util.List;

public class UserDetailServiceImpl implements IUserDetailService {
    private IUserDetailDao userDetailDao = new UserDetailDaoImpl();
    @Override
    public List<UserDetail> findAll(){
        return userDetailDao.findAll();
    }

}
