package fd.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import fd.dao.IUserDao;
import fd.entity.User;
import fd.util.HibernateUtil;
import fd.util.HibernateTemplates;
import fd.util.ISessionCallBack;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public void save(User user){
        HibernateTemplates.execute(new ISessionCallBack() {
            @Override
            public Object executeGame(Session session) throws HibernateException {
                return session.save(user);
            }
        });
       /* //hibernate编程步骤
        //1. 获取session = Connection + Cache[一级缓存]
        Session session = HibernateUtil.getSession();
        //2.开始事务
        Transaction tx = session.beginTransaction();
        //3. 执行CRUD操作
        session.save(User);
        //4. 提交事务
        tx.commit();
        //5. 关闭session
        session.close();//释放资源*/
    }
    @Override
    public User selectByUserName(String username) {
        return (User) HibernateTemplates.execute(new ISessionCallBack() {
            @Override
            public Object executeGame(Session session) throws HibernateException {
                String hql="from User where userName =:username";
                Query query=session.createQuery(hql);
                query.setParameter("username",username);
                return query.uniqueResult();
            }
        });
    }
    @Override
    public List<User> findAll(){
        return (List<User>) HibernateTemplates.execute(new ISessionCallBack() {
            @Override
            public Object executeGame(Session session) throws HibernateException {
                return session.createQuery("from User").list();
            }
        });
        /*//hibernate编程步骤
        //1. 获取session = Connection + Cache[一级缓存]
        Session session = HibernateUtil.getSession();
        //2.开始事务
        Transaction tx = session.beginTransaction();
        //3. 执行CRUD操作
        //session.save(bookType);
        //定义一个hql语句
        String hql = "from User";//面向的是对象的查询语句
        //String sql = "select * from book_type";//sql语句
        //获取 Query查询语句对象
        Query query = session.createQuery(hql);
        List<User> users = query.list();
        //4. 提交事务
        tx.commit();
        //5. 关闭session
        session.close();//释放资源
        return users;*/
    }
    @Override
    public List<User> findAllBy(String user) {
        return (List<User>) HibernateTemplates.execute(new ISessionCallBack() {
            @Override
            public Object executeGame(Session session) throws HibernateException {
                String hql="from User where userName =:username";
                Query query=session.createQuery(hql);
                query.setParameter("username",user);
                return query.list();
            }
        });
    }

}

