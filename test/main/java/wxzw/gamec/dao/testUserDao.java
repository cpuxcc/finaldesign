package wxzw.gamec.dao;

import org.junit.Test;
import wxzw.gamec.dao.impl.UserDaoImpl;
import wxzw.gamec.entity.User;

import java.util.ArrayList;
import java.util.List;

public class testUserDao {
    private IUserDao iUserDao=new UserDaoImpl();

    @Test
    public void save(){
        List<User> userList=new ArrayList<>();
        for(int i=1;i<=5;i++){
            User user=new User("w"+i,"123");
            userList.add(user);
        }
        for(User u:userList){
            iUserDao.save(u);
        }

    }

    @Test
    public void se(){
        System.err.println(iUserDao.selectByUserName("w1"));
    }

    @Test
    public void all(){
        List<User> userList=iUserDao.findAll();
        if(null!=userList&&userList.size()>0){
            for(User user:userList){
                System.out.println(user);
            }
        }
    }

    @Test
    public void tall(){
        List<User> user=iUserDao.findAllBy(null);
        System.err.println(user);
    }

    @Test
    public void tsave(){

    }
}
