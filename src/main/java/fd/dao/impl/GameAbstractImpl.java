package fd.dao.impl;


import fd.dao.IGameAbstractDao;
import fd.util.HibernateTemplates;
import fd.util.ISessionCallBack;
import fd.entity.GameAbstract;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class GameAbstractImpl implements IGameAbstractDao {

    @Override
    public List<GameAbstract> selectByGA(GameAbstract gameAbstract) {
        return (List<GameAbstract>) HibernateTemplates.execute(new ISessionCallBack() {
            @Override
            public Object executeGame(Session session) throws HibernateException {
                StringBuilder hql=new StringBuilder();
                hql.append("from GameAbstract where 1=1");
                if(null!=gameAbstract.getId()){
                    hql.append(" and id =:id");
                }
                if(null!=gameAbstract.getGameName()){
                    hql.append(" and gameName =:gameName");
                }
                if(null!=gameAbstract.getPlantForm()){
                    hql.append(" and plantForm =:plantForm");
                }
                if(null!=gameAbstract.getKind()){
                    hql.append(" and kind =:kind");
                }

                Query query=session.createQuery(hql.toString());

                if(null!=gameAbstract.getId()){
                    query.setParameter("id",gameAbstract.getId());
                }
                if(null!=gameAbstract.getGameName()){
                    query.setParameter("gameName",gameAbstract.getGameName());
                }
                if(null!=gameAbstract.getPlantForm()){
                    query.setParameter("plantForm",gameAbstract.getPlantForm());
                }
                if(null!=gameAbstract.getKind()){
                    query.setParameter("kind",gameAbstract.getKind());
                }

                return query.list();
            }
        });
    }

    @Override
    public List<GameAbstract> selectNew() {
        return (List<GameAbstract>) HibernateTemplates.execute(new ISessionCallBack() {
            @Override
            public Object executeGame(Session session) throws HibernateException {
                String hql="from GameAbstract order by createDate desc";
                Query query=session.createQuery(hql);
                return query.list();
            }
        });
    }

    @Override
    public List<GameAbstract> selectHighAssess() {
        return (List<GameAbstract>) HibernateTemplates.execute(new ISessionCallBack() {
            @Override
            public Object executeGame(Session session) throws HibernateException {
                String hql="from GameAbstract order by assess desc";
                Query query=session.createQuery(hql);
                return query.list();
            }
        });
    }

    @Override
    public List<GameAbstract> selectHighHeat() {
        return (List<GameAbstract>) HibernateTemplates.execute(new ISessionCallBack() {
            @Override
            public Object executeGame(Session session) throws HibernateException {
                String hql="from GameAbstract order by heat desc";
                Query query=session.createQuery(hql);
                return query.list();
            }
        });
    }

    @Override
    public List<GameAbstract> selectHighHeatLowAssess() {
        return (List<GameAbstract>) HibernateTemplates.execute(new ISessionCallBack() {
            @Override
            public Object executeGame(Session session) throws HibernateException {
                String hql="from GameAbstract order by heat desc,assess asc";
                Query query=session.createQuery(hql);
                return query.list();
            }
        });
    }

    @Override
    public List<GameAbstract> findAll() {
        return (List<GameAbstract>) HibernateTemplates.execute(new ISessionCallBack() {
            @Override
            public Object executeGame(Session session) throws HibernateException {
                String hql="from GameAbstract";
                Query query=session.createQuery(hql);
                return query.list();
            }
        });
    }
}
