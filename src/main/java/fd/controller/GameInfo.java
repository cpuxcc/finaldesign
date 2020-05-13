package fd.controller;

import fd.entity.GameDetail;
import fd.dao.IGameDetailDao;
import fd.dao.impl.GameDetailImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/gameInfo")
public class GameInfo extends HttpServlet {
    private IGameDetailDao iGameDetailDao=new GameDetailImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        GameDetail gameDetail=iGameDetailDao.selectByPrimaryKey(Integer.parseInt(id));
        req.setAttribute("game",gameDetail);
        System.out.println(gameDetail);
        req.getRequestDispatcher("/jsp/game_info.jsp").forward(req,resp);

    }
}
