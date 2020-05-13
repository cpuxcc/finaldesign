package fd.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PathListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context= sce.getServletContext();
        String path=context.getContextPath();
        context.setAttribute("path",path);
        System.err.println(path);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
