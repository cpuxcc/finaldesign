package fd.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class HibernateTemplates {
    public static Object execute(ISessionCallBack sessionCallBack){
        Session session= null;
        Transaction tx = null;
        Object obj = null;
        try {
            //1.获取session
            session = HibernateUtil.getSession();
            //2.开始事务
            tx=session.beginTransaction();

            //3.执行CRUD
            //TODO...
            obj=sessionCallBack.executeGame(session);

            //4.提交事务
            tx.commit();
        } catch (HibernateException e) {
            if(null!=tx){
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
            //5.关闭session,释放资源
            if(null!=session){
                session.close();
            }
        }

        return obj;
    }
}
