package fd.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import fd.dao.IUserDetailDao;
import fd.dao.impl.UserDetailDaoImpl;
import fd.entity.UserDetail;
import fd.service.IUserDetailService;
import fd.service.impl.UserDetailServiceImpl;

@WebServlet(urlPatterns = "/user_info")
public class User_info extends HttpServlet{
    private IUserDetailDao iUserDetailDao = new UserDetailDaoImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

//        List<UserDetail> userDetail=iUserDetailDao.findAll();
//        if(null!=userDetail&&userDetail.size()>0){
//            for (UserDetail u:userDetail){
//                System.out.println(u);
//            }
//        }
        //UserDetail userDetail=new UserDetail();
        Integer id = Integer.valueOf(req.getParameter("id"));


        List<UserDetail> userDetail = iUserDetailDao.findAllBy(id);
        req.setAttribute("userDetail",userDetail);
        req.getRequestDispatcher("/jsp/user_info.jsp").forward(req,resp);
    }
}
