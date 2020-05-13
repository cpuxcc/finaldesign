package hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class TestSessionFactory {
    //充当的角色"数据源工厂" 一个数据库只对应一个工厂,创建和销毁的成本昂贵
    //负责创建Session [一次会话，和数据库一次连接]
    private static SessionFactory sessionFactory;

    //加载hibernate.cfg.xml
    static {
        //默认到/src/main/resources
        Configuration cfg=new Configuration().configure();
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties())
                .build();

        sessionFactory = cfg.buildSessionFactory(registry);
    }

    public static Session getSession(){
        return null==sessionFactory ? null:sessionFactory.openSession();
    }

    public static void main(String[] args){
        System.out.println(getSession());

    }
}
