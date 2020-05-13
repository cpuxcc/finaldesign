package fd.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fd.dao.impl.GameAbstractImpl;
import fd.dao.IGameAbstractDao;
import fd.entity.GameAbstract;

public class Ranking extends HttpServlet {
    private IGameAbstractDao iGameAbstractDao=new GameAbstractImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        GameAbstract gameAbstract=new GameAbstract();
        List<GameAbstract> list=iGameAbstractDao.selectByGA(gameAbstract);
        List<GameAbstract> rl=new ArrayList<>();
        int i=0;
        for(GameAbstract t:list){
            if(i>=20){
                break;
            }
            rl.add(t);
            i++;
        }

        req.setAttribute("rank",rl);

        System.out.println("rank");*/
    }
}
