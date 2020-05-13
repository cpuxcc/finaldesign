package fd.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import fd.entity.GameDetail;
import fd.dao.IGameDetailDao;
import fd.util.HibernateTemplates;
import fd.util.ISessionCallBack;

import java.util.List;

public class GameDetailImpl implements IGameDetailDao{
    @Override
    public void save(GameDetail gameDetail) {
        HibernateTemplates.execute(new ISessionCallBack() {
            @Override
            public Object executeGame(Session session) throws HibernateException {
                return session.save(gameDetail);
            }
        });
    }

    @Override
    public GameDetail selectByPrimaryKey(Integer id) {
        return (GameDetail) HibernateTemplates.execute(new ISessionCallBack() {
            @Override
            public Object executeGame(Session session) throws HibernateException {
                String hql="from GameDetail where id =:id";
                Query query=session.createQuery(hql);
                query.setParameter("id",id);
                return query.uniqueResult();
            }
        });
    }

    @Override
    public List<GameDetail> findAll() {
        return (List<GameDetail>) HibernateTemplates.execute(new ISessionCallBack() {
            @Override
            public Object executeGame(Session session) throws HibernateException {
                String hql = "from GameDetail";
                Query query = session.createQuery(hql);
                return query.list();
            }
        });
    }
}
