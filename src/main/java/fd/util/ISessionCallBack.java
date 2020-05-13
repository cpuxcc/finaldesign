package fd.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface ISessionCallBack {
    Object executeGame(Session session) throws HibernateException;
}
