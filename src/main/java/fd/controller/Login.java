package fd.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import fd.dao.IUserDao;
import fd.dao.impl.UserDaoImpl;
import fd.service.impl.NavigationServiceImpl;
import fd.service.INavigationService;
import fd.entity.User;


@WebServlet("/user/login")
public class Login extends HttpServlet {
    private INavigationService iNavigationService=new NavigationServiceImpl();
    private IUserDao iUserDao=new UserDaoImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.err.println("login...");
        String username=req.getParameter("username");
        String pwd=req.getParameter("password");

        User u=new User(username,pwd);
        int loginResult=iNavigationService.Login(u);
        User ut=iUserDao.selectByUserName(username);
        if(1==loginResult){
            User user=new User();
            user.setId(ut.getId());
            user.setUserName(username);
            req.getSession().setAttribute("user",user);
        }
        resp.getWriter().print(loginResult);
    }

}
