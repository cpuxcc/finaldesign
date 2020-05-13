package fd.controller;

import fd.entity.GameAbstract;
import fd.service.impl.SearchServiceImpl;
import fd.service.ISearchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchResult extends HttpServlet {
    private ISearchService iSearchService=new SearchServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //..todo 获取筛选条件
        String kind=req.getParameter("kind");
        String plantForm= req.getParameter("plantForm");


        GameAbstract gameAbstract=new GameAbstract();
        //设置
        gameAbstract.setKind(kind);
        gameAbstract.setPlantForm(plantForm);

        //获取
        List<GameAbstract> listResult=iSearchService.searchList(gameAbstract);

        //设置阈值
        req.setAttribute("searchResult",listResult);
        //返回

        req.getRequestDispatcher("/jsp/search_info.jsp").forward(req,resp);

    }
}
